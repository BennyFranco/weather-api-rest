package com.bennyfranco.weather.api.rest.api.controllers;

import com.bennyfranco.weather.api.rest.api.exceptions.HTTPStationAlreadyRegisteredException;
import com.bennyfranco.weather.api.rest.api.exceptions.HTTPStationNotFound;
import com.bennyfranco.weather.api.rest.api.responses.WeatherResponse;
import com.bennyfranco.weather.api.rest.entities.Station;
import com.bennyfranco.weather.api.rest.services.StationService;
import com.bennyfranco.weather.api.rest.services.exceptions.SensorsNotFoundException;
import com.bennyfranco.weather.api.rest.services.exceptions.StationAlreadyRegisteredException;
import com.bennyfranco.weather.api.rest.services.exceptions.StationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Station Rest controller for HTTP access.
 *
 * @author Benny Franco
 * @version 0.0.1 29 ene 2017
 */

@RestController
@RequestMapping("api/stations")
public class StationController {

    private StationService stationService;

    @Autowired
    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public WeatherResponse create(@RequestBody Station station) throws HTTPStationNotFound, HTTPStationAlreadyRegisteredException {
        try {
            return new WeatherResponse<>(HttpStatus.OK, this.stationService.create(station));
        } catch (SensorsNotFoundException e) {
            throw new HTTPStationNotFound(e.getMessage());
        } catch (StationAlreadyRegisteredException e) {
            throw new HTTPStationAlreadyRegisteredException(e.getMessage());
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public WeatherResponse update(@RequestBody Station station) throws HTTPStationNotFound  {
        try {
            return new WeatherResponse<>(HttpStatus.OK, this.stationService.update(station));
        } catch (StationException e) {
            throw new HTTPStationNotFound(e.getMessage());
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public WeatherResponse getAllStations()   {
        return new WeatherResponse<>(HttpStatus.OK, this.stationService.findAll());
    }
}
