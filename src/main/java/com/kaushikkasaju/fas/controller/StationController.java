package com.kaushikkasaju.fas.controller;

import com.kaushikkasaju.fas.model.Station;
import com.kaushikkasaju.fas.service.StationService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Station>> stationList(){
        List<Station> stationList = stationService.findAll();
        if(stationList != null){
            return ResponseEntity.ok(stationList);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @RequestMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Station> stationById(@PathVariable(value = "id") String id){
          Station station =  stationService.findById(Integer.parseInt(id));
          if(station != null){
              return ResponseEntity.ok(station);
          }else{
              return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
          }
    }
}
