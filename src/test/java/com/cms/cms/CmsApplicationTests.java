package com.cms.cms;

import com.cms.cms.dao.ReservationDao;
import com.cms.cms.domain.Reservation;
import com.cms.cms.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class CmsApplicationTests {

	@Autowired
	private ReservationService reservationService;

	@Test
	void testCheckReservationTest(){

		Reservation reservation = new Reservation();
		reservation.setUserId(1L);
		reservation.setResourceId(100L);
		reservation.setStartDate(LocalTime.now());
		reservation.setReservationDate(LocalDate.now());
		reservation.setStartTime(LocalTime.of(10, 0));
		reservation.setEndTime(LocalTime.of(11, 0));
		reservation.setStatus("RESERVED");

		Long count = reservationService.createReservation(reservation);

		assertEquals(1,count);

	}

}
