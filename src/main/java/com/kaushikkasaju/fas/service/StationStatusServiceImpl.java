package com.kaushikkasaju.fas.service;

import com.kaushikkasaju.fas.model.StationStatus;
import com.kaushikkasaju.fas.repository.StationStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationStatusServiceImpl implements StationStatusService {
    @Autowired
    StationStatusRepository stationStatusRepository;


    @Override
    public StationStatus save(StationStatus stationStatus) {
        return stationStatusRepository.save(stationStatus);
    }

    @Override
    public List<StationStatus> findAll() {
        return stationStatusRepository.findAll();
    }
}
