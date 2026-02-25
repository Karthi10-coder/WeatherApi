package com.weather.controller;

import com.weather.entity.Weather;
import com.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherRepository repository;

    @GetMapping
    public List<Weather> getWeather(
            @RequestParam(required = false) String condition,
            @RequestParam(required = false) String sort
    ) {


        if (condition != null && sort != null) {
            return repository.findAll(
                            Sort.by(sort)
                    ).stream()
                    .filter(w -> w.getCondition().equalsIgnoreCase(condition))
                    .toList();
        }


        if (condition != null) {
            return repository.findByCondition(condition);
        }


        if (sort != null) {
            return repository.findAll(Sort.by(sort));
        }


        return repository.findAll();
    }
}