package com.example.demo.payloads.restaurant;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author: 王轩
 * @Description: 查看餐厅的列表显示内容
 * @Date: 2019/2/17
 */
public class FindRestByDistResponse {

    @JsonProperty("rid")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    /*@JsonProperty("district")
    private String district;

    @JsonProperty("address")
    private String address;*/

    @JsonProperty("time")
    private String time;   // 配送时间(min)

    @JsonProperty("price")
    private String fee; // 配送费(￥)

    @JsonProperty("url")
    private String image;   // 餐厅图片url

    @JsonProperty("rate")
    private double stars;   // 评星

    @JsonProperty("person")
    private int person; // 评价人数

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public void setAddress(String address) {
//        this.address = address;
//    }

    public void setTime(int time) {
        this.time = time + "分钟";
    }

    public void setFee(double fee) {
        this.fee = "￥" + fee;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setStars(double stars) {
        this.stars = (double)Math.round(stars*10)/10;
    }

    /*public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }*/

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

   /* public String getAddress() {
        return address;
    }*/

    public String getTime() {
        return time;
    }

    public String getFee() {
        return fee;
    }

    public String getImage() {
        return image;
    }

    public double getStars() {
        return stars;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }
}
