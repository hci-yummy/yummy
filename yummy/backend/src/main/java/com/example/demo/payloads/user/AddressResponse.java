package com.example.demo.payloads.user;

import com.example.demo.entity.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import sun.plugin2.message.Serializer;

import java.io.Serializable;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2019/2/16
 */
public class AddressResponse{

    @JsonProperty("aid")
    private int aid;

    @JsonProperty("province")
    private String province;

    @JsonProperty("city")
    private String city;

    @JsonProperty("district")
    private String district;

    @JsonProperty("address")
    private String address;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("name")
    private String name;

    public AddressResponse() {
    }

    public AddressResponse(Address address) {
        this.aid = address.getId();
        this.province = address.getProvince();
        this.city = address.getCity();
        this.district = address.getDistrict();
        this.address = address.getAddress();
        this.phone = address.getPhone();
        this.name = address.getName();
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAid() {
        return aid;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
}
