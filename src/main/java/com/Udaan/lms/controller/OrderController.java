package com.Udaan.lms.controller;

import com.Udaan.lms.model.OrderDetail;
import com.Udaan.lms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/restaurant/{restaurantId}")
    public List<OrderDetail> getOrdersByRestaurantId(@PathVariable Long restaurantId) {
        return orderService.getOrdersByRestaurantId(restaurantId);
    }

    @PostMapping
    public OrderDetail createOrder(@RequestBody OrderDetail order) {
        return orderService.saveOrder(order);
    }

    @PutMapping("/{id}")
    public OrderDetail updateOrder(@PathVariable Long id, @RequestBody OrderDetail order) {
        order.setId(id);
        return orderService.saveOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
