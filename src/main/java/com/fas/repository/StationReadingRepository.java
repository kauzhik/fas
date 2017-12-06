package com.fas.repository;

import com.fas.model.Station;
import com.fas.model.StationReading;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StationReadingRepository {
    List<StationReading> findAll();
    public StationReading recordStationReading(StationReading stationReading);
}
