package com.example.demo.payloads.user;

/**
 * @Author: 许杨
 * @Description:
 * @Date: 2019/6/11
 */
public class AddAddressRequest {
    private String province;

    private String city;

    private String district;

    private String address;

    private String phone;

    private String name;

    public AddAddressRequest() {
    }

    public AddAddressRequest(String province, String city, String district, String address, String phone, String name) {
        this.province = province;
        this.city = city;
        this.district = district;
        this.address = address;
        this.phone = phone;
        this.name = name;
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
