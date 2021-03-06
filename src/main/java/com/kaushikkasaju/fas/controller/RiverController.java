package com.kaushikkasaju.fas.controller;

import com.kaushikkasaju.fas.model.River;
import com.kaushikkasaju.fas.service.RiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rivers")
public class RiverController {
    @Autowired
    RiverService riverService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<List<River>> riverList(){
        List<River> riverList = riverService.findAll();
        if(riverList != null){
            return  ResponseEntity.ok(riverList);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
