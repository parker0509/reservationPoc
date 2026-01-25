package com.cms.cms.dao;

import com.cms.cms.domain.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReservationDao {

    Reservation findById(Long id);

    int save(Reservation reservation);

    int updateStatus(
            @Param("id") Long id,
            @Param("status") String status
    );

    int countDuplicate(@Param("resourceId") Long resourceId,
                       @Param("date") String date,
                       @Param("start") String start,
                       @Param("end") String end);
}

