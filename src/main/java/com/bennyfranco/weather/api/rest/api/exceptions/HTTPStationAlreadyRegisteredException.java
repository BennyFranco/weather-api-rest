package com.bennyfranco.weather.api.rest.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class description here
 *
 * @author Benny Franco
 * @version 0.0.1 29 ene 2017
 */

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Station is already registered.")
public class HTTPStationAlreadyRegisteredException extends Exception {
    private HttpStatus status;

    public HTTPStationAlreadyRegisteredException(String message) {
        super(message);
        this.status = HttpStatus.CONFLICT;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
