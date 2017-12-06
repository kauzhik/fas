package com.fas.controller;

import com.fas.model.StationStatus;
import com.fas.service.StationStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Request;

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
