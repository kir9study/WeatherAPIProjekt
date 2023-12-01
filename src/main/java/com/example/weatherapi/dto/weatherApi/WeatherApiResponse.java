package com.example.weatherapi.dto.weatherApi;

import lombok.Data;
import org.springframework.stereotype.Component;





import java.util.List;

@Data
@Component
public class WeatherApiResponse {
    private Main main;
    private Wind wind;
    private List<Weather> weather;
}
