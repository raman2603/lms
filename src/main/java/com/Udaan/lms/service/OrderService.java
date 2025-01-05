package com.Udaan.lms.service;

import com.Udaan.lms.model.OrderDetail;
import com.Udaan.lms.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDetail> getOrdersByRestaurantId(Long restaurantId) {
        return orderRepository.findAll(); // Add custom query if needed
    }

    public OrderDetail saveOrder(OrderDetail order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
