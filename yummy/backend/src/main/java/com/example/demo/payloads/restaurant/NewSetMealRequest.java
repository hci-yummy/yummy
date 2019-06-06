package com.example.demo.payloads.restaurant;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2019/2/25
 */
public class NewSetMealRequest {

    private String name;

    private String restId;

    private double price;

    private int amount;

    private LocalDate startDate;

    private LocalDate endDate;

    private String image;

    private List<FoodInfoInSetMeal> foodList;

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
}
