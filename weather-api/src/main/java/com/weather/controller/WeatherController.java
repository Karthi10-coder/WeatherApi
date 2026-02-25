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

    // GET ALL + FILTER + SORT
    @GetMapping
    public List<Weather> getWeather(
            @RequestParam(required = false) String condition,
            @RequestParam(required = false) String sort
    ) {

        // FILTER + SORT
        if (condition != null && sort != null) {
            return repository.findAll(
                            Sort.by(sort)
                    ).stream()
                    .filter(w -> w.getCondition().equalsIgnoreCase(condition))
                    .toList();
        }

        // ONLY FILTER
        if (condition != null) {
            return repository.findByCondition(condition);
        }

        // ONLY SORT
        if (sort != null) {
            return repository.findAll(Sort.by(sort));
        }

        // DEFAULT → RETURN ALL
        return repository.findAll();
    }
}