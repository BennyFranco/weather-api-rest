package com.bennyfranco.weather.api.rest.services;

import com.bennyfranco.weather.api.rest.dto.StationDataTransferObject;
import com.bennyfranco.weather.api.rest.entities.Station;
import com.bennyfranco.weather.api.rest.services.exceptions.StationException;

/**
 * Class description here
 *
 * @author Benny Franco
 * @version 0.0.1 29 ene 2017
 */
public interface StationService {
    StationDataTransferObject create(Station station) throws StationException;
}
