package com.cms.cms.service;

import com.cms.cms.domain.User;
import com.cms.cms.domain.Reservation;
import com.cms.cms.dto.CreateReservationRequest;
import com.cms.cms.repository.ReservationRepository;
import com.cms.cms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationService {

    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;

    // 예약 생성
    public Reservation createReservation(CreateReservationRequest req) {

        User user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new RuntimeException("유저 없음"));

        Reservation reservation = new Reservation();

        reservation.setUser(user);
        reservation.setResourceId(req.getResourceId());
        reservation.setReservationDate(req.getReservationDate());
        reservation.setReservationTime(req.getReservationTime());
        reservation.setStartDate(req.getStartDate());
        reservation.setEndDate(req.getEndDate());
        reservation.setStartTime(req.getStartTime());
        reservation.setEndTime(req.getEndTime());
        reservation.setStatus(req.getStatus());

        Reservation saved = reservationRepository.save(reservation);

        return reservationRepository.findWithUser(saved.getId())
                .orElseThrow();
    }

    // 예약 삭제
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public Reservation getReservation(Long id) {
        Reservation r = reservationRepository.findWithUser(id)
                .orElseThrow();

        System.out.println("user = " + r.getUser());

        return r;
    }
}