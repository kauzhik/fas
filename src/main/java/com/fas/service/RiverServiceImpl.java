package com.fas.service;

import com.fas.model.River;
import com.fas.repository.RiverRepository;
import com.fas.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiverServiceImpl implements RiverService{
    @Autowired
    RiverRepository riverRepository;

    @Override
    public List<River> findAll(){
        return riverRepository.findAll();
    }

    @Override
    public River findById(Integer id){
        return riverRepository.findById(id);
    }

    public List<Object> findAllWithStation(){
        return riverRepository.findAllWithStation();
    }
}
