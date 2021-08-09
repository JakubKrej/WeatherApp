package com.WeatherApp;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;


@Controller
public class CurrentWeatherController {

    private final LiveWeatherService liveWeatherService;
    private final DayWeatherService dayWeatherService;
    private final FutureWeatherService futureWeatherService;

    public CurrentWeatherController( LiveWeatherService liveWeatherService, DayWeatherService dayWeatherService, FutureWeatherService futureWeatherService) {
        this.liveWeatherService = liveWeatherService;
        this.dayWeatherService = dayWeatherService;
        this.futureWeatherService = futureWeatherService;
    }

    @RequestMapping("/")
    public String home()
    {
        return "citySearch";
    }

    @GetMapping("/week-weather")
    public String getWeekWeather(Model model, City city) {

        String cityName = city.getCity();

        System.out.println( "controller 1 " + cityName);

        model.addAttribute("currentWeather", liveWeatherService.getCurrentWeatherByCity(cityName));
        model.addAttribute("futureWeather", futureWeatherService.getFutureWeatherByCity(cityName));



//        past weather
//        current weather
//        feature weather

        return "weekWeather";
    }

    @GetMapping("/current-weather")
    public String getCurrentWeather(Model model, City city) {

        String cityName = city.getCity();

        System.out.println( "controller 2 " + cityName);

        model.addAttribute("currentWeather", liveWeatherService.getCurrentWeatherByCity(cityName));
        model.addAttribute("dayWeather", dayWeatherService.getDayTemp(cityName));

//        past weather
//        current weather
//        feature weather

        return "weather-ccr";
    }
}