package com.notahmed.catsfinder.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


// Adding record which contains the configs properties
//@ConfigurationProperties(value = "cf")
public record CatFinderProperties(
        String welcomeMessage,
        String about
) {
}
