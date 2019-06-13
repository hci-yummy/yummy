package com.example.demo.controller;

import com.example.demo.payloads.user.*;
import com.example.demo.service.member.AddressService;
import com.example.demo.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2019/2/3
 */

@RestController
@RequestMapping("/user")
public class MemberController {

    private MemberService memberService;
    private AddressService addressService;
    @Autowired
    public MemberController(MemberService memberService, AddressService addressService){
        this.memberService = memberService;
        this.addressService = addressService;
    }

    @PostMapping("/register")
    public boolean register(@RequestBody MemberRegisterRequest memberRegisterRequest) {

        return memberService.register(memberRegisterRequest.getUsername(), memberRegisterRequest.getPassword(), memberRegisterRequest.getEmail(), memberRegisterRequest.getPhone());

    }

    @GetMapping("/login")
    public String login(String email, String password){
       return memberService.login(email, password);
    }

    @RequestMapping("/verify")
    public void verify(HttpServletResponse response, @RequestParam("code") String code) throws Exception {

        if(memberService.verify(code)) {
            response.sendRedirect("http://localhost:3000/#/login");
        }else {
            response.sendRedirect("http://localhost:3000/#/register");
        }
    }

    @GetMapping("/get_address")
    // 地址
    public List<AddressResponse> getAllAddress(String email) {
        return addressService.getAllAddress(email);
    }

    @GetMapping("/get_the_address")
    // 地址
    public AddressResponse getTheAddress(int aid) {
        return addressService.getTheAddress(aid);
    }

    @PostMapping("/new_address")
    // 地址
    public boolean addAddress(@RequestBody AddAddressRequest request){
        return addressService.addNewAddress(request.getAddress(), request.getProvince(), request.getCity(), request.getDistrict(), request.getAddress(), request.getName(), request.getPhone());
    }

    @PostMapping("/modify_address")
    //
    public boolean modifyAddress(@RequestBody ModifyAddressRequest request) {
        return addressService.modifyAddress(request);
    }

    @GetMapping("/delete_address")
    public void deleteAddress(int aid) {
        addressService.deleteAddress(aid);
    }

    @GetMapping("/select_address")
    public List<AddressResponse> selectAddresses(String email, String province, String city) {
        return memberService.selectAddresses(email, province, city);
    }

    @GetMapping("/get_info")
    // 地址
    public MemberInfoResponse getInfo(String email){return memberService.getInfo(email);}

    @PostMapping("/edit_info")
    // 地址
    public void saveInfo(@RequestBody EditMemberInfoRequest request){
        memberService.saveInfo(request);
    }

    @GetMapping("/get_level")
    public int getLevel(String email) {
        return memberService.getLevel(email);
    }

    @GetMapping("/delete_member")
    public void deleteMember(String email) {memberService.deleteMember(email);}

    @GetMapping("/check_paypassword")
    public boolean checkPayPassword(String email, String password) {
        return memberService.checkPayPassword(email, password);
    }
}
