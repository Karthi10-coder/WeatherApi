package com.weather.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String datetime;
    private String condition;

    private double dewPoint;
    private double humidity;
    private double pressure;
    private double temperature;
    private double windSpeed;
}