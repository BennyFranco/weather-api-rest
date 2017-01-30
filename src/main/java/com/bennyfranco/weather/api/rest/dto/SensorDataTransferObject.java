package com.bennyfranco.weather.api.rest.dto;


import org.bson.types.ObjectId;

/**
 * An entity class to describe the station sensors.
 *
 * @author Benny Franco
 * @version 0.0.1 29 ene 2017
 */
public class SensorDataTransferObject {
    private ObjectId id;
    private String name;
    private String value;

    public SensorDataTransferObject() {
    }

    public SensorDataTransferObject(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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
