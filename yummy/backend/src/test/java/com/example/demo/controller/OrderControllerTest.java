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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author: 许杨
 * @Description:
 * @Date: 2019/6/10
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void addNewOrder() {
        try {
            mvc.perform(
                    post("/order/new_order")
                            .param("email", "479026126@qq.com")
                            .param("restId", "1da3409")
                            .param("sum", "0")
//                            .param("foodList", "null")
                            .param("disByLevel", "0")
                            .param("disByRest", "0")
                            .param("fullMoney", "0")
                            .param("address", "鼓楼区  汉口路22号")
                            .param("remark", "")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getNotPaidList() {
    }

    @Test
    public void getPaidList() {
    }

    @Test
    public void getInvalidList() {
    }

    @Test
    public void getOrderDetail() {
        try {
            mvc.perform(
                    get("/order/get_order_detail")
                            .param("oid", "1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cancelOrder() {
        try {
            mvc.perform(
                    get("/order/cancel_order")
                            .param("oid", "1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void payOrder() {
        try {
            mvc.perform(
                    get("/order/pay_order")
                            .param("oid", "2")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void evaluateOrder() {
        try {
            mvc.perform(
                    get("/order/evaluate_order")
                            .param("oid", "1")
                            .param("grade", "4")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getExpressState() {
        try {
            mvc.perform(
                    get("/order/get_express_state")
                            .param("oid", "2")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getNotReceiveList() {
        try {
            mvc.perform(
                    get("/order/get_not_receive")
                            .param("restId", "e6797b0")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getNotDeliverList() {
    }

    @Test
    public void getDeliveredList() {
    }

    @Test
    public void receiveOrder() {
        try {
            mvc.perform(
                    get("/order/receive_order")
                            .param("oid", "2")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deliverOrder() {
        try {
            mvc.perform(
                    get("/order/deliver_order")
                            .param("oid", "2")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void acceptOrder() {
        try {
            mvc.perform(
                    get("/order/accept_order")
                            .param("oid", "2")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setOrderCancel() {
        try {
            mvc.perform(
                    get("/order/set_order_cancel")
                            .param("oid", "3")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void agreeCancel() {
        try {
            mvc.perform(
                    get("/order/agree_cancel")
                            .param("oid", "3")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getMemberStatistics() {
        try {
            mvc.perform(
                    get("/order/get_member_statistics")
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
    public void getRestStatistics() {
        try {
            mvc.perform(
                    get("/order/get_rest_statistics")
                            .param("restId", "e6797b0")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}