package com.example.demo.service;

import com.example.demo.payloads.user.AddressInfo;
import com.example.demo.payloads.user.AddressResponse;
import com.example.demo.payloads.user.EditMemberInfoRequest;
import com.example.demo.payloads.user.MemberInfoResponse;
import com.example.demo.service.member.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: 许杨
 * @Description:
 * @Date: 2019/6/11
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Test
    public void register() {
    }

    @Test
    public void getInfo() {
        String email = "479026126@qq.com";
        MemberInfoResponse response = memberService.getInfo(email);
        print(response);
    }
    private void print(MemberInfoResponse response) {
        System.out.println("MemberInfoResponse: ");
        System.out.println("email: " + response.getEmail());
        System.out.println("username: " + response.getUsername());
        System.out.println("phone: " + response.getPhone());
        System.out.println("level: " + response.getLevel());
        System.out.println("score: " + response.getScore());
        System.out.println("addressList: ");
        for(AddressInfo info : response.getAddressList()) {
            print(info);
        }
    }
    private void print(AddressInfo info) {
        System.out.println("id: " + info.getId());
        System.out.println("province: " + info.getProvince());
        System.out.println("city: " + info.getCity());
        System.out.println("district: " + info.getDistrict());
        System.out.println("address: " + info.getAddress());
        System.out.println("name: " + info.getName());
        System.out.println("phone: " + info.getPhone());
        System.out.println("====================");
    }

    @Test
    public void saveInfo() {
        List<AddressInfo> addressList = new ArrayList<>();
        AddressInfo addressInfo = new AddressInfo(1, "江苏省", "南京市", "鼓楼区", "南京大学陶园南楼", "18260199930", "翔翔");
        addressList.add(addressInfo);
        EditMemberInfoRequest request = new EditMemberInfoRequest(
                "翔翔",
                "479026126@qq.com",
                "18260199930",
                "paypassword"
        );
        memberService.saveInfo(request);
    }

    @Test
    public void selectAddresses() {
        String email = "479026126@qq.com";
        String province = "江苏省";
        String city = "南京市";
        List<AddressResponse> responseList = memberService.selectAddresses(email, province, city);
        System.out.println("AddressResponse list: ");
        for(AddressResponse response : responseList) {
            print(response);
        }
    }
    private void print(AddressResponse info) {
        System.out.println("id: " + info.getAid());
        System.out.println("province: " + info.getProvince());
        System.out.println("city: " + info.getCity());
        System.out.println("district: " + info.getDistrict());
        System.out.println("address: " + info.getAddress());
        System.out.println("name: " + info.getName());
        System.out.println("phone: " + info.getPhone());
        System.out.println("====================");
    }

    @Test
    public void checkPayPassword() {
        String email = "479026126@qq.com";
        String password = "paypassword";
        boolean result = memberService.checkPayPassword(email, password);
        System.out.println("result: " + result);
    }

 }