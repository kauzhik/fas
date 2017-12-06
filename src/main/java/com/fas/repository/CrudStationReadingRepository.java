package com.fas.repository;

import com.fas.model.Station;
import com.fas.model.StationReading;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CrudStationReadingRepository extends JpaRepository<StationReading, Integer> {
    List<StationReading> findByStationAndReadTimeBetween(Station station, Date startDate, Date endDate);
}
