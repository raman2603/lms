package com.Udaan.lms.controller;

import com.Udaan.lms.dto.AccountPerformance;
import com.Udaan.lms.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/performancemetrics")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @GetMapping("/best")
    public List<AccountPerformance> getBestPerformingRestaurants(@RequestParam(defaultValue = "5") int limit) {
        return performanceService.getBestPerformingRestaurants(limit);
    }

    @GetMapping("/worst")
    public List<AccountPerformance> getWorstPerformingRestaurants(@RequestParam(defaultValue = "5") int limit) {
        return performanceService.getWorstPerformingRestaurants(limit);
    }
}
