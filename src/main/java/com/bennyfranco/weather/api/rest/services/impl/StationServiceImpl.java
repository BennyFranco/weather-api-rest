package com.bennyfranco.weather.api.rest.services.impl;

import com.bennyfranco.weather.api.rest.dto.SensorDataTransferObject;
import com.bennyfranco.weather.api.rest.dto.StationDataTransferObject;
import com.bennyfranco.weather.api.rest.entities.Sensor;
import com.bennyfranco.weather.api.rest.entities.Station;
import com.bennyfranco.weather.api.rest.repositories.StationRepository;
import com.bennyfranco.weather.api.rest.services.StationService;
import com.bennyfranco.weather.api.rest.services.exceptions.SensorsNotFoundException;
import com.bennyfranco.weather.api.rest.services.exceptions.StationException;

import java.util.ArrayList;
import java.util.List;

/**
 * Service and bussines logic for StationDataTransferObject
 *
 * @author Benny Franco
 * @version 0.0.1 29 ene 2017
 */
public class StationServiceImpl implements StationService {

    private StationRepository stationRepository;

    public StationServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public StationDataTransferObject create(Station station) throws StationException {
        if (station.getSensors() == null || station.getSensors().isEmpty()) {
            throw new SensorsNotFoundException("You don't have any sensor registered for this station");
        }
        return entityToDto(this.stationRepository.save(station));
    }

    private StationDataTransferObject entityToDto(Station entity) {
        StationDataTransferObject dto = new StationDataTransferObject();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDateTime(entity.getDateTime());
        dto.setFileName(entity.getFileName());
        dto.setSensorDataTransferObjects(sensorEntityToDto(entity.getSensors()));

        return dto;
    }

    private List<SensorDataTransferObject> sensorEntityToDto(List<Sensor> sensorEntityList) {

        List<SensorDataTransferObject> newSensorList = new ArrayList<>();

        sensorEntityList.forEach(sensor -> {
            SensorDataTransferObject transferObject = new SensorDataTransferObject(sensor.getId(), sensor.getName(), sensor.getValue());
            newSensorList.add(transferObject);
        });

        return newSensorList;
    }
}
