package com.example.demo.service.restaurant.impl;

import com.example.demo.dao.order.OrderRepository;
import com.example.demo.dao.restaurant.*;
import com.example.demo.entity.*;
import com.example.demo.payloads.restaurant.*;
import com.example.demo.service.restaurant.RestService;
import com.example.demo.util.RandomCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2019/2/13
 */

@Service
public class RestServiceImpl implements RestService {
    private RestRepository restRepository;
    private FoodRepository foodRepository;
   /* private SetMealRepository setMealRepository;
    private SetMealInfoRepository setMealInfoRepository;*/
    private DiscountRepository discountRepository;
    private OrderRepository orderRepository;
//    private ModifyInfoRepository modifyInfoRepository;

    @Autowired
    public RestServiceImpl(RestRepository restRepository,
                           FoodRepository foodRepository,
                          /* SetMealRepository setMealRepository,
                           SetMealInfoRepository setMealInfoRepository,*/
                           DiscountRepository discountRepository,
//                           ModifyInfoRepository modifyInfoRepository
                           OrderRepository orderRepository){
        this.restRepository = restRepository;
        this.foodRepository = foodRepository;
       /* this.setMealRepository = setMealRepository;
        this.setMealInfoRepository = setMealInfoRepository;*/
        this.discountRepository = discountRepository;
//        this.modifyInfoRepository = modifyInfoRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    // 餐厅注册
    public String register(String restName, String province, String city, String district,  String address, String type, String image) {
        String id = getID();
        Restaurant restaurant = new Restaurant(id, restName, province, city, district, address, type, image);
        restRepository.save(restaurant);
        return id;
    }
    private String getID() {
        String randomCode = RandomCodeUtil.generateUniqueCode();
        return randomCode.substring(0,7);
    }

    @Override
    // 餐厅登录
    public Restaurant login(String id) {
        Optional<Restaurant> optional = restRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    // 新建单品
    public void addNewFood(NewFoodRequest foodRequest) {
        Restaurant rest = new Restaurant();
        rest.setId(foodRequest.getRestId());
        Food food = new Food(rest,
                            foodRequest.getName(),
                            foodRequest.getType(),
                            foodRequest.getPrice(),
                            foodRequest.getAmount(),
                            foodRequest.getStartDate(),
                            foodRequest.getEndDate(),
                            foodRequest.getImage(),
                            foodRequest.getDescription());
        foodRepository.save(food);
    }

    @Override
    // 通过区域查看餐厅  城市
    public List<FindRestByDistResponse> getRestByDistrict(String province, String city, String district) {

        List<Restaurant> restList = restRepository.findDistinctByProvinceAndCityAndUsable(province, city, true);

        ArrayList<FindRestByDistResponse> rests = new ArrayList<>();

        if(restList != null) {
            for(Restaurant r: restList) {
                FindRestByDistResponse restResponse = new FindRestByDistResponse();
                int time = 50;
                double fee = 10;
                restResponse.setId(r.getId());
//                restResponse.setAddress(r.getAddress());
                restResponse.setName(r.getName());
                restResponse.setType(r.getType());
                if(r.getDistrict().equals(district)) {
                    time = 30;
                    fee = 5;
                }
                restResponse.setTime(time);
                restResponse.setFee(fee);
                restResponse.setImage(r.getImage());
                restResponse.setStars(r.getStars());
//                restResponse.setDistrict(r.getDistrict());
                restResponse.setPerson(r.getEvaluationNum());

                rests.add(restResponse);
            }
        }

        return rests;
    }

    @Override
    // 得到商品及套餐
    public List<FoodListResponse> getFoodList(String id) {
        LocalDate now = LocalDate.now();

        List<Food> foods = foodRepository.getFoodByDate(id, now);

        ArrayList<FoodListResponse> foodList = new ArrayList<>();

        if(foods != null) {
            for(Food f: foods) {
                FoodListResponse response = new FoodListResponse(f.getId(), f.getName(), f.getType(), f.getPrice(), f.getAmount(), f.getImage(), f.getDescription());
                foodList.add(response);
            }
        }

        return foodList;
    }

    @Override
    // 增加套餐  description
    public void setNewSetMeal(NewSetMealRequest setMealRequest) {
        String restId = setMealRequest.getRestId();
        String s_name = setMealRequest.getName();
        double s_price = setMealRequest.getPrice();
        int amount = setMealRequest.getAmount();
        LocalDate startDate = setMealRequest.getStartDate();
        LocalDate endDate = setMealRequest.getEndDate();
        String image = setMealRequest.getImage();
        List<FoodInfoInSetMeal> foodList = setMealRequest.getFoodList();
        String description = "";
        if(foodList != null)
        for(FoodInfoInSetMeal info : foodList) {
            description = description + "  " + info.getName() + " x " + info.getNum();
        }
        if(description.length() > 2) {
            description = description.substring(2);
        }

        Restaurant restaurant = new Restaurant();
        restaurant.setId(restId);

        /*SetMeal setMeal = new SetMeal(restaurant, s_name, s_price, amount, startDate, endDate, image, description);
        SetMeal newSetMeal = setMealRepository.save(setMeal);
*/
        Food f = new Food(restaurant, s_name, "套餐", s_price, amount, startDate, endDate, image, description);
        foodRepository.save(f);

        /*for(FoodInfoInSetMeal foodInfo: foodList) {
            int f_id = foodInfo.getId();
            int num = foodInfo.getNum();

            Food food = new Food();
            food.setId(f_id);

           *//* SetMealInfo setMealInfo = new SetMealInfo(newSetMeal, food, num);
            setMealInfoRepository.save(setMealInfo);*//*
        }*/
    }

    @Override
    // 设置优惠
    public void setDiscount(DiscountInfoResponse discountInfo) {
        LocalDate startDate = discountInfo.getStartDate();
        LocalDate endDate = discountInfo.getEndDate();
        double fullMoney = discountInfo.getFullMoney();
        double disMoney = discountInfo.getDisMoney();

        Restaurant restaurant = new Restaurant();
        restaurant.setId(discountInfo.getRestId());

        Discount discount = new Discount(restaurant, fullMoney, disMoney ,startDate ,endDate);
        discountRepository.save(discount);
    }

    @Override
    // 查看优惠 不显示过期优惠
    public List<DiscountInfoResponse> getDiscountList(String restId) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(restId);
        List<Discount> discounts = discountRepository.findByRestaurant(restaurant);
        LocalDate now = LocalDate.now();

        ArrayList<DiscountInfoResponse> disInfoList = new ArrayList<>();

        if(discounts != null) {
            for(Discount d: discounts) {
                if(d.getEndDate().isBefore(now) || d.getStartDate().isAfter(now)) {
                    continue;
                }
                DiscountInfoResponse response = new DiscountInfoResponse(d.getRestaurant().getId(), d.getFullMoney(), d.getDisMoney(), d.getStartDate(), d.getEndDate());
                disInfoList.add(response);

            }
        }

        return disInfoList;
    }

    @Override
    // 修改商家信息  不经审批
    public void saveInfo(EditRestInfoRequest request) {
        String id = request.getId();
        Restaurant restaurant = restRepository.findById(id).get();

        restaurant.setName(request.getName());
        restaurant.setProvince(request.getProvince());
        restaurant.setCity(request.getCity());
        restaurant.setDistrict(request.getDistrict());
        restaurant.setAddress(request.getCity());
        restaurant.setType(request.getType());
        restaurant.setImage(request.getImageUrl());

        restRepository.save(restaurant);


        /*ModifyInfo modifyInfo = new ModifyInfo(restaurant, name, requestTime, district, address, type);
        modifyInfoRepository.save(modifyInfo);*/

    }

    @Override
    // 计算订单的优惠金额
    public OrderResponse calOrder(CalOrderRequest request) {

        int level = request.getLevel();
        double sum = request.getSum();

        //计算会员等级折扣
        double disOfLevel = getDisBylevel(level);
        double disMoneyOfLevel = sum * (1 - disOfLevel);

        disMoneyOfLevel = (double)Math.round(disMoneyOfLevel * 100) / 100;

        sum -= disMoneyOfLevel;

        //获取当前店铺的优惠
        String restId = request.getRestId();
        List<Discount> discountList = discountRepository.getValidDiscount(restId, LocalDate.now());
        ArrayList<DiscountInfo> discountInfos = new ArrayList<>();

        for(Discount d: discountList) {
           DiscountInfo discountInfo = new DiscountInfo();
           discountInfo.setFullMoney(d.getFullMoney());
           discountInfo.setDisMoney(d.getDisMoney());

           discountInfos.add(discountInfo);
        }

        //对优惠进行降序排序
        Collections.sort(discountInfos, new Comparator<DiscountInfo>() {
            @Override
            public int compare(DiscountInfo o1, DiscountInfo o2) {
                return (int)(o2.getDisMoney() - o1.getDisMoney());
            }
        });

        /*for(DiscountInfo d: discountInfos) {
            System.out.println("满" + d.getFullMoney() + "减" + d.getDisMoney());
        }*/

        //计算满足该店铺的最大优惠
        double fullMoney = 0;
        double disMoneyByRest = 0;
        for(DiscountInfo d: discountInfos) {
            double full = d.getFullMoney();

            if(sum < full) {
                continue;
            } else {
                fullMoney = full;
                disMoneyByRest = d.getDisMoney();
                break;
            }
        }

        sum -= disMoneyByRest;

        sum = (double)Math.round(sum * 100) /100;

        OrderResponse response = new OrderResponse(restId, sum, fullMoney, disMoneyByRest, disMoneyOfLevel);

        return response;
    }

    @Override
    // 查看商家是否通过审批
    public boolean isApproved(String restId) {

        /*Restaurant restaurant = restRepository.findById(restId).get();
        List<ModifyInfo> modifyInfoList = modifyInfoRepository.findByRestaurant(restaurant);

        if(modifyInfoList == null || modifyInfoList.size() == 0) {
            return true;
        }else {
            return false;
        }*/
        return true;
    }

    private double getDisBylevel(int level) {

        double discount = 0;

        switch (level){
            case 1:
                discount = 0.95;
                break;

            case 2:
                discount = 0.9;
                break;

            case 3:
                discount = 0.88;
                break;

            case 4:
                discount = 0.85;
                break;

            case 5:
                discount = 0.8;
                break;
        }

        return discount;
    }

    @Override
    // 查询商家统计信息  yyyy-mm
    public RestStatisticResponse getStatistics(String rid, String start, String end) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.parse(start+"-01 00:00:00", df);
        LocalDateTime endTime = LocalDateTime.parse(end+"-01 23:59:59", df).plusMonths(1L).minusDays(1L);

//        System.out.println("start: " + startTime);
//        System.out.println("end: " + endTime);

        Restaurant restaurant = restRepository.findById(rid).get();

        List<String> monthList = new ArrayList<>();
        List<Integer> orderList = new ArrayList<>();
        List<Double> moneyList = new ArrayList<>();

        while(startTime.isBefore(endTime)) {
//            System.out.println("time: " + startTime);

            List<Orders> ordersList = orderRepository.findDistinctByRestaurantAndOrderTimeBetween(restaurant, startTime, startTime.plusMonths(1L));

            String month = startTime.getYear() + "-" + startTime.getMonthValue();
            if(startTime.getMonthValue() < 10) {
                month = startTime.getYear() + "-0" + startTime.getMonthValue();
            }
            int orderNum = 0;
            double money = 0;
            for(Orders o : ordersList) {
                if(!o.isCancel()) {
                    money = money + o.getSum();
                    orderNum++;
                }
            }

            monthList.add(month);
            orderList.add(orderNum);
            moneyList.add((double)Math.round(money * 100) / 100);

            startTime = startTime.plusMonths(1L);
        }

        return new RestStatisticResponse(monthList, orderList, moneyList);
    }
}
