package com.example.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AppRestController {

    @Value("${welcome-message}")
    private String welcomeMessage;

    @GetMapping(path = "/")
    public String home() {
        return welcomeMessage;
    }
}
