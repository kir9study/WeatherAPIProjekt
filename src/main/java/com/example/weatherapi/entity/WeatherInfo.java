package com.example.weatherapi.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Table(name = "weather_info")
public class WeatherInfo {
    @EqualsAndHashCode.Include
    @ToString.Include

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private double temp;
    @Column(name = "wind_speed")
    private double windSpeed;
    private int pressure;
    private int humidity;
    @Column(name = "weather_conditions")
    private String weatherConditions;
    private String location = "Minsk";
    private LocalDate date = LocalDate.now();

}
