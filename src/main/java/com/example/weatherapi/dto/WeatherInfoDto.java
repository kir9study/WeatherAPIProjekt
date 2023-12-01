package com.example.weatherapi.dto;

import lombok.Data;

@Data
public class WeatherInfoDto {
    private double temp;
    private double windSpeed;
    private int pressure;
    private int humidity;
    private String weatherConditions;
    private String location = "Minsk";

}
