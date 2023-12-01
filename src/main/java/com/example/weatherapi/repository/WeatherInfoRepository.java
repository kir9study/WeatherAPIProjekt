package com.example.weatherapi.repository;

import com.example.weatherapi.entity.WeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WeatherInfoRepository extends JpaRepository<WeatherInfo, Long> {


    WeatherInfo findByDate_Max();

    List<WeatherInfo> findByDateBetween(@Param("localDateFrom") LocalDate localDateFrom,
                                       @Param("localDateTo") LocalDate localDateTo);
}
