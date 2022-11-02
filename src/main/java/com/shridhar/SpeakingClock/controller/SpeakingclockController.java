package com.shridhar.SpeakingClock.controller;


import com.shridhar.SpeakingClock.service.SpeakingclockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeakingclockController {

    @Autowired
    private SpeakingclockService speakingclockService;

    @GetMapping
    public String getTime(){
        return speakingclockService.timeINWords();
    }
}
