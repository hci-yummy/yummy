package com.example.demo.dao.member;

import com.example.demo.entity.Address;
import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * @Author: 王轩
 * @Description:
 * @Date: 2019/2/13
 */
public interface AddressRepository extends CrudRepository<Address, Integer> {
    List<Address> findAllByMember(Member member);

    @Query(value = "SELECT * FROM address a WHERE a.email = ?1 and a.is_usable = TRUE", nativeQuery = true)
    List<Address> findUsableAddress(String email);

    @Query(value = "SELECT * FROM address a WHERE a.email = ?1 AND a.is_usable = TRUE AND a.province = ?2 AND a.city = ?3", nativeQuery = true)
    List<Address> selectAddresses(String email, String province, String city);
}
