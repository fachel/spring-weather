package com.fachel.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeName("weather")
public class WeatherJson {

    @JsonProperty("main")
    private String main;

    @JsonProperty("description")
    private String desc;
}
