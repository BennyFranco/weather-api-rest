package com.bennyfranco.weather.api.rest.dto;


/**
 * An entity class to describe the station sensors.
 *
 * @author Benny Franco
 * @version 0.0.1 29 ene 2017
 */
public class Sensor {
    private String id;
    private String name;
    private String value;

    public Sensor() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
