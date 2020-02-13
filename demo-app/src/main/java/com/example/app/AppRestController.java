package com.example.app;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AppRestController {

    @GetMapping(path = "/")
    public String home() {
        return "Hello World!";
    }
}
