package com.cms.cms.repository;

import com.cms.cms.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("select r from Reservation r join fetch r.user where r.id = :id")
    Optional<Reservation> findWithUser(@Param("id") Long id);
}
