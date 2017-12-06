package com.fas.service;

import com.fas.model.Station;
import com.fas.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService{
    @Autowired
    StationRepository stationRepository;

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }

    @Override
    public Station findById(Integer id) {
        return stationRepository.findById(id);
    }
}
