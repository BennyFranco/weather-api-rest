package com.bennyfranco.weather.api.rest.services.impl;

import com.bennyfranco.weather.api.rest.dto.SensorDataTransferObject;
import com.bennyfranco.weather.api.rest.dto.StationDataTransferObject;
import com.bennyfranco.weather.api.rest.entities.Sensor;
import com.bennyfranco.weather.api.rest.entities.Station;
import com.bennyfranco.weather.api.rest.repositories.StationRepository;
import com.bennyfranco.weather.api.rest.services.StationService;
import com.bennyfranco.weather.api.rest.services.exceptions.SensorsNotFoundException;
import com.bennyfranco.weather.api.rest.services.exceptions.StationAlreadyRegisteredException;
import com.bennyfranco.weather.api.rest.services.exceptions.StationException;
import com.bennyfranco.weather.api.rest.services.exceptions.StationNotFound;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service and business logic for StationDataTransferObject
 *
 * @author Benny Franco
 * @version 0.0.1 29 ene 2017
 */
@Service
public class StationServiceImpl implements StationService {

    private StationRepository stationRepository;

    public StationServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public StationDataTransferObject create(Station station) throws SensorsNotFoundException, StationAlreadyRegisteredException {
        if (station.getSensors() == null || station.getSensors().isEmpty()) {
            throw new SensorsNotFoundException("You don't have any sensor registered for this station.");
        } else if (this.stationRepository.findByName(station.getName()) != null) {
            throw new StationAlreadyRegisteredException("The station is already registered.");
        }
        return entityToDto(this.stationRepository.save(station));
    }

    @Override
    public StationDataTransferObject update(Station station) throws StationException {
        if (station.getId() == null) {
            throw new StationException("Station id can't be null.");
        }

        Station foundStation = this.stationRepository.findOne(station.getId());

        if (foundStation == null) {
            throw new StationNotFound("The station is unregistered.");
        }
        return entityToDto(this.stationRepository.save(station));
    }

    @Override
    public StationDataTransferObject findByName(String name) throws StationException {
        Station foundStation = this.stationRepository.findByName(name);
        if (foundStation == null) {
            throw new StationNotFound("The station is unregistered");
        }
        return entityToDto(foundStation);
    }

    @Override
    public StationDataTransferObject findById(ObjectId id) throws StationException {
        Station foundStation = this.stationRepository.findOne(id);
        if (foundStation == null) {
            throw new StationNotFound("The station is unregistered");
        }
        return entityToDto(foundStation);
    }

    @Override
    public List<StationDataTransferObject> findAll() {
        List<StationDataTransferObject> newStationList = new ArrayList<>();

        this.stationRepository.findAll().forEach(station -> newStationList.add(entityToDto(station)));

        return newStationList;
    }

    private StationDataTransferObject entityToDto(Station entity) {
        StationDataTransferObject dto = new StationDataTransferObject();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDateTime(entity.getDateTime());
        dto.setFileName(entity.getFileName());
        dto.setSensors(sensorEntityToDto(entity.getSensors()));

        return dto;
    }

    private List<SensorDataTransferObject> sensorEntityToDto(List<Sensor> sensorEntityList) {

        List<SensorDataTransferObject> newSensorList = new ArrayList<>();

        sensorEntityList.forEach(sensor -> {
            SensorDataTransferObject transferObject = new SensorDataTransferObject(sensor.getName(), sensor.getValue());
            transferObject.setId(sensor.getId());
            newSensorList.add(transferObject);
        });

        return newSensorList;
    }
}
