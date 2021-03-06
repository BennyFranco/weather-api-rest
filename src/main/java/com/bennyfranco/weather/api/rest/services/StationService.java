package com.bennyfranco.weather.api.rest.services;

import com.bennyfranco.weather.api.rest.dto.StationDataTransferObject;
import com.bennyfranco.weather.api.rest.entities.Station;
import com.bennyfranco.weather.api.rest.services.exceptions.SensorsNotFoundException;
import com.bennyfranco.weather.api.rest.services.exceptions.StationAlreadyRegisteredException;
import com.bennyfranco.weather.api.rest.services.exceptions.StationException;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class description here
 *
 * @author Benny Franco
 * @version 0.0.1 29 ene 2017
 */
@Service
public interface StationService {
    StationDataTransferObject create(Station station) throws SensorsNotFoundException, StationAlreadyRegisteredException;

    StationDataTransferObject update(Station station) throws StationException;

    StationDataTransferObject findByName(String name) throws StationException;

    StationDataTransferObject findById(ObjectId id) throws StationException;

    List<StationDataTransferObject> findAll();
}
