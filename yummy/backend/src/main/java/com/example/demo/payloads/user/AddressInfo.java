package com.example.demo.payloads.user;

import com.example.demo.entity.Address;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2019/2/25
 */
public class AddressInfo {

    @JsonProperty("id")
    private int id;

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

    public AddressInfo() {
    }

    public AddressInfo(int id, String province, String city, String district, String address, String phone, String name) {
        this.id = id;
        this.province = province;
        this.city = city;
        this.district = district;
        this.address = address;
        this.phone = phone;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getDistrict() {
        return district;
    }

    public String getAddress() {
        return address;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
}
