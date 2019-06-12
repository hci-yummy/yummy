package com.example.demo.service.order.impl;

import com.example.demo.dao.member.AddressRepository;
import com.example.demo.dao.member.MemberRepository;
import com.example.demo.dao.order.ExpressStateRepository;
import com.example.demo.dao.order.OrderInfoRepository;
import com.example.demo.dao.order.OrderRepository;
import com.example.demo.dao.restaurant.FoodRepository;
import com.example.demo.dao.restaurant.RestRepository;
import com.example.demo.entity.*;
import com.example.demo.payloads.order.*;
import com.example.demo.payloads.restaurant.FoodListResponse;
import com.example.demo.service.order.OrderService;
import com.example.demo.util.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2019/2/26
 */
@Service
public class OrderServiceImpl implements OrderService {

    private MemberRepository memberRepository;
    private RestRepository restRepository;
    private FoodRepository foodRepository;
    private OrderRepository orderRepository;
    private OrderInfoRepository orderInfoRepository;
    private ExpressStateRepository expressStateRepository;
    private AddressRepository addressRepository;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,
                            RestRepository restRepository,
                            FoodRepository foodRepository,
                            OrderRepository orderRepository,
                            OrderInfoRepository orderInfoRepository,
                            ExpressStateRepository expressStateRepository,
                            AddressRepository addressRepository) {
        this.memberRepository = memberRepository;
        this.restRepository = restRepository;
        this.foodRepository = foodRepository;
        this.orderRepository = orderRepository;
        this.orderInfoRepository = orderInfoRepository;
        this.expressStateRepository = expressStateRepository;
        this.addressRepository = addressRepository;
    }

    // 下单 备注、地址、电话
    @Override
    public void addNewOrder(NewOrderRequest request) {
        String email = request.getEmail();
        String restId = request.getRestId();
        String addressStr = request.getAddress();
        String phone = request.getPhone();
        double sum = request.getSum();
        double disByLevel = request.getDisByLevel();
        double disByRest = request.getDisByRest();
        double fullMoney = request.getFullMoney();
        LocalDateTime orderDate = LocalDateTime.now();

        Member member = memberRepository.findByEmail(email).get();
        Restaurant restaurant = restRepository.findById(restId).get();
//        Address address = addressRepository.findById(aid).get();
//        String addressStr = address.getDistrict() + "  " + address.getAddress();

        // 保存订单
        Orders orders = new Orders(member, restaurant, addressStr, phone, sum, request.getRemark(), disByLevel, disByRest, fullMoney, orderDate, true, false, false);
        Orders newOrder = orderRepository.save(orders);
        int oid = newOrder.getId();

        List<FoodInfo> foodList = request.getFoodList();

        // 保存订单的详细条目
        for(FoodInfo f: foodList) {

            Food food = foodRepository.findById(f.getId()).get();
            int num = f.getNum();

            // 减库存
            int amount = food.getAmount();
            amount -= num;
            food.setAmount(amount);
            foodRepository.save(food);

            OrderInfo orderInfo = new OrderInfo(newOrder, food, num, true);
            orderInfoRepository.save(orderInfo);
        }


        // 倒计时2分钟
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            public void run() {
                Orders theOrder = orderRepository.findById(oid).get();
                if(!theOrder.isPaid()) {
                    // 取消订单
                    theOrder = cancelOrder(oid);
                    orderRepository.save(theOrder);
                }
            }
        };
        timer.scheduleAtFixedRate(task, 120000L, 120000L);

    }

    @Override
    public List<GetOrderResponse> getNotPaidOrders(String email) {
        List<Orders> orders = orderRepository.getNotPaidList(email);
        return getList(orders);
    }

    @Override
    public List<GetOrderResponse> getCompleteOrders(String email) {
        List<Orders> orders = orderRepository.getCompleteList(email);
        return getList(orders);
    }

    @Override
    public List<GetOrderResponse> getInvalidOrders(String email) {

        List<Orders> orders = orderRepository.getInvalidList(email);
        return getList(orders);
    }

    @Override
    // 修改配送状态
    public boolean payOrder(int oid) {
        Orders order = orderRepository.findById(oid).get();
        if(!order.isValid()) {
            return false;
        }else {
            Member member = order.getMember();

            double sum = order.getSum();
            int score = (int)(sum + member.getScore());
            member.setScore(score);
            member.setLevel(calLevel(score));

            double balance = member.getBalance();
            balance -= sum;
            member.setBalance(balance);
            memberRepository.save(member);

            order.setPaid(true);
            order.setValid(true);
            order.setExpressState("等待商家接单");
            orderRepository.save(order);

            /*ExpressState expressState = new ExpressState();
            expressState.setOid(oid);
            expressState.setState("等待商家接单");
            expressStateRepository.save(expressState);*/
            return true;
        }

    }

    @Override
    // 会员查看订单详情
    public OrderDetailResponse getOrderDetail(int oid) {

        Orders order = orderRepository.findById(oid).get();

        double sum = order.getSum();
        double disByLevel = order.getDisByLevel();
        double disByRest = order.getDisByRest();
        double fullMoney = order.getFullMoney();
        boolean isCancel = order.isCancel();

        List<OrderInfo> orderInfos = orderInfoRepository.findByOrder(order);
        ArrayList<FoodListResponse> foodList = new ArrayList<>();
        for(OrderInfo o: orderInfos) {
            FoodListResponse response = new FoodListResponse();

            Food food = o.getFood();
            response.setId(food.getId());
            response.setName(food.getName());
            response.setPrice(food.getPrice());
            response.setNum(o.getNum());

            foodList.add(response);
        }

        OrderDetailResponse orderDetail = new OrderDetailResponse(oid, sum, disByLevel, disByRest, fullMoney, foodList, isCancel);

        return orderDetail;
    }

    @Override
    // 修改配送状态
    public String getExpressState(int oid) {

        /*ExpressState expressState = expressStateRepository.findByOid(oid).get();

        return expressState.getState();*/

        Orders orders = orderRepository.findById(oid).get();
        return orders.getExpressState();
    }

    @Override
    // 查询待接单订单  不显示退订；加上用户姓名、电话、地址、备注
    public List<OrderExpressResponse> getNotReceiveOrders(String restId) {
        List<Orders> orders = orderRepository.getPaidList(restId);

        int index = 0;
        while(index < orders.size()) {
            Orders o = orders.get(index);
            if(o.isCancel() || !o.isValid()) {
                orders.remove(index);
            }else {
                index++;
            }
        }

        return getExpressList(orders, "等待商家接单");

    }

    @Override
    // 餐厅待发货  （加上退订状态）
    public List<OrderExpressResponse> getNotDeliverOrders(String restId) {
        List<Orders> orders = orderRepository.getPaidList(restId);
        List<Orders> orders2 = orderRepository.findCanceledOrders(restId);
        orders.addAll(orders2);
        return getExpressList(orders, "等待商家发货");
    }

    @Override
    public List<OrderExpressResponse> getDeliveredOrders(String restId) {
        List<Orders> orders = orderRepository.getPaidList(restId);
        List<OrderExpressResponse> list1 = getExpressList(orders, "配送中");
        List<OrderExpressResponse> list2 = getExpressList(orders, "已送达");
        list1.addAll(list2);
        Collections.reverse(list1);
        return list1;
    }

    @Override
    // 修改配送状态
    public void receiveOrder(int oid) {

        /*ExpressState state = expressStateRepository.findByOid(oid).get();
        state.setState("等待商家发货");
        expressStateRepository.save(state);*/
        Orders o = orderRepository.findById(oid).get();
        o.setExpressState("等待商家发货");
        orderRepository.save(o);
    }

    @Override
    // 修改配送状态
    public void deliverOrder(int oid) {
        /*ExpressState state = expressStateRepository.findByOid(oid).get();
        state.setState("配送中");
        expressStateRepository.save(state);*/

        Orders o = orderRepository.findById(oid).get();
        o.setExpressState("配送中");
        orderRepository.save(o);
    }

    @Override
    // 修改配送状态
    public void acceptOrder(int oid) {
        /*ExpressState state = expressStateRepository.findByOid(oid).get();
        state.setState("已送达");
        expressStateRepository.save(state);*/

        Orders o = orderRepository.findById(oid).get();
        o.setExpressState("已送达");
        orderRepository.save(o);
    }

    @Override
    // 会员申请退订
    public void setOrderCancel(int oid) {
        Orders orders = orderRepository.findById(oid).get();
        orders.setCancel(true);
        orderRepository.save(orders);
    }

    @Override
    // 修改配送状态
    public void agreeCancel(int oid) {
        // 减库存，改状态
        Orders orders = cancelOrder(oid);

//        orderRepository.findById(oid).get();

        // 退款
        /*ExpressState expressState = expressStateRepository.findByOid(oid).get();
        String state = expressState.getState();*/
        Orders o = orderRepository.findById(oid).get();
        String state = o.getExpressState();
        double percent = OrderUtil.getOrderPercent(state);
        double sum = orders.getSum();
        double cancelMoney = twoBitDouble(sum * percent);
        double returnMoney = twoBitDouble(sum - cancelMoney);

        // 退款
        Member member = orders.getMember();
        double balance = member.getBalance();
        balance += returnMoney;
        member.setBalance(balance);

        // 减积分
        int score = (int)member.getScore();
        score -= (int) returnMoney;
        member.setScore(score);

        // 更新等级
        int level = calLevel(score);
        member.setLevel(level);
        memberRepository.save(member);

        /*double moneyToRest = twoBitDouble(cancelMoney * 0.7);

        Restaurant restaurant = orders.getRestaurant();
        double money = restaurant.getMoney();
        money -= sum * 0.7;
        money += moneyToRest;
        restaurant.setMoney(money);
        restRepository.save(restaurant);*/

    }

    // 修改配送状态
    public Orders cancelOrder(int oid) {
        Orders order = orderRepository.findById(oid).get();
        order.setCancel(true);
        order.setValid(false);
        order.setPaid(false);
        Orders newOrder = orderRepository.save(order);

        // 恢复库存
        List<OrderInfo> orderInfos = orderInfoRepository.findByOrder(order);
        for(OrderInfo o: orderInfos) {
            Food food = o.getFood();
            int num = o.getNum();
            int amount = food.getAmount();
            amount += num;
            food.setAmount(amount);
            foodRepository.save(food);

            o.setValid(false);
            orderInfoRepository.save(o);
        }

        return newOrder;

    }


    @Override
    public List<MemberStatisticsResponse> getMemberStatistics(String email) {

        Member member = memberRepository.findByEmail(email).get();
        List<Orders> orders = orderRepository.findByMember(member);

        ArrayList<MemberStatisticsResponse> list = new ArrayList<>();
        for(Orders o: orders) {
            String restName = o.getRestaurant().getName();
            String restType = o.getRestaurant().getType();
            LocalDateTime orderTime = o.getOrderTime();
            double sum = o.getSum();
            boolean isCancel = o.isCancel();

            List<OrderInfo> orderInfos = orderInfoRepository.findByOrder(o);
            ArrayList<FoodListResponse> foodList = new ArrayList<>();
            for(OrderInfo orderInfo: orderInfos) {
                Food food = orderInfo.getFood();
                int id = food.getId();
                String name = food.getName();
                int num = orderInfo.getNum();
                double price = food.getPrice();
                FoodListResponse foodListResponse = new FoodListResponse();
                foodListResponse.setId(id);
                foodListResponse.setName(name);
                foodListResponse.setNum(num);
                foodListResponse.setPrice(price);
                foodList.add(foodListResponse);
            }

            MemberStatisticsResponse response = new MemberStatisticsResponse(restName, restType, orderTime, foodList, sum, isCancel);
            list.add(response);
        }


        return list;
    }

    @Override
    // 修改配送状态
    public List<RestStatisticsResponse> getRestStatistics(String restId) {

        Restaurant rest = restRepository.findById(restId).get();
        List<Orders> orders = orderRepository.findByRestaurant(rest);

        ArrayList<RestStatisticsResponse> list = new ArrayList<>();
        for(Orders o: orders) {
            String username = o.getMember().getUsername();
            String sendAddress = o.getAddress();
            LocalDateTime orderTime = o.getOrderTime();
//            String sendAddress = address.getDistrict() + " " + address.getAddress();
            double sum = o.getSum();
            boolean isCancel = o.isCancel();
            double earning;
            if(isCancel) {
                /*ExpressState expressState = expressStateRepository.findByOid(o.getId()).get();
                String state = expressState.getState();*/
                String state = o.getExpressState();
                double percent = OrderUtil.getOrderPercent(state);
                earning = twoBitDouble(percent * sum * 0.7);
            }else {
                earning = twoBitDouble(sum * 0.7);
            }

            List<OrderInfo> orderInfos = orderInfoRepository.findByOrder(o);
            ArrayList<FoodListResponse> foodlist = new ArrayList<>();
            for(OrderInfo orderInfo: orderInfos) {
                Food food = orderInfo.getFood();
                FoodListResponse foodListResponse = new FoodListResponse();
                int id = food.getId();
                String name = food.getName();
                int num = orderInfo.getNum();
                double price = food.getPrice();
                foodListResponse.setName(name);
                foodListResponse.setNum(num);
                foodListResponse.setPrice(price);
                foodListResponse.setId(id);
                foodlist.add(foodListResponse);
            }

            RestStatisticsResponse response = new RestStatisticsResponse(username, sendAddress, orderTime, foodlist, sum, isCancel, earning);
            list.add(response);
        }

        return list;
    }

    @Override
    // 评价订单
    public boolean evaluateOrder(int oid, int grade) {
        Orders orders = orderRepository.findById(oid).get();
        if(orders.getGrade() != null) {
            return false;
        }

        orders.setGrade(grade);
        orderRepository.save(orders);

        Restaurant restaurant = orders.getRestaurant();
        double stars = restaurant.getStars();
        int evaluationNum = restaurant.getEvaluationNum();

        stars = (stars * evaluationNum + grade) / (evaluationNum + 1);
        evaluationNum++;

        restaurant.setStars(stars);
        restaurant.setEvaluationNum(evaluationNum);

        restRepository.save(restaurant);

        return true;
    }

    private ArrayList<GetOrderResponse> getList(List<Orders> orders) {
        ArrayList<GetOrderResponse> orderList = new ArrayList<>();
        if(orders != null) {
            for(Orders o: orders) {
                int id = o.getId();
                double sum = o.getSum();
                LocalDateTime orderTime = o.getOrderTime();
                GetOrderResponse response = new GetOrderResponse(id, orderTime, sum);
                orderList.add(response);
            }
        }
        return orderList;
    }

    // 修改配送状态 增加用户信息（姓名、电话、地址、备注）
    private ArrayList<OrderExpressResponse> getExpressList(List<Orders> orders, String info) {
        ArrayList<OrderExpressResponse> orderList = new ArrayList<>();

        for(Orders o: orders) {
            int oid = o.getId();
            /*ExpressState state = expressStateRepository.findByOid(oid).get();
            if(state.getState().equals(info)) {*/
            if(o.getExpressState().equals(info)) {
                List<OrderInfo> orderInfos = orderInfoRepository.findByOrder(o);
                ArrayList<FoodInfo> foodList = new ArrayList<>();
                for(OrderInfo o2: orderInfos) {
                    Food food = o2.getFood();
                    FoodInfo foodInfo = new FoodInfo();
                    foodInfo.setId(food.getId());
                    foodInfo.setName(food.getName());
                    foodInfo.setCost(food.getPrice());
                    foodInfo.setNum(o2.getNum());

                    foodList.add(foodInfo);
                }
                OrderExpressResponse response = new OrderExpressResponse(oid, o.getOrderTime(), o.getSum(), foodList, info, o.isCancel(), o.getMember().getUsername(), o.getPhone(), o.getAddress(), o.getRemark());
                orderList.add(response);
            }
        }

        return orderList;
    }

    private int calLevel(int score) {

        int level;

        if (score <= 100) {
            level = 1;
        }else if(score <= 300) {
            level = 2;
        }else if(score <= 700) {
            level = 3;
        }else if(score <= 1000) {
            level = 4;
        }else{
            level = 5;
        }

        return level;
    }

    private double twoBitDouble(double num) {
        return (double)Math.round(num * 100) / 100;
    }
}
