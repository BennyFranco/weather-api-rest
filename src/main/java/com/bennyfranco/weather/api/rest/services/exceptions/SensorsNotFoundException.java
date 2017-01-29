package com.bennyfranco.weather.api.rest.services.exceptions;

/**
 * This exception occurs when the Station object doesn't have any Sensor
 *
 * @author Benny Franco
 * @version 0.0.1 29 ene 2017
 */
public class SensorsNotFoundException extends StationException {
    public SensorsNotFoundException(String message) {
        super(message);
    }
}
