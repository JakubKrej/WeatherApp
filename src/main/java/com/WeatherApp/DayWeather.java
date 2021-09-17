package com.WeatherApp;

import java.math.BigDecimal;

public class DayWeather {

    private int morningTemp;
    private int middayTemp;
    private int eveningTemp;
    private int temperature;
    private String description;
    private BigDecimal cloudPer;
    private String mainDesc;

    public DayWeather(int morningTemp, int middayTemp, int eveningTemp, int temperature, String description, BigDecimal cloudPer, String mainDesc) {
        this.morningTemp = morningTemp;
        this.middayTemp = middayTemp;
        this.eveningTemp = eveningTemp;
        this.temperature = temperature;
        this.description = description;
        this.cloudPer = cloudPer;
        this.mainDesc = mainDesc;
    }

    public int getMorningTemp() {
        return morningTemp;
    }

    public void setMorningTemp(int morningTemp) {
        this.morningTemp = morningTemp;
    }

    public int getMiddayTemp() {
        return middayTemp;
    }

    public void setMiddayTemp(int middayTemp) {
        this.middayTemp = middayTemp;
    }

    public int getEveningTemp() {
        return eveningTemp;
    }

    public void setEveningTemp(int eveningTemp) {
        this.eveningTemp = eveningTemp;
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

    public String getMainDesc() {
        return mainDesc;
    }

    public void setMainDesc(String mainDesc) {
        this.mainDesc = mainDesc;
    }
}
