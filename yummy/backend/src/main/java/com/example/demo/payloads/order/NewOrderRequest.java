package com.example.demo.payloads.order;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2019/2/26
 */
public class NewOrderRequest {

    private String email;

    private String restId;

    private double sum;

    private List<FoodInfo> foodList;

    private double disByLevel;

    private double disByRest;

    private double fullMoney;

    private String receiverName;

    private String address;

    private String phone;   // 电话

    private String remark = "";  // 备注

    private double deliverFee;  // 配送费

    public NewOrderRequest() {
    }

    public NewOrderRequest(String email, String restId, double sum, List<FoodInfo> foodList, double disByLevel, double disByRest, double fullMoney, String address, String phone, String remark, double deliverFee, String receiverName) {
        this.email = email;
        this.restId = restId;
        this.sum = sum;
        this.foodList = foodList;
        this.disByLevel = disByLevel;
        this.disByRest = disByRest;
        this.fullMoney = fullMoney;
        this.address = address;
        this.phone = phone;
        this.remark = remark;
        this.deliverFee = deliverFee;
        this.receiverName = receiverName;
    }

    public String getEmail() {
        return email;
    }

    public String getRestId() {
        return restId;
    }

    public double getSum() {
        return sum;
    }

    public List<FoodInfo> getFoodList() {
        return foodList;
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

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getRemark() {
        return remark;
    }

    public double getDeliverFee() {
        return deliverFee;
    }

    public String getReceiverName() {
        return receiverName;
    }
}
