package com.fachel.controller;

import com.fachel.json.ForecastJson;
import com.fachel.model.Forecast;
import com.fachel.repo.ForecastRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Data
@RestController
@EnableScheduling
public class WeatherController {
    private int count = 0;
    private RestTemplate restTemplate;
    private String URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    @Value("${api.weather.key}")
    private String API;
    private String Utils = "metric";
    private String City = "Bryansk";
    @Autowired
    private ForecastRepository forecastRepository;

    @Scheduled(fixedRate = 10000)
    @GetMapping("/weather")
    public ForecastJson getWeather(){
        restTemplate = new RestTemplate();
        ForecastJson data =  restTemplate.getForObject(URL + getCity() + "&APPID=" + getAPI() + "&units=" + getUtils(), ForecastJson.class);
        Forecast forecast = new Forecast(City,
                                        LocalDateTime.now(),
                                        data.getMain().get("temp"),
                                        data.getMain().get("feels_like"),
                                        data.getWeatherJson().get(0).getMain(),
                                        data.getWeatherJson().get(0).getDesc(),
                                        data.getMain().get("temp_min"),
                                        data.getMain().get("temp_max"),
                                        data.getMain().get("pressure"));
        forecastRepository.save(forecast);
        return data;
    }
}
