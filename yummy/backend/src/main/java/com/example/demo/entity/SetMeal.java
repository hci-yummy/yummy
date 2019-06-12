/*
package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

*/
/**
 * @Author: 王轩
 * @Description: 套餐
 * @Date: 2019/2/24
 *//*


@Entity
public class SetMeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增
    private int id; // 主键

    @NotNull
    @ManyToOne(cascade={CascadeType.MERGE}, fetch= FetchType.EAGER)
    @JoinColumn(name="rest_id") // 外键设置为rest_id
    private Restaurant restaurant;  // 餐厅

    @NotNull
    private String name;    // 套餐名

    @NotNull
    private Double price;   // 价格

    @NotNull
    private Integer amount; // 库存

    @NotNull
    private LocalDate startDate;    // 开始时间

    @NotNull
    private LocalDate endDate;  // 结束时间

    @NotNull
    private String image;   // 图片url

    @NotNull
    private String description; // 介绍

    public SetMeal() {
    }

    public SetMeal(String name, Restaurant restaurant,  double price, int amount, LocalDate startDate, LocalDate endDate, String image) {
        this.name = name;
        this.restaurant = restaurant;
        this.price = price;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.image = image;
    }

    public SetMeal(@NotNull Restaurant restaurant, @NotNull String name, @NotNull Double price, @NotNull Integer amount, @NotNull LocalDate startDate, @NotNull LocalDate endDate, @NotNull String image, @NotNull String description) {
        this.restaurant = restaurant;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.image = image;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
*/
