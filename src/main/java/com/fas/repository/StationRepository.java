package com.fas.repository;

import com.fas.model.Station;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StationRepository extends CrudRepository<Station, Integer>{
    List<Station> findAll();
    Station findById(Integer id);
}
