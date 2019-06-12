package com.example.demo.controller;

import com.example.demo.entity.Restaurant;
import com.example.demo.payloads.restaurant.*;
import com.example.demo.service.restaurant.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2019/2/13
 */

@RestController
@RequestMapping("/rest")
public class RestaurantController {

    private RestService restService;

    @Autowired
    public RestaurantController(RestService restService){
        this.restService = restService;
    }

    @PostMapping("/register")
    // 餐厅注册   省、市、图片url
    public String register(@RequestBody RestRegisterRequest restRegisterRequest){
        return restService.register(restRegisterRequest.getName(), restRegisterRequest.getProvince(), restRegisterRequest.getCity(), restRegisterRequest.getDistrict(), restRegisterRequest.getAddress(), restRegisterRequest.getType(), restRegisterRequest.getImageUrl());
    }

    @GetMapping("/login")
    // 餐厅登录
    public Restaurant login(String id){return restService.login(id);}

    @PostMapping("/new_food")
    // 新建单品  详情
    public void addNewFood(@RequestBody NewFoodRequest foodRequest){restService.addNewFood(foodRequest);}

    @GetMapping("/get_rests")
    // 通过区域查看餐厅  城市
    public List<FindRestByDistResponse> getRestByDistrict(String province, String city, String district){return restService.getRestByDistrict(province, city, district);}

    @GetMapping("/get_food_list")
    // 得到商品及套餐
    public List<FoodListResponse> getFoodList(String id){
        return restService.getFoodList(id);
    }

    @PostMapping("/new_setmeal")
    // 新建套餐
    public void setNewSetMeal(@RequestBody NewSetMealRequest setMealRequest){
        restService.setNewSetMeal(setMealRequest);
    }

    @GetMapping("/get_discount_list")
    // 查看优惠  已结束优惠不再显示
    public List<DiscountInfoResponse> getDiscountList(String restId){return restService.getDiscountList(restId);}

    @PostMapping("/set_discount")
    // 新加优惠
    public void setDiscount(@RequestBody DiscountInfoResponse discount){
        restService.setDiscount(discount);
    }

    @PostMapping("/save_info")
    // 修改商家信息   地址：省、市、区、详细  商家图片
    public void saveInfo(@RequestBody EditRestInfoRequest request){restService.saveInfo(request);}

    @PostMapping("/cal_order")
    // 计算订单优惠后金额
    public OrderResponse calOrder(@RequestBody CalOrderRequest request){
        return restService.calOrder(request);
    }

    @GetMapping("/is_approved")
    // 查询商家是否通过审批
    public boolean isApproved(String restId) {return restService.isApproved(restId);}

    @GetMapping("/get_statistics")
    // 查询商家统计信息  yyyy-mm
    public RestStatisticResponse getStatistics(String rid, String start, String end) {
        return restService.getStatistics(rid, start, end);
    }
}
