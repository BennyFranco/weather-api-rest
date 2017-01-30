package com.bennyfranco.weather.api.rest.api.exceptions;

import com.bennyfranco.weather.api.rest.api.responses.WeatherResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Class description here
 *
 * @author Benny Franco
 * @version 0.0.1 26 ene 2017
 */
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({HTTPStationNotFound.class})
    public ResponseEntity<Object> handleHTTPPeopleNotFoundException(HTTPStationNotFound ex) {

        WeatherResponse apiResponse = new WeatherResponse(ex.getStatus(), ex.getLocalizedMessage());
        return new ResponseEntity<>(apiResponse, new HttpHeaders(), apiResponse.getStatus());
    }
}
