package com.fachel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForecastJson {

    @JsonProperty("weather")
    private List<WeatherJson> weatherJson;

    @JsonProperty("main")
    @JsonIgnoreProperties("humidity")
    private Map<String, Double> main;

}
