package com.fas.repository;

import com.fas.model.River;

import java.util.List;

public interface CustomRiverRepository {
    List<Object> findAllWithStation();
}
