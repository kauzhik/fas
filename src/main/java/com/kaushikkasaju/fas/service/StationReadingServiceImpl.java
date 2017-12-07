package com.kaushikkasaju.fas.service;

import com.kaushikkasaju.fas.model.StationReading;
import com.kaushikkasaju.fas.repository.StationReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationReadingServiceImpl implements StationReadingService {

    @Autowired
    @Qualifier(value = "readingRepository")
    StationReadingRepository stationReadingRepository;

    @Override
    public boolean save(StationReading stationReading) {
        if(stationReadingRepository.recordStationReading(stationReading) != null)
            return true;
        else
            return false;
    }

    @Override
    public List<StationReading> findAll() {
        return stationReadingRepository.findAll();
    }
}
