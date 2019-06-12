package com.example.demo.dao;

import com.example.demo.dao.member.MemberRepository;
import com.example.demo.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2019/2/26
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberTest {

    private MemberRepository memberRepository;

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Test
    public void test() {
        String email = "2273461589@qq.com";
        Member member = memberRepository.findByEmail(email).get();
        member.setUsable(true);
        memberRepository.save(member);
    }

    @Test
    public void add() {
        Member member = new Member("479026126@qq.com", "xiang", "password", "18260199930", 1, 10.0, 1000.0, true);
        memberRepository.save(member);
    }
}
