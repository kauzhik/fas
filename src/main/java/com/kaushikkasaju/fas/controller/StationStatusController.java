package com.kaushikkasaju.fas.controller;

import com.kaushikkasaju.fas.model.StationStatus;
import com.kaushikkasaju.fas.service.StationStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/status")
public class StationStatusController {
    @Autowired
    StationStatusService stationStatusService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<List<StationStatus>> stationStatus(){
        List<StationStatus> stationStatusList = stationStatusService.findAll();
        if(stationStatusList != null){
            return ResponseEntity.ok(stationStatusList);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
