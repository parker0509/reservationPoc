package com.cms.cms.controller;

import com.cms.cms.dto.CreateReservationRequest;
import com.cms.cms.service.ReservationService;
import com.cms.cms.domain.Reservation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    // 예약 조회
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        Reservation reservation = reservationService.getReservation(id);
        return ResponseEntity.ok(reservation);
    }

    // 예약 생성
    @PostMapping
    public ResponseEntity<Reservation> create(
            @Valid @RequestBody CreateReservationRequest request) {
        Reservation reservation = reservationService.createReservation(request);
        return ResponseEntity.status(201).body(reservation); // CREATED
    }

    // 예약 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}