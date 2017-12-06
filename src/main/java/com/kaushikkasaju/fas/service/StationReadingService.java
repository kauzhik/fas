package com.kaushikkasaju.fas.service;

import com.kaushikkasaju.fas.model.StationReading;

import java.util.List;

public interface StationReadingService {
    StationReading save(StationReading stationReading);
    List<StationReading> findAll();
}
