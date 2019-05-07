package com.glanse.microservices.service.web.controller;

import com.glanse.microservices.service.web.model.City;
import com.glanse.microservices.service.web.model.CurrentWeather;
import com.glanse.microservices.service.web.model.Weather;
import com.glanse.microservices.service.web.repository.CurrentWeatherRepository;
import com.glanse.microservices.service.web.repository.WeatherRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.*;

@RestController
public class WeatherRestController {

    @Value("classpath:static/json/city.list.json")
    private Resource cityListJson;

    private final CurrentWeatherRepository currentWeatherRepository;
    private final WeatherRepository weatherRepository;
    private final City city;

    public WeatherRestController(CurrentWeatherRepository currentWeatherRepository, @Qualifier("weatherRepository") WeatherRepository weatherRepository, City city) {
        this.currentWeatherRepository = currentWeatherRepository;
        this.weatherRepository = weatherRepository;
        this.city = city;
    }

    @GetMapping("/getcityid")
    public ArrayList<City> getCityId(@RequestParam(name = "city") String query) {
        ArrayList<City> cities = new ArrayList<>();
        try {
            FileInputStream stream = new FileInputStream(cityListJson.getFile());
            JsonReader reader = new JsonReader(new InputStreamReader(stream));
            Gson gson = new GsonBuilder().create();

            reader.beginArray();
            while (reader.hasNext()) {
                City city = gson.fromJson(reader, City.class);
                if (city.getName().equalsIgnoreCase(query)) {
                    cities.add(city);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }

    @GetMapping("/weathercheck")
    public Map<String, Boolean> checkWeatherUpdate(@RequestParam(name = "cityId") String cityId) {
        Optional<CurrentWeather> weatherOptional = currentWeatherRepository.findById(Long.parseLong(cityId));
        if (weatherOptional.isPresent()) {
            CurrentWeather currentWeather = weatherOptional.get();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(System.currentTimeMillis()));
            calendar.add(Calendar.HOUR, -2);
            if (currentWeather.getUpdatedAt().after(new Timestamp(calendar.getTimeInMillis()))) {
                return Collections.singletonMap("valid", true);
            }
        }
        return Collections.singletonMap("valid", false);
    }

    @PostMapping("/postweather")
    public CurrentWeather postCurrentWeather(@RequestBody CurrentWeather currentWeather) {
        for (Weather weather : currentWeather.getWeather()) {
            if (!weatherRepository.existsById(weather.getId())) {
                weatherRepository.save(weather);
            }
        }
        return currentWeatherRepository.save(currentWeather);
    }

    @GetMapping("/getweather")
    public CurrentWeather getCurrentWeather(@RequestParam(name = "cityId") String cityId) {
        Optional<CurrentWeather> optionalCurrentWeather = currentWeatherRepository.findById(Long.parseLong(cityId));
        if (optionalCurrentWeather.isPresent()) {
            return optionalCurrentWeather.get();
        }
        throw new EntityNotFoundException(cityId);
    }
}