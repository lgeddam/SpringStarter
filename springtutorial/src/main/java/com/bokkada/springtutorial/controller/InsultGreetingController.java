package com.bokkada.springtutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bokkada.springtutorial.pojo.InsultGreeting;
import com.bokkada.springtutorial.service.InsultService;

@Controller
public class InsultGreetingController {

    @Autowired
    private InsultService insultService;

    @GetMapping("/insult/random")
    @ResponseBody
    public InsultGreeting getInsult() {
        return insultService.getRandomInsult();
    }

    @GetMapping("/insult/desi")
    @ResponseBody
    public InsultGreeting getDesiInsult() {
        return insultService.getDesiInsult();
    }

    @PostMapping("/insult")
    public ResponseEntity<Void> addInsult (@RequestBody InsultGreeting insult) {
        try {
            insultService.putNewInsult(insult);
            return ResponseEntity.accepted().build();
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
