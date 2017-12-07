package com.kaushikkasaju.fas.service;

import com.kaushikkasaju.fas.model.StationReading;

import java.util.List;

public interface StationReadingService {
    boolean save(StationReading stationReading);
    List<StationReading> findAll();
}
