package com.WeatherApp;

import java.math.BigDecimal;

public class FutureWeather {

    private String city;
    private BigDecimal curentDayTemp;
    private BigDecimal secendDayTemp;
    private BigDecimal thirdDayTemp;
    private BigDecimal fourthDayTemp;
    private BigDecimal fifthDayTemp;
    private BigDecimal sixthDayTemp;
    private BigDecimal seventhDayTemp;
    private BigDecimal eighthDayTemp;

    public FutureWeather(String city , BigDecimal curentDayTemp, BigDecimal secendDayTemp, BigDecimal thirdDayTemp, BigDecimal fourthDayTemp, BigDecimal fifthDayTemp, BigDecimal sixthDayTemp, BigDecimal seventhDayTemp, BigDecimal eighthDayTemp) {
        this.city = city;
        this.curentDayTemp = curentDayTemp;
        this.secendDayTemp = secendDayTemp;
        this.thirdDayTemp = thirdDayTemp;
        this.fourthDayTemp = fourthDayTemp;
        this.fifthDayTemp = fifthDayTemp;
        this.sixthDayTemp = sixthDayTemp;
        this.seventhDayTemp = seventhDayTemp;
        this.eighthDayTemp = eighthDayTemp;
    }

    public BigDecimal getCurentDayTemp() {
        return curentDayTemp;
    }

    public void setCurentDayTemp(BigDecimal curentDayTemp) {
        this.curentDayTemp = curentDayTemp;
    }

    public BigDecimal getSecendDayTemp() {
        return secendDayTemp;
    }

    public void setSecendDayTemp(BigDecimal secendDayTemp) {
        this.secendDayTemp = secendDayTemp;
    }

    public BigDecimal getThirdDayTemp() {
        return thirdDayTemp;
    }

    public void setThirdDayTemp(BigDecimal thirdDayTemp) {
        this.thirdDayTemp = thirdDayTemp;
    }

    public BigDecimal getFourthDayTemp() {
        return fourthDayTemp;
    }

    public void setFourthDayTemp(BigDecimal fourthDayTemp) {
        this.fourthDayTemp = fourthDayTemp;
    }

    public BigDecimal getFifthDayTemp() {
        return fifthDayTemp;
    }

    public void setFifthDayTemp(BigDecimal fifthDayTemp) {
        this.fifthDayTemp = fifthDayTemp;
    }

    public BigDecimal getSixthDayTemp() {
        return sixthDayTemp;
    }

    public void setSixthDayTemp(BigDecimal sixthDayTemp) {
        this.sixthDayTemp = sixthDayTemp;
    }

    public BigDecimal getSeventhDayTemp() {
        return seventhDayTemp;
    }

    public void setSeventhDayTemp(BigDecimal seventhDayTemp) {
        this.seventhDayTemp = seventhDayTemp;
    }

    public BigDecimal getEighthDayTemp() {
        return eighthDayTemp;
    }

    public void setEighthDayTemp(BigDecimal eighthDayTemp) {
        this.eighthDayTemp = eighthDayTemp;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
