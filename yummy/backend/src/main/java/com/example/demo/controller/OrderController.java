package com.example.demo.controller;

import com.example.demo.payloads.order.*;
import com.example.demo.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2019/2/26
 */


@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/new_order")
    // 下单  备注、地址
    public void addNewOrder(@RequestBody NewOrderRequest request){
        orderService.addNewOrder(request);
    }

    @GetMapping("/get_not_paid")
    // 会员查询未付款订单
    public List<GetOrderResponse> getNotPaidList(String email) {return orderService.getNotPaidOrders(email);}

    @GetMapping("/get_complete")
    // 会员查询已付款订单
    public List<GetOrderResponse> getPaidList(String email) {return orderService.getCompleteOrders(email);}

    @GetMapping("/get_invalid")
    // 会员查询失效订单（退订订单+未付款失效订单）
    public List<GetOrderResponse> getInvalidList(String email) {return orderService.getInvalidOrders(email);}

    @GetMapping("/get_order_detail")
    // 会员查看订单详情
    public OrderDetailResponse getOrderDetail(int oid) {return orderService.getOrderDetail(oid);}

    @GetMapping("/cancel_order")
    // 取消订单
    public void cancelOrder(int oid) {orderService.cancelOrder(oid);}

    @GetMapping("/pay_order")
    // 付款
    public boolean payOrder(int oid) { return orderService.payOrder(oid);}

    @GetMapping("/evaluate_order")
    // 评价订单
    public boolean evaluateOrder(int oid, int grade) {
        return orderService.evaluateOrder(oid, grade);
    }

    @GetMapping("/get_express_state")
    // 查询订单派送状态
    public String getExpressState(int oid) {return orderService.getExpressState(oid);}

    @GetMapping("/get_not_receive")
    // 查询待接单订单  不显示退订；加上用户姓名、电话、地址、备注
    public List<OrderExpressResponse> getNotReceiveList(String restId) {return  orderService.getNotReceiveOrders(restId);}

    @GetMapping("/get_not_deliver")
    // 查询未发货订单
    public List<OrderExpressResponse> getNotDeliverList(String restId) {return  orderService.getNotDeliverOrders(restId);}

    @GetMapping("/get_delivered")
    // 询已发货订单
    public List<OrderExpressResponse> getDeliveredList(String restId) {return  orderService.getDeliveredOrders(restId);}

    /**
     * 商家接单
     * @param oid
     */
    @GetMapping("/receive_order")
    public void receiveOrder(int oid) {orderService.receiveOrder(oid);}

    /**
     * 商家发货
     * @param oid
     */
    @GetMapping("/deliver_order")
    public void deliverOrder(int oid) {orderService.deliverOrder(oid);}

    /**
     * 会员确认收货
     * @param oid
     */
    @GetMapping("/accept_order")
    public void acceptOrder(int oid) {orderService.acceptOrder(oid);}

    /**
     * 会员退订商品
     * @param oid
     */
    @GetMapping("/set_order_cancel")
    public void setOrderCancel(int oid) {orderService.setOrderCancel(oid);}

    /**
     * 商家接受退订
     * @param oid
     */
    @GetMapping("/agree_cancel")
    public void agreeCancel(int oid) {orderService.agreeCancel(oid);}

    @GetMapping("/get_member_statistics")
    // 查询会员统计信息
    public List<MemberStatisticsResponse> getMemberStatistics(String email) {return orderService.getMemberStatistics(email);}

    @GetMapping("/get_rest_statistics")
    // 查询餐厅统计信息
    public List<RestStatisticsResponse> getRestStatistics(String restId) {return orderService.getRestStatistics(restId);}
}
