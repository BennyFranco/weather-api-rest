package com.bennyfranco.weather.api.rest.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class description here
 *
 * @author Benny Franco
 * @version 0.0.1 29 ene 2017
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Station isn't registered")
public class HTTPStationNotFound extends Exception {
    private HttpStatus status;

    public HTTPStationNotFound(String message) {
        super(message);
        status = HttpStatus.NOT_FOUND;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
