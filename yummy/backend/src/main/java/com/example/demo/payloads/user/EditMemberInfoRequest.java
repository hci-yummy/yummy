package com.example.demo.payloads.user;

import java.util.List;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2019/2/25
 */
public class EditMemberInfoRequest {

    private String username;

    private String email;

    private String phone;

    private String payPassword;

//    private List<AddressInfo> addressList;

    public EditMemberInfoRequest() {
    }

    public EditMemberInfoRequest(String username, String email, String phone, String payPassword) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.payPassword = payPassword;
//        this.addressList = addressList;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    /*public List<AddressInfo> getAddressList() {
        return addressList;
    }*/

    public String getPayPassword() {
        return payPassword;
    }
}
