package com.poc.project.hospital.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DoctorDetailsDto {
    @NotNull
    private long id;
    private String specialty;
    private String specification;
    private String experience;
}
