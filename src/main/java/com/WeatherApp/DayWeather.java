package com.WeatherApp;

import java.math.BigDecimal;

public class DayWeather {

    private int morningTemp;
    private int middayTemp;
    private int eveningTemp;

    public DayWeather(int morningTemp, int middayTemp, int eveningTemp) {
        this.morningTemp = morningTemp;
        this.middayTemp = middayTemp;
        this.eveningTemp = eveningTemp;
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
}
