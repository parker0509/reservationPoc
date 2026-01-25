package com.cms.cms.controller;

import com.cms.cms.service.ReservationService;
import com.cms.cms.domain.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> createReservation(@RequestBody Reservation reservation) {

        Long reservationNm = reservationService.createReservation(reservation);

        return ResponseEntity.status(HttpStatus.CREATED).body(reservationNm);
    }
}
