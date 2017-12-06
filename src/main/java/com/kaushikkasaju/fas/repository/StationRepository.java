package com.kaushikkasaju.fas.repository;

import com.kaushikkasaju.fas.model.Station;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StationRepository extends CrudRepository<Station, Integer>{
    List<Station> findAll();
    Station findById(Integer id);
}
