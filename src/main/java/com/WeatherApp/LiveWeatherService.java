package com.WeatherApp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Date;

@Service
public class LiveWeatherService {

    private static final String WEATHER_URL1 = "https://api.openweathermap.org/data/2.5/weather?q={city}&units=metric&appid={apiKey}";
    private String apiKey = "82147517e164e7f3f595dd941837b9be";

    public String city;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public LiveWeatherService(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
        this.restTemplate = restTemplateBuilder.build();
        this.objectMapper = objectMapper;
    }

    public CurrentWeather getCurrentWeatherByCity(String city){

        System.out.println("aaaaa");
        System.out.println(city);
        System.out.println("aaaaa");

        URI url = new UriTemplate(WEATHER_URL1).expand(city,apiKey);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return convert(response);

    }


    private CurrentWeather convert(ResponseEntity<String> response) {
        try {
            JsonNode root = objectMapper.readTree(response.getBody());

            return  new CurrentWeather(root.path("name").asText(),
                    (BigDecimal.valueOf(root.path("main").path("temp").asDouble()).intValue()),
                    root.path("weather").get(0).path("description").asText(),
                    BigDecimal.valueOf(root.path("clouds").path("all").asDouble()));
//                return new CurrentWeather(name,
//                    root.path("current").path("weather").get(0).path("description").asText(),
//                    BigDecimal.valueOf(root.path("current").path("feels_like").asDouble()),
//                    BigDecimal.valueOf(root.path("current").path("temp").asDouble()),
//                    BigDecimal.valueOf(root.path("current").path("wind_speed").asDouble()),
//                    ConvertTime((root.path("current").path("sunrise")).asInt()));

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }

    }


    public String ConvertTime(){

        Date timee = new Date();
        String day;
        switch(timee.getDay()){
            case 1:
                day = "Monday";
                break;
            case 2:
                day = "Tuesday";
                break;
            case 3:
                day = "Wednesday";
                break;
            case 4:
                day = "Thursday";
                break;
            case 5:
                day = "Friday";
                break;
            case 6:
                day = "Saturday";
                break;
            case 0:
                day = "Sunday";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + timee.getDay());
        }

        return day;
    }

//    private CurrentWeather convert(ResponseEntity<String> response) {
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(String.valueOf(response));
//        JsonNode fi1 = jsonNode.get("main");
//        JsonNode fi2 = jsonNode.get("temp");
//        JsonNode fi3 = jsonNode.get("feels_like");
//        JsonNode fi4 = jsonNode.get("speed");
//
//        return
//    }

}