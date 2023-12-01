package com.example.weatherapi.mapper;


import com.example.weatherapi.dto.weatherApi.WeatherApiResponse;
import com.example.weatherapi.entity.WeatherInfo;
import org.springframework.stereotype.Component;

@Component
public class WeatherApiResponse2WeatherInfo implements Mapper<WeatherApiResponse, WeatherInfo> {
    public WeatherInfo map(WeatherApiResponse response){
        WeatherInfo weatherInfo=new WeatherInfo();
        weatherInfo.setWeatherConditions(response.getWeather().get(0).getMain());
        weatherInfo.setHumidity(response.getMain().getHumidity());
        weatherInfo.setPressure(response.getMain().getPressure());
        weatherInfo.setTemp(response.getMain().getTemp());
        weatherInfo.setWindSpeed(response.getWind().getSpeed());
        return weatherInfo;
    }

}
