package com.example.weatherapi.service;

import com.example.weatherapi.dto.weatherApi.WeatherApiResponse;
import com.example.weatherapi.dto.WeatherInfoDto;
import com.example.weatherapi.entity.WeatherInfo;
import com.example.weatherapi.mapper.WeatherApiResponse2WeatherInfo;
import com.example.weatherapi.mapper.WeatherInfo2WeatherInfoDto;
import com.example.weatherapi.repository.WeatherInfoRepository;
import com.example.weatherapi.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class WeatherService {
    @Autowired
    private final RestTemplate restTemplate;
    @Autowired
    private final WeatherInfoRepository weatherInfoRepository;
    @Autowired
    private final WeatherApiResponse2WeatherInfo weatherApiResponse2WeatherInfo;
    @Autowired
    private final WeatherInfo2WeatherInfoDto weatherInfo2WeatherInfoDto;
    @Value("app.weatherApi.city")
    private String cityName;
    private final String OpenWeatherUrl= "https://api.openweathermap.org/data/2.5/weather?q=";
    private final String apiKey="2ac623f1d1f7742f3d1eb687c1c5e6a8";

    public WeatherInfoDto getForecast() {
        WeatherInfo weatherByMaxDate = weatherInfoRepository.findByDate_Max();
        WeatherInfoDto data = weatherInfo2WeatherInfoDto.map(weatherByMaxDate);
        return data;
    }
    @Scheduled(fixedDelay = 60000)
    public void UpdateWeatherInfo(){
        WeatherApiResponse weatherInfo = restTemplate.getForObject(getOpenWeatherUrl(), WeatherApiResponse.class);
        WeatherInfo entity = weatherApiResponse2WeatherInfo.map(weatherInfo);
        weatherInfoRepository.save(entity);

    }

    private String getOpenWeatherUrl() {
        return OpenWeatherUrl + cityName + "&appid=" + apiKey;
    }

    public WeatherInfoDto getHistoryWeather(String from, String to) {
        LocalDate localDateFrom = DateUtil.convert(from);
        LocalDate localDateTo = DateUtil.convert(to);

        List<WeatherInfo> byDateBetween = weatherInfoRepository.findByDateBetween(localDateFrom, localDateTo);

        double totalTemp = 0;
        double totalWindSpeed = 0;
        int totalPressure = 0;
        int totalHumidity = 0;

        for (WeatherInfo info : byDateBetween) {
            totalTemp += info.getTemp();
            totalWindSpeed += info.getWindSpeed();
            totalPressure += info.getPressure();
            totalHumidity += info.getHumidity();
        }

        double averageTemp = totalTemp / byDateBetween.size();
        double averageWindSpeed = totalWindSpeed / byDateBetween.size();
        int averagePressure = totalPressure / byDateBetween.size();
        int averageHumidity = totalHumidity / byDateBetween.size();

        WeatherInfoDto resultData = new WeatherInfoDto();
        resultData.setHumidity(averageHumidity);
        resultData.setPressure(averagePressure);
        resultData.setWindSpeed(averageWindSpeed);
        resultData.setTemp(averageTemp);

        return resultData;
    }

}
