package com.fas.controller;

import com.fas.model.StationReading;
import com.fas.service.StationReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

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
        stationReadingService.save(stationReading);
        return new ResponseEntity(HttpStatus.OK);
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
