package com.kaushikkasaju.fas.service;

import com.kaushikkasaju.fas.model.StationStatus;

import java.util.List;

public interface StationStatusService {
    StationStatus save(StationStatus stationStatus);
    List<StationStatus> findAll();
}
