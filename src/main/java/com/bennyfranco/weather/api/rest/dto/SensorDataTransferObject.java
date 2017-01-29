package com.bennyfranco.weather.api.rest.dto;


/**
 * An entity class to describe the station sensors.
 *
 * @author Benny Franco
 * @version 0.0.1 29 ene 2017
 */
public class SensorDataTransferObject {
    private String id;
    private String name;
    private String value;

    public SensorDataTransferObject() {
    }

    public SensorDataTransferObject(String id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
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
