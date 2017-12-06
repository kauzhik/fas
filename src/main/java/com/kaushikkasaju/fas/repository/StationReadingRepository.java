package com.kaushikkasaju.fas.repository;

import com.kaushikkasaju.fas.model.StationReading;

import java.util.List;

public interface StationReadingRepository {
    List<StationReading> findAll();
    public StationReading recordStationReading(StationReading stationReading);
}
