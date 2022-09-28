package com.ssafy.gsdd.controller;

import com.ssafy.gsdd.DTO.AroundDTO;
import com.ssafy.gsdd.repository.LampRepository;
import com.ssafy.gsdd.service.AroundService;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("")
public class AroundController {

    @Autowired
    AroundService aroundService;
    @GetMapping("/{lat}/{lon}")
    public ResponseEntity<HashMap> getList(@PathVariable double lat, @PathVariable double lon){
        HashMap<String , Object> result = new HashMap<>();
        AroundDTO list = aroundService.getList(lat, lon);
        result.put("lights",list.getLamps());
        result.put("cameras",list.getCctvs());
        result.put("houses",list.getHouses());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
