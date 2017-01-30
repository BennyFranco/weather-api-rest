package com.bennyfranco.weather.api.rest.dto;


import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

/**
 * An entity class of the climate station.
 *
 * @author Benny Franco
 * @version 0.0.1 29 ene 2017
 */

public class StationDataTransferObject {
    private ObjectId id;
    private String name;
    private Date dateTime;
    private String fileName;
    private List<SensorDataTransferObject> sensors;


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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<SensorDataTransferObject> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorDataTransferObject> sensors) {
        this.sensors = sensors;
    }
}
