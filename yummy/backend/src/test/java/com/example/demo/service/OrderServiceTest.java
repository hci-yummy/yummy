package com.example.demo.service;

import com.example.demo.entity.Orders;
import com.example.demo.payloads.order.*;
import com.example.demo.service.order.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 许杨
 * @Description:
 * @Date: 2019/6/10
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void addNewOrder() {
        String email = "479026126@qq.com";
        String restId = "e6797b0";
        double sum = 10;
        FoodInfo foodInfo = new FoodInfo();
        foodInfo.setId(1);
        foodInfo.setName("测试单品1");
        foodInfo.setNum(1);
        List<FoodInfo> foodList = new ArrayList<>();
        foodList.add(foodInfo);
        double disByLevel = 0;
        double disByRest = 0;
        double fullMoney = 10;
        String address = "鼓楼区  汉口路22号";
        String phone = "18260199930";
        String remark = "";  // 备注
        NewOrderRequest request = new NewOrderRequest(email, restId, sum, foodList, disByLevel, disByRest, fullMoney, address, phone, remark);
        orderService.addNewOrder(request);
    }

    @Test
    public void getNotPaidOrders() {
    }

    @Test
    public void getCompleteOrders() {
    }

    @Test
    public void getInvalidOrders() {
    }

    @Test
    public void payOrder() {
        int oid = 2;
        orderService.payOrder(oid);
    }

    @Test
    public void cancelOrder() {
        int oid = 2;
        Orders o = orderService.cancelOrder(oid);
        print(o);
    }
    private void print(Orders o) {
        System.out.println("Orders: ");
        System.out.println("member: " + o.getMember().getUsername());
        System.out.println("restaurant: " + o.getRestaurant().getName());
        System.out.println("address: " + o.getAddress());
        System.out.println("phone: " + o.getPhone());
        System.out.println("sum: " + o.getSum());
        System.out.println("remark: " + o.getRemark());
        System.out.println("disByLevel: " + o.getDisByLevel());
        System.out.println("disByRest: " + o.getDisByRest());
        System.out.println("fullMoney: " + o.getFullMoney());
        System.out.println("orderTime: " + o.getOrderTime());
        System.out.println("isValid: " + o.isValid());
        System.out.println("isPaid: " + o.isPaid());
        System.out.println("isCancel: " + o.isCancel());
        System.out.println("====================");
    }

    @Test
    public void getOrderDetail() {
    }

    @Test
    public void getExpressState() {
        int oid = 2;
        String state = orderService.getExpressState(oid);
        System.out.println("state: " + state);
    }

    @Test
    public void getNotReceiveOrders() {
        String restId = "e6797b0";
        List<OrderExpressResponse> responseList = orderService.getNotReceiveOrders(restId);
        System.out.println("OrderExpressResponse: ");
        for(OrderExpressResponse response : responseList) {
            print(response);
        }
    }
    private void print(OrderExpressResponse response) {
        System.out.println("oid: " + response.getOid());
        System.out.println("orderTime: " + response.getOrderTime());
        System.out.println("sum: " + response.getSum());
        System.out.println("foodList: " + response.getFoodList());
        System.out.println("state: " + response.getState());
        System.out.println("isCancel: " + response.isCancel());
        System.out.println("memberName: " + response.getMemberName());
        System.out.println("phone: " + response.getPhone());
        System.out.println("address: " + response.getAddress());
        System.out.println("remark: " + response.getRemark());
        System.out.println("====================");
    }

    @Test
    public void getNotDeliverOrders() {
    }

    @Test
    public void getDeliveredOrders() {
    }

    @Test
    public void receiveOrder() {
        int oid = 1;
        orderService.receiveOrder(oid);
    }

    @Test
    public void deliverOrder() {
        int oid = 1;
        orderService.deliverOrder(oid);
    }

    @Test
    public void acceptOrder() {
        int oid = 1;
        orderService.acceptOrder(oid);
    }

    @Test
    public void setOrderCancel() {
        int oid = 2;
        orderService.setOrderCancel(oid);
    }

    @Test
    public void agreeCancel() {
        int oid = 2;
        orderService.agreeCancel(oid);
    }

    @Test
    public void getMemberStatistics() {
        String email = "479026126@qq.com";
        List<MemberStatisticsResponse> responses = orderService.getMemberStatistics(email);
        System.out.println("MemberStatisticsResponse list: ");
        for(MemberStatisticsResponse response : responses) {
            print(response);
        }
    }
    private void print(MemberStatisticsResponse response) {
        System.out.println("restName: " + response.getRestName());
        System.out.println("restType: " + response.getRestType());
        System.out.println("orderTime: " + response.getOrderTime());
        System.out.println("foodList: " + response.getFoodList().size());
        System.out.println("sum: " + response.getSum());
        System.out.println("isCancel: " + response.isCancel());
        System.out.println("====================");
    }

    @Test
    public void getRestStatistics() {
        String restId = "e6797b0";
        List<RestStatisticsResponse> responses = orderService.getRestStatistics(restId);
        System.out.println("RestStatisticsResponse list: ");
        for(RestStatisticsResponse response : responses) {
            print(response);
        }
    }
    private void print(RestStatisticsResponse response) {
        System.out.println("username: " + response.getUsername());
        System.out.println("sendAddress: " + response.getSendAddress());
        System.out.println("orderTime: " + response.getOrderTime());
        System.out.println("foodList: " + response.getFoodList().size());
        System.out.println("sum: " + response.getSum());
        System.out.println("isCancel: " + response.isCancel());
        System.out.println("earning: " + response.getEarning());
        System.out.println("====================");
    }

    @Test
    public void evaluateOrder() {
        int oid = 1;
        int grade = 5;
        boolean result = orderService.evaluateOrder(oid, grade);
        System.out.println("result: " + result);
    }
}