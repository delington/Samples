package com.delington.yorgos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/sample")
    public String sample() {
        return "index";
    }
}
