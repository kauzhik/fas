package com.kaushikkasaju.fas.service;

import com.kaushikkasaju.fas.model.River;
import com.kaushikkasaju.fas.repository.RiverRepository;
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
