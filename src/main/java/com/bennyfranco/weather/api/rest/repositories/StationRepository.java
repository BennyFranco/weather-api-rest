package com.bennyfranco.weather.api.rest.repositories;

import com.bennyfranco.weather.api.rest.entities.Station;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * Crud repository interface for station.
 *
 * @author Benny Franco
 * @version 0.0.1 29 ene 2017
 */

public interface StationRepository extends MongoRepository<Station,String> {
    Station findByName(String name);
}
