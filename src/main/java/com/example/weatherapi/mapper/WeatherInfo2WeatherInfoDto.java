package com.example.weatherapi.mapper;

import com.example.weatherapi.dto.WeatherInfoDto;
import com.example.weatherapi.entity.WeatherInfo;
import org.springframework.stereotype.Component;

@Component
public class WeatherInfo2WeatherInfoDto implements Mapper<WeatherInfo, WeatherInfoDto> {
    @Override
    public WeatherInfoDto map(WeatherInfo object) {
        WeatherInfoDto weatherInfoDto = new WeatherInfoDto();
        weatherInfoDto.setTemp(object.getTemp());
        weatherInfoDto.setWeatherConditions(object.getWeatherConditions());
        weatherInfoDto.setWindSpeed(object.getWindSpeed());
        weatherInfoDto.setPressure(object.getPressure());
        weatherInfoDto.setHumidity(object.getHumidity());
        return weatherInfoDto;
    }
}
