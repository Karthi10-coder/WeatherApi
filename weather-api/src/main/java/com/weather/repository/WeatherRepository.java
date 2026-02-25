package com.weather.repository;

import com.weather.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

    // FILTER BY CONDITION
    List<Weather> findByCondition(String condition);
}