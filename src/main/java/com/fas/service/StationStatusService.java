package com.fas.service;

import com.fas.model.StationStatus;

import java.util.List;

public interface StationStatusService {
    StationStatus save(StationStatus stationStatus);
    List<StationStatus> findAll();
}
