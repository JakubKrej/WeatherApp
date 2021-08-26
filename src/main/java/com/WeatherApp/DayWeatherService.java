package com.WeatherApp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.math.BigDecimal;
import java.net.URI;

@Service
public class DayWeatherService {

    private static final String WEATHER_URL1 = "https://api.openweathermap.org/data/2.5/weather?q={city}&units=metric&appid={apiKey}";
    private static final String WEATHER_URL2 = "https://api.openweathermap.org/data/2.5/onecall?lat={lat}&lon={lon}&lang=pl&units=metric&cnt=7&appid={apiKey}";
    private String apiKey = "82147517e164e7f3f595dd941837b9be";

    private String lat;
    private String lon;
    public String name;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public DayWeatherService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public DayWeather getDayTemp(String city){

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


    private DayWeather convert(ResponseEntity<String> response) {
        try {
            JsonNode root = objectMapper.readTree(response.getBody());

            return  new DayWeather((BigDecimal.valueOf(root.path("daily").get(0).path("temp").path("morn").asDouble()).intValue()),
                    (BigDecimal.valueOf(root.path("daily").get(0).path("temp").path("eve").asDouble()).intValue()),
                    (BigDecimal.valueOf(root.path("daily").get(0).path("temp").path("night").asDouble())).intValue());

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }

    }
}
