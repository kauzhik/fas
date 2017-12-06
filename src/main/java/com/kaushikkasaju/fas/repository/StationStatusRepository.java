package com.kaushikkasaju.fas.repository;

import com.kaushikkasaju.fas.model.StationStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StationStatusRepository extends CrudRepository<StationStatus, Integer> {
    StationStatus save(StationStatus stationStatus);
    List<StationStatus> findAll();
}
