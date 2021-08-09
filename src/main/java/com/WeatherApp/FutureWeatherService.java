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
public class FutureWeatherService {

    private static final String WEATHER_URL1 = "https://api.openweathermap.org/data/2.5/weather?q={city}&units=metric&appid={apiKey}";
    private static final String WEATHER_URL2 = "https://api.openweathermap.org/data/2.5/onecall?lat={lat}&lon={lon}&lang=pl&units=metric&cnt=7&appid={apiKey}";

    private String apiKey = "82147517e164e7f3f595dd941837b9be";

    private String lat;
    private String lon;
    public String name;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public FutureWeatherService(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
        this.restTemplate = restTemplateBuilder.build();
        this.objectMapper = objectMapper;
    }

    public FutureWeather getFutureWeatherByCity(String city){

        URI url = new UriTemplate(WEATHER_URL1).expand(city,apiKey);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        try {
            JsonNode root = objectMapper.readTree(response.getBody());

            lat = root.path("coord").path("lat").asText();
            lon = root.path("coord").path("lon").asText();
            name = root.path("name").asText();

            System.out.println(lat + " " + lon + " " + name);

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }

        URI url2 = new UriTemplate(WEATHER_URL2).expand(lat,lon,apiKey);
        ResponseEntity<String> response2 = restTemplate.getForEntity(url2, String.class);

        return convert(response2);

    }


    private FutureWeather convert(ResponseEntity<String> response) {
        try {
            JsonNode root = objectMapper.readTree(response.getBody());

            return  new FutureWeather(name,
                    BigDecimal.valueOf(root.path("daily").get(0).path("temp").path("day").asDouble()),
                    BigDecimal.valueOf(root.path("daily").get(1).path("temp").path("day").asDouble()),
                    BigDecimal.valueOf(root.path("daily").get(2).path("temp").path("day").asDouble()),
                    BigDecimal.valueOf(root.path("daily").get(3).path("temp").path("day").asDouble()),
                    BigDecimal.valueOf(root.path("daily").get(4).path("temp").path("day").asDouble()),
                    BigDecimal.valueOf(root.path("daily").get(5).path("temp").path("day").asDouble()),
                    BigDecimal.valueOf(root.path("daily").get(6).path("temp").path("day").asDouble()),
                    BigDecimal.valueOf(root.path("daily").get(7).path("temp").path("day").asDouble())
                    );

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }

    }


    private String ConvertTime(int time){

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
}
