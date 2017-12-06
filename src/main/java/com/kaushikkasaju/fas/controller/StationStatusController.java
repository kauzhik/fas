package com.kaushikkasaju.fas.controller;

import com.kaushikkasaju.fas.model.StationStatus;
import com.kaushikkasaju.fas.service.StationStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    public List<StationStatus> stationStatus(){
        return stationStatusService.findAll();
    }

}
