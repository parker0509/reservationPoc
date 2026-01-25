package com.cms.cms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Setter;
import org.apache.ibatis.annotations.ConstructorArgs;

@Getter @Setter
@AllArgsConstructor
public class Reservation {
    private Long id;
    private Long userId;
    private Long resourceId;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private LocalTime startDate;
    private LocalTime endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String status;
    private LocalTime createAt;
    private LocalTime updateAt;

    public Reservation() {
    }

}
