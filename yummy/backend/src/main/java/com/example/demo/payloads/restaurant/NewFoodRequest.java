package com.example.demo.payloads.restaurant;

import java.time.LocalDate;

/**
 * @Author: 王轩
 * @Description: 新建商品
 * @Date: 2019/2/16
 */
public class NewFoodRequest {
    private String restId;  // 餐厅id

    private String name;

    private String type;

    private double price;

    private int amount;

    private LocalDate startDate;

    private LocalDate endDate;

    private String image;

    private String description;

    public void setRestId(String restId) {
        this.restId = restId;
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

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRestId() {
        return restId;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}
