package com.Udaan.lms.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AccountPerformance {
    private String restaurantName;
    private int totalOrders;
    private double totalRevenue;
    private double averageOrderValue;
    private LocalDate lastOrderDate;
    private double orderFrequency;

    public AccountPerformance(String restaurantName, int totalOrders, double totalRevenue, double averageOrderValue,
                                 LocalDate lastOrderDate, double orderFrequency) {
        this.restaurantName = restaurantName;
        this.totalOrders = totalOrders;
        this.totalRevenue = totalRevenue;
        this.averageOrderValue = averageOrderValue;
        this.lastOrderDate = lastOrderDate;
        this.orderFrequency = orderFrequency;
    }
}
