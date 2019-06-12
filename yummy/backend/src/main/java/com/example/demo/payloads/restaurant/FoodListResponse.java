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

    @JsonProperty("description")
    private String description;

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

    public FoodListResponse(int id, String name, String type, double price, int amount, String image, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.amount = amount;
        this.image = image;
        this.num = 1;
        this.description = description;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public String getImage() {
        return image;
    }

    public int getNum() {
        return num;
    }

    public String getDescription() {
        return description;
    }
}
