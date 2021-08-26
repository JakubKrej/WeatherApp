package com.WeatherApp;

import java.io.Serializable;
import java.math.BigDecimal;

public class CurrentWeather implements Serializable {


    private String cityName;
    private int temperature;
    private String description;
    private BigDecimal cloudPer;

    public CurrentWeather(String cityName, int temperature, String description, BigDecimal cloudPer) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.description = description;
        this.cloudPer = cloudPer;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCloudPer() {
        return cloudPer;
    }

    public void setCloudPer(BigDecimal cloudPer) {
        this.cloudPer = cloudPer;
    }

    //    public String name;
//    private String description;
//    private BigDecimal temperature;
//    private BigDecimal feelsLike;
//    private BigDecimal windSpeed;
//    private String time;
//
//    public CurrentWeather(String description, BigDecimal temperature, BigDecimal windSpeed, String time) {
//        this.description = description;
//        this.temperature = temperature;
//        this.windSpeed = windSpeed;
//        this.time = time;
//    }
//
//
//    public CurrentWeather(String description, BigDecimal temperature, BigDecimal feelsLike, BigDecimal windSpeed) {
//        this.description = description;
//        this.temperature = temperature;
//        this.feelsLike = feelsLike;
//        this.windSpeed = windSpeed;
//    }
//
//    public CurrentWeather(String name, String description, BigDecimal temperature, BigDecimal feelsLike, BigDecimal windSpeed, String time) {
//        this.name = name;
//        this.description = description;
//        this.temperature = temperature;
//        this.feelsLike = feelsLike;
//        this.windSpeed = windSpeed;
//        this.time = time;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public BigDecimal getTemperature() {
//        return temperature;
//    }
//
//    public void setTemperature(BigDecimal temperature) {
//        this.temperature = temperature;
//    }
//
//    public BigDecimal getFeelsLike() {
//        return feelsLike;
//    }
//
//    public void setFeelsLike(BigDecimal feelsLike) {
//        this.feelsLike = feelsLike;
//    }
//
//    public BigDecimal getWindSpeed() {
//        return windSpeed;
//    }
//
//    public void setWindSpeed(BigDecimal windSpeed) {
//        this.windSpeed = windSpeed;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    // boilerplate getters, constructors, equals, and hashcode omitted
}