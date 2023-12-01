package com.example.weatherApi.service;

import com.example.weatherApi.dto.weatherApi.WeatherApiResponse;
import com.example.weatherApi.dto.WeatherInfoDto;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherService {
    private final RestTemplate restTemplate;
    private final String OpenWeatherUrl= "https://api.openweathermap.org/data/2.5/weather?q=";
    private final String apiKey="2ac623f1d1f7742f3d1eb687c1c5e6a8";

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public WeatherInfoDto getForecast(String cityName) {
        WeatherInfoDto listData = restTemplate.getForObject(OpenWeatherUrl + cityName + "&appid=" + apiKey, WeatherInfoDto.class);
        return listData;
    }
    @Scheduled(fixedDelay = 60000)
    public void UpdateWeatherInfo(){
        WeatherApiResponse weatherInfo = restTemplate.getForObject(OpenWeatherUrl + cityName + "&appid=" + apiKey, WeatherApiResponse.class);
    }

}
