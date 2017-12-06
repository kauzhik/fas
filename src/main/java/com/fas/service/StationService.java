package com.fas.service;

import com.fas.model.Station;

import java.util.List;

public interface StationService {
    List<Station> findAll();
    Station findById(Integer id);
}
