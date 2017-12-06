package com.kaushikkasaju.fas.repository;

import com.kaushikkasaju.fas.model.Station;
import com.kaushikkasaju.fas.model.StationReading;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CrudStationReadingRepository extends JpaRepository<StationReading, Integer> {
    List<StationReading> findByStationAndReadTimeBetween(Station station, Date startDate, Date endDate);
}
