package com.poc.project.hospital.mappers;

import com.poc.project.hospital.dto.ReviewDto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ReviewMapper implements RowMapper<ReviewDto> {
    @Override
    public ReviewDto mapRow(ResultSet resultSet, int i) throws SQLException {
        return ReviewDto.builder()
                .review_id(resultSet.getLong("review_id"))
                .rw_doctor_id(resultSet.getLong("rw_doctor_id"))
                .rw_patient_id(resultSet.getLong("rw_patient_id"))
                .review(resultSet.getString("review"))
                .build();
    }
}
