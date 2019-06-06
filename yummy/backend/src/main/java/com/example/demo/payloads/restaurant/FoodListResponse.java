package com.example.demo.payloads.restaurant;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2019/2/17
 */
public class FoodListResponse {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("price")
    private double price;

    @JsonProperty("amount")
    private int amount;

    @JsonProperty("image")
    private String image;

    @JsonProperty("num")
    private int num;

    public FoodListResponse() {
    }

    public FoodListResponse(int id, String name, String type, double price, int amount, String image) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.amount = amount;
        this.image = image;
        this.num = 1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
