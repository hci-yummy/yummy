package com.example.demo.payloads.restaurant;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 许杨
 * @Description:
 * @Date: 2019/6/10
 */
public class RestStatisticResponse {
    @JsonProperty("monthList")
    private List<String> monthList = new ArrayList<>();
    @JsonProperty("orderList")
    private List<Integer> orderList = new ArrayList<>();
    @JsonProperty("moneyList")
    private List<Double> moneyList = new ArrayList<>();

    public RestStatisticResponse() {
    }

    public RestStatisticResponse(List<String> monthList, List<Integer> orderList, List<Double> moneyList) {
        this.monthList = monthList;
        this.orderList = orderList;
        this.moneyList = moneyList;
    }

    public List<String> getMonthList() {
        return monthList;
    }

    public List<Integer> getOrderList() {
        return orderList;
    }

    public List<Double> getMoneyList() {
        return moneyList;
    }
}
