package com.bennyfranco.weather.api.rest.api.responses;

import org.springframework.http.HttpStatus;

/**
 * Class description here
 *
 * @author Benny Franco
 * @version 0.0.1 26 ene 2017
 */
public class WeatherResponse<T> {

    private HttpStatus status;
    private T data;
    private String message;

    public WeatherResponse(HttpStatus status, String message) {
        this.status = status;
        this.data = null;
        this.message = message;
    }

    public WeatherResponse(HttpStatus status, T data) {
        this.status = status;
        this.data = data;
        this.message = null;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}