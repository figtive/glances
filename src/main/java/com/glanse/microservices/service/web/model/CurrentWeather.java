package com.glanse.microservices.service.web.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
@Entity
@Table(schema = "glanse")
public class CurrentWeather {

    @Id
    private long id;

    @Column
    @ElementCollection
    private Map<String, Float> coord;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(
            name = "current_weather_weather",
            joinColumns = @JoinColumn(name = "current_id"),
            inverseJoinColumns = @JoinColumn(name = "weather_id")
    )
    private List<Weather> weather;

    @Column
    private String base;

    @Column
    @ElementCollection
    private Map<String, Float> main;

    @Column
    private int visibility;

    @Column
    @ElementCollection
    private Map<String, Float> wind;

    @Column
    @ElementCollection
    private Map<String, Integer> clouds;

    @Column
    @ElementCollection
    private Map<String, Integer> rain;

    @Column
    @ElementCollection
    private Map<String, Integer> snow;

    @Column
    private String dt;

    @Column
    @ElementCollection
    private Map<String, String> sys;

    @Column
    private String name;

    @Column
    private int cod;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAt;

    public CurrentWeather() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<String, Float> getCoord() {
        return coord;
    }

    public void setCoord(Map<String, Float> coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, Float> getMain() {
        return main;
    }

    public void setMain(Map<String, Float> main) {
        this.main = main;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Map<String, Float> getWind() {
        return wind;
    }

    public void setWind(Map<String, Float> wind) {
        this.wind = wind;
    }

    public Map<String, Integer> getClouds() {
        return clouds;
    }

    public void setClouds(Map<String, Integer> clouds) {
        this.clouds = clouds;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Map<String, String> getSys() {
        return sys;
    }

    public void setSys(Map<String, String> sys) {
        this.sys = sys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Map<String, Integer> getRain() {
        return rain;
    }

    public void setRain(Map<String, Integer> rain) {
        this.rain = rain;
    }

    public Map<String, Integer> getSnow() {
        return snow;
    }

    public void setSnow(Map<String, Integer> snow) {
        this.snow = snow;
    }
}
