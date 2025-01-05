package com.Udaan.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CallPlanDTO {
    private Long id;
    private String callFrequency;
    private LocalDateTime lastCallDate;
    private String timezone;
}
