package com.Udaan.lms.controller;

import com.Udaan.lms.model.CallPlan;
import com.Udaan.lms.model.Restaurant;
import com.Udaan.lms.service.CallPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/callplans")
public class CallPlanController {

    @Autowired
    private CallPlanService callPlanService;

    @GetMapping("/restaurant/{restaurantId}")
    public CallPlan getCallPlanByRestaurantId(@PathVariable Long restaurantId) {
        return callPlanService.getCallPlanByRestaurantId(restaurantId);
    }

    @PostMapping
    public CallPlan createCallPlan(@RequestBody CallPlan callPlan) {
        return callPlanService.saveCallPlan(callPlan);
    }

    @PutMapping("/{id}")
    public CallPlan updateCallPlan(@PathVariable Long id, @RequestBody CallPlan callPlan) {
        callPlan.setId(id);
        return callPlanService.saveCallPlan(callPlan);
    }

    @DeleteMapping("/{id}")
    public void deleteCallPlan(@PathVariable Long id) {
        callPlanService.deleteCallPlan(id);
    }

    @GetMapping("/today")
    public List<Restaurant> getLeadsRequiringCallsToday() {
        return callPlanService.getLeadsRequiringCallsToday();
    }

    // public CallPlan updateLastCallDate(@PathVariable Long id, @RequestBody LocalDateTime lastCallDate) {
    //     return callPlanService.updateLastCallDate(id, lastCallDate);
    // }
}
