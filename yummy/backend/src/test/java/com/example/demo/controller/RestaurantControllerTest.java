package com.example.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @Author: 许杨
 * @Description:
 * @Date: 2019/6/10
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class RestaurantControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void register() {
        try {
            mvc.perform(
                    post("/rest/register")
                            .param("name", "测试餐厅2")
                            .param("province", "江苏省")
                            .param("city", "南京市")
                            .param("district", "鼓楼区")
                            .param("address", "广州路2号")
                            .param("type", "快餐")
                            .param("imageUrl", "image url")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void login() {
        try {
            mvc.perform(
                    get("/rest/login")
                            .param("id", "e6797b0")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addNewFood() {
        try {
            mvc.perform(
                    post("/rest/new_food")
                            .param("restId", "1da3409")
                            .param("name", "测试单品2")
                            .param("type", "快餐")
                            .param("price", "20")
                            .param("amount", "100")
//                            .param("startDate", "快餐")
//                            .param("endDate", "image url")
                            .param("image", "food image 2")
                            .param("description", "the second food")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getRestByDistrict() {
        try {
            mvc.perform(
                    get("/rest/get_rests")
                            .param("province", "江苏省")
                            .param("city", "南京市")
                            .param("district", "鼓楼区")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getFoodList() {
        try {
            mvc.perform(
                    get("/rest/get_food_list")
                            .param("id", "1da3409")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setNewSetMeal() {
        try {
            mvc.perform(
                    post("/rest/new_setmeal")
                            .param("name", "测试套餐")
                            .param("restId", "1da3409")
                            .param("price", "20")
                            .param("amount", "100")
                            .param("image", "set meal image 2")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getDiscountList() {
        try {
            mvc.perform(
                    get("/rest/get_discount_list")
                            .param("restId", "1da3409")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setDiscount() {
        try {
            mvc.perform(
                    post("/rest/set_discount")
                            .param("restId", "1da3409")
                            .param("fullMoney", "15")
                            .param("disMoney", "2")
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
                    post("/rest/save_info")
                            .param("id", "1da3409")
                            .param("name", "测试餐厅2")
                            .param("province", "江苏省")
                            .param("city", "南京市")
                            .param("district", "玄武区")
                            .param("address", "玄武大道2号")
                            .param("type", "中餐厅")
                            .param("imageUrl", "shop 2 image")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calOrder() {
        try {
            mvc.perform(
                    post("/rest/cal_order")
                            .param("restId", "1da3409")
                            .param("level", "5")
                            .param("sum", "50")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getStatistics() {
        try {
            mvc.perform(
                    get("/rest/get_statistics")
                            .param("rid", "1da3409")
                            .param("start", "2018-05")
                            .param("end", "2019-01")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}