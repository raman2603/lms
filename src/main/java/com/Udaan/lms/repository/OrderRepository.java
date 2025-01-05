package com.Udaan.lms.repository;

import com.Udaan.lms.model.OrderDetail;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<OrderDetail, Long> {
    @Query("SELECT o.restaurant.id, COUNT(o), SUM(o.orderAmount), AVG(o.orderAmount), MAX(o.orderDate) " +
           "FROM OrderDetail o GROUP BY o.restaurant.id")
    List<Object[]> findAggregatedMetrics();
}
