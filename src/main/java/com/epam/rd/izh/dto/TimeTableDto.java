package com.epam.rd.izh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeTableDto {
    private long rec_id;
    private LocalDate date_app;
    private LocalTime time_app;
    private long doctor_id;
    private long patient_id;
    private String record;
    private Boolean visit;
}
