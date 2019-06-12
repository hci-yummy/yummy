package com.example.demo.service.member.impl;

import com.example.demo.dao.member.AddressRepository;
import com.example.demo.dao.member.MemberRepository;
import com.example.demo.entity.Address;
import com.example.demo.entity.Member;
import com.example.demo.payloads.user.AddressInfo;
import com.example.demo.payloads.user.AddressResponse;
import com.example.demo.payloads.user.EditMemberInfoRequest;
import com.example.demo.payloads.user.MemberInfoResponse;
import com.example.demo.service.mail.MailService;
import com.example.demo.service.member.MemberService;
import com.example.demo.util.RandomCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2019/2/3
 */

@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;
    private AddressRepository addressRepository;
    private MailService mailService;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository,
                             MailService mailService,
                             AddressRepository addressRepository) {
        this.memberRepository = memberRepository;
        this.mailService = mailService;
        this.addressRepository = addressRepository;
    }

    private static RegisterMemberMap registerMemberMap = new RegisterMemberMap();

    @Override
    public boolean register(String username, String password, String email, String phone) {

        Optional<Member> member = memberRepository.findByEmail(email);
        if(!member.isPresent()){
            //即表示email不存在
            Member newMember = new Member(email,username,password,phone,1,0,10000,true);

            String randomCode = RandomCodeUtil.generateUniqueCode();
            registerMemberMap.put(randomCode, newMember);
            registerMemberMap.setTime(randomCode);

            mailService.sendMail(email, randomCode);

            return true;
        }

        return false;
    }

    @Override
    public String login(String email, String password){
        Optional<Member> optional = memberRepository.findByEmail(email);

        if(optional.isPresent()){
            Member member = optional.get();
            if(member.isUsable()) {
                if(member.getPassword().equals(password)){
                    return member.getUsername();
                }
            }else {
                return "-1";
            }
        }

        return "";
    }

    @Override
    public boolean verify(String code) {
        Member member = registerMemberMap.get(code);

        if(member != null) {
            memberRepository.save(member);
            registerMemberMap.remove(code);
            return true;
        }
        return false;
    }

    @Override
    // 地址
    public MemberInfoResponse getInfo(String email) {
        Optional<Member> optional = memberRepository.findByEmail(email);

        if(optional.isPresent()) {
            Member member = optional.get();

            List<Address> addresses = addressRepository.findUsableAddress(email);
            ArrayList<AddressInfo> addressList = new ArrayList<>();

            if(addressList != null) {
                for(Address a: addresses){
                    AddressInfo info = new AddressInfo(a.getId(), a.getProvince(), a.getCity(), a.getDistrict(), a.getAddress(), a.getPhone(), a.getName());
                    addressList.add(info);
                }
            }

            String username = member.getUsername();
            String phone = member.getPhone();
            int level = member.getLevel();
            double score = member.getScore();
            MemberInfoResponse response = new MemberInfoResponse(email, username, phone, level, score, addressList);
            return response;
        }

        return null;
    }

    @Override
    // 付款密码
    public void saveInfo(EditMemberInfoRequest request) {

        String email = request.getEmail();
        String username = request.getUsername();
        String phone = request.getPhone();

        Member member = memberRepository.findByEmail(email).get();
        member.setEmail(email);
        member.setUsername(username);
        member.setPhone(phone);
        member.setPayPassword(request.getPayPassword());

        memberRepository.save(member);

        /*List<AddressInfo> addressList = request.getAddressList();

        for(AddressInfo a: addressList) {
            Address address = new Address(member,a.getProvince(), a.getCity(), a.getDistrict(), a.getAddress(), a.getPhone(), a.getName());
            if(a.getId() > 0){
               address.setId(a.getId());
            }
            addressRepository.save(address);
        }*/
    }

    @Override
    public int getLevel(String email) {
        Member member = memberRepository.findByEmail(email).get();
        return member.getLevel();
    }

    @Override
    public void deleteMember(String email) {
        Member member = memberRepository.findByEmail(email).get();
        member.setUsable(false);
        memberRepository.save(member);
    }

    @Override
    public List<AddressResponse> selectAddresses(String email, String province, String city) {
        List<Address> addressList = addressRepository.selectAddresses(email, province, city);

        List<AddressResponse> addressInfos = new ArrayList<>();
        for(Address address : addressList) {
            AddressResponse info = new AddressResponse(address);
            addressInfos.add(info);
        }

        return addressInfos;
    }

    @Override
    public boolean checkPayPassword(String email, String password) {
        Member member = memberRepository.findByEmail(email).get();
        return member.getPayPassword().equals(password);
    }
}
