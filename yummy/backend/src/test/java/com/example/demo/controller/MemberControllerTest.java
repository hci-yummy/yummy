package com.example.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author: 许杨
 * @Description:
 * @Date: 2019/6/11
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class MemberControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void register() {
    }

    @Test
    public void getAllAddress() {
        try {
            mvc.perform(
                    get("/user/get_address")
                            .param("email", "479026126@qq.com")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTheAddress() {
        try {
            mvc.perform(
                    get("/user/get_the_address")
                            .param("aid", "1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addAddress() {
        try {
            mvc.perform(
                    get("/user/new_address")
                            .param("province", "江苏省")
                            .param("city", "苏州市")
                            .param("district", "姑苏区")
                            .param("address", "西环路3108号6-406")
                            .param("phone", "18260199930")
                            .param("name", "向阳")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteAddress() {
        try {
            mvc.perform(
                    get("/user/delete_address")
                            .param("aid", "1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectAddresses() {
        try {
            mvc.perform(
                    get("/user/select_address")
                            .param("email", "479026126@qq.com")
                            .param("province", "江苏省")
                            .param("city", "南京市")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getInfo() {
        try {
            mvc.perform(
                    get("/user/get_info")
                            .param("email", "479026126@qq.com")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveInfo() {
        try {
            mvc.perform(
                    post("/user/edit_info")
                            .param("username", "xiang")
                            .param("email", "479026126@qq.com")
                            .param("phone", "18260199930")
                            .param("payPassword", "password")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkPayPassword() {
        try {
            mvc.perform(
                    get("/user/check_paypassword")
                            .param("email", "479026126@qq.com")
                            .param("password", "paypassword")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}