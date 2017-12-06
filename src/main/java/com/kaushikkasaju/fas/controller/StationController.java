package com.kaushikkasaju.fas.controller;

import com.kaushikkasaju.fas.model.Station;
import com.kaushikkasaju.fas.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/station")
public class StationController {
    @Autowired
    StationService stationService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
            )
    public List<Station> stationList(){
        return stationService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Station stationById(@PathVariable(value = "id") String id){
        return stationService.findById(Integer.parseInt(id));
    }
}
