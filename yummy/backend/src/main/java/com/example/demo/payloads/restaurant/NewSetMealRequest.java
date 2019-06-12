package com.example.demo.payloads.restaurant;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: 王轩
 * @Description: 增加套餐
 * @Date: 2019/2/25
 */
public class NewSetMealRequest {

    private String name;    // 套餐名

    private String restId;  // 餐厅id

    private double price;   // 价格

    private int amount; // 库存数量

    private LocalDate startDate;    // 开始时间

    private LocalDate endDate;  // 结束时间

    private String image;   // 图片url

    private List<FoodInfoInSetMeal> foodList;   // 单品

    public String getName() {
        return name;
    }

    public String getRestId() {
        return restId;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public List<FoodInfoInSetMeal> getFoodList() {
        return foodList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRestId(String restId) {
        this.restId = restId;
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

    public void setFoodList(List<FoodInfoInSetMeal> foodList) {
        this.foodList = foodList;
    }
}
