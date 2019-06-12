package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @Author: 王轩
 * @Description: TODO 会员地址
 * @Date: 2019/2/13
 */

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增
    private Integer id;

    @NotNull
    @ManyToOne(cascade={CascadeType.MERGE}, fetch= FetchType.EAGER)
    @JoinColumn(name="email",referencedColumnName="email") // 外键设置为email
    private Member member;  // 会员

    private String province;

    private String city;

    private String district;    // 区

    private String address; // 详细地址

    private String phone;   // 电话

    private String name;    // 姓名

    private boolean isUsable = true;    // 是否可用

    public Address(){

    }

    public Address(Member member, String district, String address) {
        this.member = member;
        this.district = district;
        this.address = address;
    }

    public Address(@NotNull Member member, String province, String city, String district, String address, String phone, String name) {
        this.member = member;
        this.province = province;
        this.city = city;
        this.district = district;
        this.address = address;
        this.phone = phone;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUsable() {
        return isUsable;
    }

    public void setUsable(boolean usable) {
        isUsable = usable;
    }
}
