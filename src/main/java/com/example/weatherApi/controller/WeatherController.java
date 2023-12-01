package com.example.weatherApi.controller;
import com.example.weatherApi.dto.WeatherInfoDto;
import com.example.weatherApi.dto.weatherApi.WeatherApiResponse;
import com.example.weatherApi.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {


    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {

        this.weatherService = weatherService;
    }

    @GetMapping("/current/{cityName}")
    public ResponseEntity<WeatherApiResponse> getListData(@PathVariable String cityName){
                return ResponseEntity.ok(weatherService.getForecast(cityName));
    }


}
