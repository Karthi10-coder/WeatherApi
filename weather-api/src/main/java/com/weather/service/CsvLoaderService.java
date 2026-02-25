package com.weather.service;

import com.weather.entity.Weather;
import com.weather.repository.WeatherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class CsvLoaderService {

    private double parseDoubleSafe(String value) {
        if (value == null || value.isBlank() || value.equalsIgnoreCase("N/A")) {
            return 0.0;
        }
        return Double.parseDouble(value);
    }

    @Bean
    CommandLineRunner loadData(WeatherRepository repository) {
        return args -> {

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            getClass().getResourceAsStream("/testset.csv")
                    )
            );

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {

                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] data = line.split(",");

                Weather weather = new Weather();

                weather.setDatetime(data[0]);
                weather.setCondition(data[1]);
                weather.setDewPoint(parseDoubleSafe(data[2]));
                weather.setHumidity(parseDoubleSafe(data[3]));
                weather.setPressure(parseDoubleSafe(data[4]));
                weather.setTemperature(parseDoubleSafe(data[5]));
                weather.setWindSpeed(parseDoubleSafe(data[6]));

                repository.save(weather);
            }

            System.out.println("✅ CSV DATA LOADED INTO DATABASE");
        };
    }
}
