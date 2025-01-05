package com.Udaan.lms.service;

import com.Udaan.lms.model.CallPlan;
import com.Udaan.lms.model.Restaurant;
import com.Udaan.lms.repository.CallPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CallPlanService {

    @Autowired
    private CallPlanRepository callPlanRepository;

    public CallPlan getCallPlanByRestaurantId(Long restaurantId) {
        return callPlanRepository.findById(restaurantId).orElse(null);
    }

    public CallPlan saveCallPlan(CallPlan callPlan) {
        return callPlanRepository.save(callPlan);
    }

    public void deleteCallPlan(Long id) {
        callPlanRepository.deleteById(id);
    }

    public List<Restaurant> getLeadsRequiringCallsToday() {
        ZonedDateTime now = ZonedDateTime.now();
        return callPlanRepository.findAll().stream()
                .filter(callPlan -> isCallDueToday(callPlan, now))
                .map(CallPlan::getRestaurant)
                .collect(Collectors.toList());
    }

    private boolean isCallDueToday(CallPlan callPlan, ZonedDateTime now) {
        if (callPlan.getLastCallDate() == null) {
            return true; // If no call has been made yet, it's due today (suppose)
        }
        ZonedDateTime lastCallDate = callPlan.getLastCallDate().atZone(ZoneId.of(callPlan.getTimezone()));
        ZonedDateTime nextCallDate = calculateNextCallDate(lastCallDate, callPlan.getCallFrequency());
        return nextCallDate.toLocalDate().equals(now.toLocalDate());
    }

    private ZonedDateTime calculateNextCallDate(ZonedDateTime lastCallDate, String callFrequency) {
        switch (callFrequency.toUpperCase()) {
            case "DAILY":
                return lastCallDate.plusDays(1);
            case "WEEKLY":
                return lastCallDate.plusDays(35);
            case "MONTHLY":
                return lastCallDate.plusMonths(1);
            default:
                throw new IllegalArgumentException("Unknown call frequency: " + callFrequency);
        }
    }
}
