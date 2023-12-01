package com.example.weatherApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
public class WeatherInfoDto {
    private double temp;
    private double windSpeed;
    private int pressure;
    private int humidity;
    private String weatherConditions;
    private String location = "Minsk";

}
