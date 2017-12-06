package com.kaushikkasaju.fas.service;

import com.kaushikkasaju.fas.model.Station;

import java.util.List;

public interface StationService {
    List<Station> findAll();
    Station findById(Integer id);
}
