package com.example.weatherapi;

import com.example.weatherapi.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeatherApiApplicationTests {
    @Autowired
    private WeatherService weatherService;

    @Test
    void contextLoads() {
    }

}
