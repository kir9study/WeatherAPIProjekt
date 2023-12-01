package com.example.weatherApi.dto.weatherApi;

import lombok.Data;
import org.springframework.stereotype.Component;





import java.util.List;

@Data
@Component
public class WeatherApiResponse {
    private Main main;
    private Wind wind;
    private List<Weather> weather;
    private int dt;
    private String name;
}
