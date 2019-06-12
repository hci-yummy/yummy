package com.example.demo.payloads.user;

/**
 * @Author: 许杨
 * @Description:
 * @Date: 2019/6/11
 */
public class ModifyAddressRequest {
    private int aid;

    private String province;

    private String city;

    private String district;

    private String address;

    private String phone;

    private String name;

    public ModifyAddressRequest() {
    }

    public ModifyAddressRequest(int aid, String province, String city, String district, String address, String phone, String name) {
        this.aid = aid;
        this.province = province;
        this.city = city;
        this.district = district;
        this.address = address;
        this.phone = phone;
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
