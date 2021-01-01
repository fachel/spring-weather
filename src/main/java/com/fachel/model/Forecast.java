package com.fachel.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Forecast {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String city;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    private Double temp;

    private Double feels_like;

    private String main;

    private String description;

    private Double temp_min;

    private Double temp_max;

    private Double pressure;

    public Forecast(String city, LocalDateTime date, Double temp, Double feels_like, String main, String description, Double temp_min, Double temp_max, Double pressure) {
        this.city = city;
        this.date = date;
        this.temp = temp;
        this.feels_like = feels_like;
        this.main = main;
        this.description = description;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
    }
}
