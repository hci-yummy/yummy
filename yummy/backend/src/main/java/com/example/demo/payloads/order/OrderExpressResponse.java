package com.example.demo.payloads.order;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2019/2/27
 */
public class OrderExpressResponse {

    @JsonProperty("oid")
    private int oid;

    @JsonProperty("orderTime")
    private LocalDateTime orderTime;

    @JsonProperty("sum")
    private double sum;

    @JsonProperty("foodList")
    private List<FoodInfo> foodList;

    @JsonProperty("state")
    private String state;

    @JsonProperty("isCancel")
    private boolean isCancel;

    @JsonProperty("memberName")
    private String memberName;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("address")
    private String address;

    @JsonProperty("remark")
    private String remark;

    public OrderExpressResponse() {
    }

    public OrderExpressResponse(int oid, LocalDateTime orderTime, double sum, List<FoodInfo> foodList, String state, boolean isCancel) {
        this.oid = oid;
        this.orderTime = orderTime;
        this.sum = sum;
        this.foodList = foodList;
        this.state = state;
        this.isCancel = isCancel;
    }

    public OrderExpressResponse(int oid, LocalDateTime orderTime, double sum, List<FoodInfo> foodList, String state, boolean isCancel, String memberName, String phone, String address, String remark) {
        this.oid = oid;
        this.orderTime = orderTime;
        this.sum = sum;
        this.foodList = foodList;
        this.state = state;
        this.isCancel = isCancel;
        this.memberName = memberName;
        this.phone = phone;
        this.address = address;
        this.remark = remark;
    }

    public int getOid() {
        return oid;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public double getSum() {
        return sum;
    }

    public List<FoodInfo> getFoodList() {
        return foodList;
    }

    public String getState() {
        return state;
    }

    public boolean isCancel() {
        return isCancel;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getRemark() {
        return remark;
    }
}
