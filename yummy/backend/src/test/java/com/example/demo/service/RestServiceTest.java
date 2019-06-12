package com.example.demo.service;

import com.example.demo.entity.Restaurant;
import com.example.demo.payloads.restaurant.*;
import com.example.demo.service.restaurant.RestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2019/2/26
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class RestServiceTest {

    private RestService restService;

    @Autowired
    public void setRestService(RestService restService) {
        this.restService = restService;
    }

    @Test
    public void register() {
        String restName = "测试餐厅";
        String province = "江苏省";
        String city = "南京市";
        String district = "鼓楼区";
        String address = "汉口路1号";
        String type = "快餐";
        String image = "image url";

        String canteenId = restService.register(restName, province, city, district, address, type, image);
        System.out.println("canteen id: " + canteenId);
    }

    @Test
    public void login() {
        Restaurant restaurant = restService.login("1da3409");
        print(restaurant);
    }
    private void print(Restaurant restaurant) {
        System.out.println("restaurant: ");
        System.out.println("id: " + restaurant.getId());
        System.out.println("name: " + restaurant.getName());
        System.out.println("province: " + restaurant.getProvince());
        System.out.println("city: " + restaurant.getCity());
        System.out.println("district: " + restaurant.getDistrict());
        System.out.println("address: " + restaurant.getAddress());
        System.out.println("type: " + restaurant.getType());
        System.out.println("usable: " + restaurant.isUsable());
        System.out.println("image: " + restaurant.getImage());
        System.out.println("stars: " + restaurant.getStars());
        System.out.println("evaluationNum: " + restaurant.getEvaluationNum());
        System.out.println("===============");
    }

    @Test
    public void addNewFood() {
        NewFoodRequest newFoodRequest = new NewFoodRequest();
        newFoodRequest.setRestId("e6797b0");
        newFoodRequest.setName("测试单品1");
        newFoodRequest.setType("主食");
        newFoodRequest.setPrice(10);
        newFoodRequest.setAmount(10);
        newFoodRequest.setStartDate(LocalDate.now());
        newFoodRequest.setEndDate(LocalDate.now().plusDays(10));
        newFoodRequest.setImage("food image 1");
        newFoodRequest.setDescription("the first test food");

        restService.addNewFood(newFoodRequest);
    }

    @Test
    public void getRestByDistrict() {
        String province = "江苏省";
        String city = "南京市";
        String district = "鼓楼区";
        List<FindRestByDistResponse> list = restService.getRestByDistrict(province, city, district);
        System.out.println("FindRestByDistResponse list: ");
        for(FindRestByDistResponse restByDistResponse : list) {
            print(restByDistResponse);
        }
    }
    private void print(FindRestByDistResponse restByDistResponse) {
        System.out.println("id: " + restByDistResponse.getId());
        System.out.println("name: " + restByDistResponse.getName());
        System.out.println("type: " + restByDistResponse.getType());
//        System.out.println("district: " + restByDistResponse.getDistrict());
//        System.out.println("address: " + restByDistResponse.getAddress());
        System.out.println("time: " + restByDistResponse.getTime());
        System.out.println("fee: " + restByDistResponse.getFee());
        System.out.println("image: " + restByDistResponse.getImage());
        System.out.println("stars: " + restByDistResponse.getStars());
        System.out.println("person: " + restByDistResponse.getPerson());
        System.out.println("================");
    }

    @Test
    public void getFoodList() {
        String id = "e6797b0";
        List<FoodListResponse> list = restService.getFoodList(id);
        System.out.println("FoodListResponse list:");
        for(FoodListResponse response : list) {
            print(response);
        }
    }
    private void print(FoodListResponse response) {
        System.out.println("id: " + response.getId());
        System.out.println("name: " + response.getName());
        System.out.println("type: " + response.getType());
        System.out.println("price: " + response.getPrice());
        System.out.println("amount: " + response.getAmount());
        System.out.println("image: " + response.getImage());
        System.out.println("num: " + response.getNum());
        System.out.println("description: " + response.getDescription());
        System.out.println("===================");
    }

    @Test
    public void setNewSetMeal() {
        NewSetMealRequest setMealRequest = new NewSetMealRequest();
        setMealRequest.setName("套餐1");
        setMealRequest.setRestId("e6797b0");
        setMealRequest.setPrice(15);
        setMealRequest.setAmount(10);
        setMealRequest.setStartDate(LocalDate.now());
        setMealRequest.setEndDate(LocalDate.now().plusDays(100));
        setMealRequest.setImage("set meal image 1");
        List<FoodInfoInSetMeal> list = new ArrayList<>();
        FoodInfoInSetMeal info = new FoodInfoInSetMeal();
        info.setId(1);
        info.setName("测试单品1");
        info.setNum(2);
        info.setPrice(10);
        list.add(info);
        setMealRequest.setFoodList(list);

        restService.setNewSetMeal(setMealRequest);
    }

    @Test
    public void setDiscount() {
        String restId = "e6797b0";
        double fullMoney = 20;
        double disMoney = 2;
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(100);
        DiscountInfoResponse discountInfo = new DiscountInfoResponse(restId, fullMoney, disMoney, startDate, endDate);
        restService.setDiscount(discountInfo);
    }

    @Test
    public void getDiscountList() {
        String restId = "e6797b0";
        List<DiscountInfoResponse> responseList = restService.getDiscountList(restId);
        System.out.println("DiscountInfoResponse list: ");
        for(DiscountInfoResponse response : responseList) {
            print(response);
        }
    }
    private void print(DiscountInfoResponse response) {
        System.out.println("restId: " + response.getRestId());
        System.out.println("fullMoney: " + response.getFullMoney());
        System.out.println("disMoney: " + response.getDisMoney());
        System.out.println("startDate: " + response.getStartDate());
        System.out.println("endDate: " + response.getEndDate());
        System.out.println("====================");
    }

    @Test
    public void saveInfo() {
        EditRestInfoRequest request = new EditRestInfoRequest();
        request.setId("e6797b0");
        request.setName("测试餐厅1");
        request.setProvince("江苏省");
        request.setCity("南京市");
        request.setDistrict("鼓楼区");
        request.setAddress("汉口路1号");
        request.setType("小吃");
        request.setImageUrl("image url");

        restService.saveInfo(request);
    }

    @Test
    public void calOrder() {
        CalOrderRequest request = new CalOrderRequest("e6797b0", 5, 50);
        OrderResponse response = restService.calOrder(request);
        print(response);
    }
    private void print(OrderResponse response) {
        System.out.println("OrderResponse: ");
        System.out.println("restId: " + response.getRestId());
        System.out.println("sum: " + response.getSum());
        System.out.println("fullMoney: " + response.getFullMoney());
        System.out.println("disMoneyByRest: " + response.getDisMoneyByRest());
        System.out.println("disMoneyByLevel: " + response.getDisMoneyByLevel());
    }

    @Test
    public void getStatistics() {
        String rid = "e6797b0";
        String start = "2018-10";
        String end = "2019-01";
        RestStatisticResponse response = restService.getStatistics(rid, start, end);
        print(response);
    }
    private void print(RestStatisticResponse response) {
        System.out.println("RestStatisticResponse: ");
        System.out.print("month: ");
        for(int i = 0;i < response.getMonthList().size();i++){
            System.out.print(response.getMonthList().get(i) + "  ");
        }
        System.out.println();

        System.out.print("order: ");
        for(int i = 0;i < response.getOrderList().size();i++){
            System.out.print(response.getOrderList().get(i) + "  ");
        }
        System.out.println();

        System.out.print("money: ");
        for(int i = 0;i < response.getMoneyList().size();i++){
            System.out.print(response.getMoneyList().get(i) + "  ");
        }
        System.out.println();
    }


 /*   @Test
    public void getDiscountTest() {
        CalOrderRequest request = new CalOrderRequest("6293602", 1, 10);
        restService.calOrder(request);
    }*/
}
