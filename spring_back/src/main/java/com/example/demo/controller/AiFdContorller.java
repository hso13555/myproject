package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AiFdDto;

import com.example.demo.service.AiFdService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/Time")
@RequiredArgsConstructor
public class AiFdContorller {
    
    private final AiFdService aiFdService;

    @PostMapping("/recomend")
    private ResponseEntity<?> addTimeFd(@RequestBody AiFdDto timedto){
       List<AiFdDto> timeFdDto =  aiFdService.timerecomend(timeFdDto);
       return new ResponseEntity<>(AiFdDto);
    } 
}
