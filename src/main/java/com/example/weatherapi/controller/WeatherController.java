package com.example.weatherapi.controller;
import com.example.weatherapi.dto.WeatherInfoDto;
import com.example.weatherapi.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/weather")
public class WeatherController {


    private final WeatherService weatherService;

    @GetMapping("/currentWeather")
    public ResponseEntity<WeatherInfoDto> getCurrentWeather(){
        return ResponseEntity.ok(weatherService.getForecast());
    }

    @GetMapping("/historyWeather/{from}/{to}")
    public ResponseEntity<WeatherInfoDto> getHistoryWeather(@PathVariable String from,
                                                            @PathVariable String to ) {

        return ResponseEntity.ok(weatherService.getHistoryWeather(from, to));
    }


}
