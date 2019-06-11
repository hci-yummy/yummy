package com.example.demo.dao;

import com.example.demo.dao.member.MemberRepository;
import com.example.demo.dao.order.OrderRepository;
import com.example.demo.dao.restaurant.RestRepository;
import com.example.demo.entity.Orders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2019/2/26
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrdersTest {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private RestRepository restRepository;

    @Test
    public void test(){
        Orders order = orderRepository.findById(2).get();
        order.setPaid(true);
        order.setValid(true);
        order.setCancel(false);
        orderRepository.save(order);
    }

    @Test
    public void addOrder() {
        Orders order = new Orders();
        order.setMember(memberRepository.findByEmail("479026126@qq.com").get());
        order.setRestaurant(restRepository.findById("e6797b0").get());
        order.setAddress("鼓楼区  汉口路22号");
        order.setSum(30);
        order.setOrderTime(LocalDateTime.now().minusMonths(2L));
        orderRepository.save(order);
    }
}
