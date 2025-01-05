package com.Udaan.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InteractionDTO {
    private Long id;
    private String type;
    private String details;
    private LocalDateTime date;
}
