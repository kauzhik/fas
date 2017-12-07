package com.kaushikkasaju.fas.controller;

import com.kaushikkasaju.fas.model.StationReading;
import com.kaushikkasaju.fas.service.StationReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/reading")
public class StationReadingController {
    @Autowired
    StationReadingService stationReadingService;

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity stationReading(@RequestBody StationReading stationReading){
        if(stationReadingService.save(stationReading)){
            return new ResponseEntity(HttpStatus.OK);
        }else return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<StationReading> stationReadingList(){
        List<StationReading> stationReading = stationReadingService.findAll();
        return  stationReading;
    }

}
