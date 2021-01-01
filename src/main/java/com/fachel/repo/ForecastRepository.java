package com.fachel.repo;

import com.fachel.model.Forecast;
import org.springframework.data.repository.CrudRepository;

public interface ForecastRepository extends CrudRepository<Forecast, Long> {
}
