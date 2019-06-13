package com.example.demo.service.member.impl;

import com.example.demo.dao.member.AddressRepository;
import com.example.demo.entity.Address;
import com.example.demo.entity.Member;
import com.example.demo.payloads.user.AddressResponse;
import com.example.demo.payloads.user.ModifyAddressRequest;
import com.example.demo.service.member.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2019/2/13
 */

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressResponse> getAllAddress(String email) {

        Member member = new Member();
        member.setEmail(email);

        List<Address> addresses = addressRepository.findAllByMember(member);

        ArrayList<AddressResponse> addressList = new ArrayList<>();

        if(addresses != null){
            for(Address a: addresses) {
                if(!a.isUsable()) {
                    continue;
                }
                AddressResponse response = new AddressResponse(a);
                addressList.add(response);
            }
        }

        return addressList;
    }

    @Override
    public int addNewAddress(String email, String province, String city, String district, String address, String name, String phone) {

        Member member = new Member();
        member.setEmail(email);

        /*List<Address> addresses = addressRepository.findAllByMember(member);
        for(Address a: addresses) {
            if(a.getAddress().equals(address)){
                return false;
            }
        }*/
        Address newAddress = new Address(member, province, city, district, address, phone, name);
        addressRepository.save(newAddress);
        return newAddress.getId();
    }

    @Override
    public boolean modifyAddress(ModifyAddressRequest request) {
        Optional<Address> addressOptional = addressRepository.findById(request.getAid());
        if(!addressOptional.isPresent()) {
            return false;
        }
        Address address = addressOptional.get();
        address.setProvince(request.getProvince());
        address.setCity(request.getCity());
        address.setDistrict(request.getDistrict());
        address.setAddress(request.getAddress());
        address.setName(request.getName());
        address.setPhone(request.getPhone());
        addressRepository.save(address);

        return true;
    }

    @Override
    public void deleteAddress(int aid) {
        Address address = addressRepository.findById(aid).get();
        address.setUsable(false);
        addressRepository.save(address);
    }

    @Override
    public AddressResponse getTheAddress(int aid) {
        Address address = addressRepository.findById(aid).get();
        AddressResponse response = new AddressResponse(address);
        /*response.setAid(aid);

        response.setAddress(address.getAddress());
        response.setDistrict(address.getDistrict());*/

        return response;
    }
}
