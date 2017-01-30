package com.bennyfranco.weather.api.rest.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * An entity class to describe the station sensors.
 *
 * @author Benny Franco
 * @version 0.0.1 29 ene 2017
 */

@Document
public class Sensor {
    @Id
    private ObjectId id;
    @Indexed
    private String name;
    private String value;

    public Sensor() {
        this.id = new ObjectId();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sensor sensor = (Sensor) o;

        return getId().equals(sensor.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
