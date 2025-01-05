package com.Udaan.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Udaan.lms.dto.AccountPerformance;
import com.Udaan.lms.repository.OrderRepository;
import com.Udaan.lms.repository.RestaurantRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerformanceService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<AccountPerformance> calculateRestaurantPerformance() {
        List<Object[]> aggregatedMetrics = orderRepository.findAggregatedMetrics();
        List<AccountPerformance> performanceList = new ArrayList<>();

        for (Object[] result : aggregatedMetrics) {
            Long restaurantId = (Long) result[0];
            int totalOrders = ((Number) result[1]).intValue();
            double totalRevenue = ((Number) result[2]).doubleValue();
            double averageOrderValue = ((Number) result[3]).doubleValue();
            LocalDate lastOrderDate = (LocalDate) result[4];

            double orderFrequency = 0;
            if (totalOrders > 1) {
                Period period = Period.between(lastOrderDate, LocalDate.now());
                double months = period.getYears() * 12 + period.getMonths() + period.getDays() / 30.0;
                orderFrequency = totalOrders / months;
            } else {
                orderFrequency = totalOrders > 0 ? 1 : 0;
            }

            String restaurantName = restaurantRepository.findById(restaurantId)
                    .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"))
                    .getName();

            AccountPerformance performance = new AccountPerformance(
                restaurantName, totalOrders, totalRevenue, averageOrderValue, lastOrderDate, orderFrequency
            );

            performanceList.add(performance);
        }

        return performanceList;
    }

    public List<AccountPerformance> getBestPerformingRestaurants(int limit) {
        List<AccountPerformance> performanceList = calculateRestaurantPerformance();
        return performanceList.stream()
                .sorted(Comparator.comparingDouble(AccountPerformance::getTotalRevenue).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }

    public List<AccountPerformance> getWorstPerformingRestaurants(int limit) {
        List<AccountPerformance> performanceList = calculateRestaurantPerformance();
        return performanceList.stream()
                .sorted(Comparator.comparingDouble(AccountPerformance::getTotalRevenue))
                .limit(limit)
                .collect(Collectors.toList());
    }
}
