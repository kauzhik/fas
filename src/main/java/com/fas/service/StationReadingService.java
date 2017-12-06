package com.fas.service;

import com.fas.model.StationReading;

import java.util.List;

public interface StationReadingService {
    StationReading save(StationReading stationReading);
    List<StationReading> findAll();
}
