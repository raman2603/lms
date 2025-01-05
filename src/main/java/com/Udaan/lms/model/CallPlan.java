package com.Udaan.lms.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.zone.ZoneRulesException;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data
@NoArgsConstructor
public class CallPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonBackReference
    private Restaurant restaurant;

    private String callFrequency; // e.g., "DAILY", "WEEKLY", etc.
    private LocalDateTime lastCallDate;
    private String timezone;

    public void setTimezone(String timezone) {
        try {
            ZoneId.of(timezone); // Validate the timezone
            this.timezone = timezone;
        } catch (ZoneRulesException e) {
            throw new IllegalArgumentException("Invalid timezone: " + timezone);
        }
    }
}
