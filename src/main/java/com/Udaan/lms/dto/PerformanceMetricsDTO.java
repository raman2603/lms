package com.Udaan.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceMetricsDTO {
    private Long id;
    private String metricType;
    private String value;
    private LocalDateTime recordedAt;
}
