package com.cms.cms.service;

import com.cms.cms.dao.ReservationDao;
import com.cms.cms.domain.Reservation;
import com.cms.cms.exception.DuplicateReservationException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationDao reservationDao;

    public Reservation findById(Long id) {
        return reservationDao.findById(id);
    }

    @Transactional
    public Long createReservation(Reservation reservation) {

        try {
            reservationDao.save(reservation);
            return reservation.getId();
        }catch(DuplicateKeyException e) {
            throw new DuplicateReservationException();
        }
    }
}
