package com.example.demo.controller;

import com.example.demo.entity.Address;
import com.example.demo.payloads.user.AddressResponse;
import com.example.demo.payloads.user.EditMemberInfoRequest;
import com.example.demo.payloads.user.MemberInfoResponse;
import com.example.demo.payloads.user.MemberRegisterRequest;
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
    public List<AddressResponse> getAllAddress(String email) {
        return addressService.getAllAddress(email);
    }

    @GetMapping("/get_the_address")
    public AddressResponse getTheAddress(int aid) {return addressService.getTheAddress(aid);}

    @GetMapping("/new_address")
    public boolean addAddress(String email, String district, String address){return addressService.addNewAddress(email, district, address);}

    @GetMapping("/get_info")
    public MemberInfoResponse getInfo(String email){return memberService.getInfo(email);}

    @RequestMapping("/edit_info")
    public void saveInfo(@RequestBody EditMemberInfoRequest request){
        System.out.println("in controller:");
        System.out.println(request.getEmail());
        memberService.saveInfo(request);
    }

    @GetMapping("/get_level")
    public int getLevel(String email) {
        return memberService.getLevel(email);
    }

    @GetMapping("/delete_member")
    public void deleteMember(String email) {memberService.deleteMember(email);}


}
