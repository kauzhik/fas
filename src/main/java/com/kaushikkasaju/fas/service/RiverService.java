package com.kaushikkasaju.fas.service;

import com.kaushikkasaju.fas.model.River;

import java.util.List;

public interface RiverService{
    List<River> findAll();
    River findById(Integer id);
    List<Object> findAllWithStation();
}
