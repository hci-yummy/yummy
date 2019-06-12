package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @Author: 王轩
 * @Description: 餐厅信息
 * @Date: 2019/2/13
 */

@Entity
public class Restaurant {

    @Id
    private String id;  // 餐厅编号

    @NotNull
    private String name;    // 餐厅名称

    @NotNull
    private String province;    // 省

    @NotNull
    private String city;    // 市

    @NotNull
    private String district;    // 街道

    @NotNull
    private String address;     // 详细地址

    @NotNull
    private String type;        // 类型

    @NotNull
    private boolean usable = true;     // 信息未审批时不可用

    @NotNull
    private String image;   // 图片url

    @NotNull
    private Double stars = 0.0;    // 餐厅评星（1~5，若无评分：-1）

    private int evaluationNum = 0;  // 评价人数

   /* @OneToMany(cascade={CascadeType.MERGE},fetch= FetchType.LAZY)
    @JoinColumn(name="id")
    private Set<Food> foodSet;*/

    public Restaurant() {
    }

    public Restaurant(String id, String name, String district, String address, String type, boolean usable) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.address = address;
        this.type = type;
        this.usable = usable;
    }

    public Restaurant(String id, @NotNull String name, @NotNull String province, @NotNull String city, @NotNull String district, @NotNull String address, @NotNull String type, @NotNull String image) {
        this.id = id;
        this.name = name;
        this.province = province;
        this.city = city;
        this.district = district;
        this.address = address;
        this.type = type;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getStars() {
        return stars;
    }

    public void setStars(Double stars) {
        this.stars = stars;
    }

    public int getEvaluationNum() {
        return evaluationNum;
    }

    public void setEvaluationNum(int evaluationNum) {
        this.evaluationNum = evaluationNum;
    }

    /*public Set<Food> getFoodSet() {
        return foodSet;
    }

    public void setFoodSet(Set<Food> foodSet) {
        this.foodSet = foodSet;
    }*/

}
