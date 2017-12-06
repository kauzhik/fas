package com.fas.service;

import com.fas.model.River;

import java.util.List;

public interface RiverService{
    List<River> findAll();
    River findById(Integer id);
    List<Object> findAllWithStation();
}
