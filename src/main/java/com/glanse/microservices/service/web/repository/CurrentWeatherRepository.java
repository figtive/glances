package com.glanse.microservices.service.web.repository;

import com.glanse.microservices.service.web.model.CurrentWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrentWeatherRepository extends JpaRepository<CurrentWeather, Long> {

    List<CurrentWeather> findAllById(long id);
}
