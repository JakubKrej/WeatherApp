package com.WeatherApp;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.util.UriTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Date;


@Controller
public class CurrentWeatherController {

    private final LiveWeatherService liveWeatherService;
    private final DayWeatherService dayWeatherService;
    private final FutureWeatherService futureWeatherService;

    public int dnumber;

    public CurrentWeatherController( LiveWeatherService liveWeatherService, DayWeatherService dayWeatherService, FutureWeatherService futureWeatherService) {
        this.liveWeatherService = liveWeatherService;
        this.dayWeatherService = dayWeatherService;
        this.futureWeatherService = futureWeatherService;
    }

    @RequestMapping("/")
    public String home()
    {

        long unixTime = System.currentTimeMillis() / 1000L;
        System.out.println(unixTime);

        return "citySearch";
    }

    @GetMapping("/week-weather")
    public String getWeekWeather(Model model, City city) {

        String cityName = city.getCity();

        try {

            model.addAttribute("currentWeather", liveWeatherService.getCurrentWeatherByCity(cityName));
            model.addAttribute("futureWeather", futureWeatherService.getFutureWeatherByCity(cityName));
            model.addAttribute("dayofweek", liveWeatherService.ConvertTime());

        }catch (HttpStatusCodeException exception) {

            System.out.println("Podane miasto nie znajduje się w bazie danych");
            return("citySearch");
        }

        return "weekWeather";
    }

//    @GetMapping("/current-weather")
//    public String getCurrentWeather(Model model, City city) {
//
//        String cityName = city.getCity();
//
//        System.out.println( "controller 2 " + cityName);
//
//        model.addAttribute("currentWeather", liveWeatherService.getCurrentWeatherByCity(cityName));
//        model.addAttribute("dayWeather", dayWeatherService.getDayTemp(cityName));
//
//        return "weather-ccr";
//    }

    @GetMapping("/dayweather{dnumber}")
    public String getDayWeather(Model model, City city, @PathVariable("dnumber") int dnumber){

        String cityName = city.getCity();

        model.addAttribute("currentWeather", liveWeatherService.getCurrentWeatherByCity(cityName));
        model.addAttribute("dayWeather", dayWeatherService.getDayTemp(cityName,dnumber));

        return "weather-ccr";
    }
}