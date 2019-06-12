package com.example.demo.payloads.restaurant;

/**
 * @Author: 王轩
 * @Description: 计算订单优惠后金额
 * @Date: 2019/2/26
 */
public class CalOrderRequest {

    private String restId;  // 餐厅

    private int level;  // 会员等级

    private double sum; // 订单优惠前金额

    public CalOrderRequest() {
    }

    public CalOrderRequest(String restId, int level, double sum) {
        this.restId = restId;
        this.level = level;
        this.sum = sum;
    }

    public String getRestId() {
        return restId;
    }

    public int getLevel() {
        return level;
    }

    public double getSum() {
        return sum;
    }
}
