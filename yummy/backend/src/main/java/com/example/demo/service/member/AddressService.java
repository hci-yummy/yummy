package com.example.demo.service.member;

import com.example.demo.entity.Address;
import com.example.demo.payloads.user.AddressResponse;
import com.example.demo.payloads.user.ModifyAddressRequest;

import java.util.List;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2019/2/13
 */
public interface AddressService {
    List<AddressResponse> getAllAddress(String email);
    boolean addNewAddress(String email, String province, String city, String district, String address, String name, String phone);
    boolean modifyAddress(ModifyAddressRequest request);
    void deleteAddress(int aid);
    AddressResponse getTheAddress(int aid);
}
