package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @Author: 王轩
 * @Description: 商品信息
 * @Date: 2019/2/16
 */

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增
    private Integer id; // 主键

    @NotNull
    @ManyToOne(cascade={CascadeType.MERGE}, fetch= FetchType.EAGER)
    @JoinColumn(name="restId") // 外键设置为rest_id
    private Restaurant rest;    // 餐厅

    @NotNull
    private String name;    // 名字

    @NotNull
    private String type;    // 类型

    @NotNull
    private Double price;   // 价格

    @NotNull
    private Integer amount;     // 数量

    private LocalDate startDate;    // 开始时间

    private LocalDate endDate;      // 结束时间

    @NotNull
    private String image;   // 图片url

    @NotNull
    private String description; // 商品介绍

    public Food() {
    }

    public Food(Restaurant rest, String name, String type, double price, int amount, LocalDate startDate, LocalDate endDate, String image) {
        this.rest = rest;
        this.name = name;
        this.type = type;
        this.price = price;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.image = image;
    }

    public Food(@NotNull Restaurant rest, @NotNull String name, @NotNull String type, @NotNull Double price, @NotNull Integer amount, LocalDate startDate, LocalDate endDate, @NotNull String image, @NotNull String description) {
        this.rest = rest;
        this.name = name;
        this.type = type;
        this.price = price;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.image = image;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Restaurant getRest() {
        return rest;
    }

    public void setRest(Restaurant rest) {
        this.rest = rest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
