package com.sonuswaves.discoveryservice.controller;

import com.sonuswaves.discoveryservice.configuration.DbSettings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private DbSettings dbSettings;

    public GreetingController(DbSettings dbSettings) {
        this.dbSettings = dbSettings;
    }

    //example of lookUp in the property files
    @Value("${my.greeting}")
    private String greetingMessage;

    @GetMapping("/greeting")
    public String greeting() {
        return dbSettings.getConnection() + dbSettings.getHost() + dbSettings.getPort();
    }

}
