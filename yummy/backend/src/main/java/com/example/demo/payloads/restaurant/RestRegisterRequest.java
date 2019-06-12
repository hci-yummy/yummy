package com.example.demo.payloads.restaurant;

/**
 * @Author: 王轩
 * @Description: 餐厅注册信息
 * @Date: 2019/2/13
 */
public class RestRegisterRequest {
    private String name;    // 名称

    private String province;    // 省

    private String city;    // 市

    private String district;    // 区

    private String address; // 详细地址

    private String type;    // 类型

    private String imageUrl;    // 头像url

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
