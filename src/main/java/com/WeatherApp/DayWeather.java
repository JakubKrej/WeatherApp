package com.WeatherApp;

import java.math.BigDecimal;

public class DayWeather {

    private BigDecimal morningTemp;
    private BigDecimal middayTemp;
    private BigDecimal eveningTemp;

    public DayWeather(BigDecimal morningTemp, BigDecimal middayTemp, BigDecimal eveningTemp) {
        this.morningTemp = morningTemp;
        this.middayTemp = middayTemp;
        this.eveningTemp = eveningTemp;
    }

    public BigDecimal getMorningTemp() {
        return morningTemp;
    }

    public void setMorningTemp(BigDecimal morningTemp) {
        this.morningTemp = morningTemp;
    }

    public BigDecimal getMiddayTemp() {
        return middayTemp;
    }

    public void setMiddayTemp(BigDecimal middayTemp) {
        this.middayTemp = middayTemp;
    }

    public BigDecimal getEveningTemp() {
        return eveningTemp;
    }

    public void setEveningTemp(BigDecimal eveningTemp) {
        this.eveningTemp = eveningTemp;
    }
}
