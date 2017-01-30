package com.bennyfranco.weather.api.rest.services.exceptions;

/**
 * Class description here
 *
 * @author Benny Franco
 * @version 0.0.1 29 ene 2017
 */
public class StationAlreadyRegisteredException extends StationException {
    public StationAlreadyRegisteredException(String message) {
        super(message);
    }
}
