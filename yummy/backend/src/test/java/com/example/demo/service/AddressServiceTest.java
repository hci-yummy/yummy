package com.example.demo.service;

import com.example.demo.payloads.user.AddressResponse;
import com.example.demo.payloads.user.ModifyAddressRequest;
import com.example.demo.service.member.AddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: 许杨
 * @Description:
 * @Date: 2019/6/11
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceTest {
    @Autowired
    private AddressService addressService;

    @Test
    public void getAllAddress() {
        String email = "479026126@qq.com";
        List<AddressResponse> responses = addressService.getAllAddress(email);
        System.out.println("AddressResponse list: ");
        for(AddressResponse response : responses) {
            print(response);
        }
    }
    private void print(AddressResponse response) {
        System.out.println("aid: " + response.getAid());
        System.out.println("province: " + response.getProvince());
        System.out.println("city: " + response.getCity());
        System.out.println("district: " + response.getDistrict());
        System.out.println("address: " + response.getAddress());
        System.out.println("phone: " + response.getPhone());
        System.out.println("name: " + response.getName());
        System.out.println("====================");
    }

    @Test
    public void addNewAddress() {
        String email = "479026126@qq.com";
        String province = "江苏省";
        String city = "南京市";
        String district = "栖霞区";
        String address = "南京大学6栋";
        String name = "王轩";
        String phone = "18251838318";
        addressService.addNewAddress(email, province, city, district, address, name, phone);
    }

    @Test
    public void getTheAddress() {
        int aid = 1;
        AddressResponse response = addressService.getTheAddress(aid);
        print(response);
    }

    @Test
    public void deleteAddress() {
        int aid = 1;
        addressService.deleteAddress(aid);
    }

    @Test
    public void modifyAddress() {
        ModifyAddressRequest request = new ModifyAddressRequest(1, "江苏省", "南京市", "鼓楼区", "汉口路22号南京大学陶园南楼", "18260199930", "xiangxiang");
        boolean result = addressService.modifyAddress(request);
        System.out.println("result: " + result);
    }
}