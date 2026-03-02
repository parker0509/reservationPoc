package com.cms.cms.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class CreateReservationRequest {

    private Long userId;
    private Long resourceId;

    private LocalDate reservationDate;
    private LocalTime reservationTime;

    private LocalDate startDate;
    private LocalDate endDate;

    private LocalTime startTime;
    private LocalTime endTime;

    private String status;
}