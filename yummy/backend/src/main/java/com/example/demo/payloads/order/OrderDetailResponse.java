package com.example.demo.payloads.order;

import com.example.demo.payloads.restaurant.FoodListResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @Author: 王轩
 * @Description: 会员查看订单详情
 * @Date: 2019/2/27
 */
public class OrderDetailResponse {

    @JsonProperty("id")
    private int id;

    @JsonProperty("sum")
    private double sum;

    @JsonProperty("disByLevel")
    private double disByLevel;

    @JsonProperty("disByRest")
    private double disByRest;

    @JsonProperty("fullMoney")
    private double fullMoney;

    @JsonProperty("foodList")
    private List<FoodListResponse> foodList;

    @JsonProperty("isCancel")
    private boolean isCancel;

    @JsonProperty("deliverFee")
    private double deliverFee;

    public OrderDetailResponse(int id, double sum, double disByLevel, double disByRest, double fullMoney, List<FoodListResponse> foodList, boolean isCancel, double deliverFee) {
        this.id = id;
        this.sum = sum;
        this.disByLevel = disByLevel;
        this.disByRest = disByRest;
        this.fullMoney = fullMoney;
        this.foodList = foodList;
        this.isCancel = isCancel;
        this.deliverFee = deliverFee;
    }

    public OrderDetailResponse() {
    }

    public int getId() {
        return id;
    }

    public double getSum() {
        return sum;
    }

    public double getDisByLevel() {
        return disByLevel;
    }

    public double getDisByRest() {
        return disByRest;
    }

    public double getFullMoney() {
        return fullMoney;
    }

    public List<FoodListResponse> getFoodList() {
        return foodList;
    }

    public boolean isCancel() {
        return isCancel;
    }

    public double getDeliverFee() {
        return deliverFee;
    }
}