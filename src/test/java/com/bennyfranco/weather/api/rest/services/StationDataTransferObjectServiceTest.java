package com.bennyfranco.weather.api.rest.services;

import com.bennyfranco.weather.api.rest.dto.StationDataTransferObject;
import com.bennyfranco.weather.api.rest.entities.Sensor;
import com.bennyfranco.weather.api.rest.entities.Station;
import com.bennyfranco.weather.api.rest.repositories.StationRepository;
import com.bennyfranco.weather.api.rest.services.exceptions.SensorsNotFoundException;
import com.bennyfranco.weather.api.rest.services.exceptions.StationException;
import com.bennyfranco.weather.api.rest.services.impl.StationServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Testing class of StationDataTransferObject Service.
 *
 * @author Benny Franco
 * @version 0.0.1 29 ene 2017
 */

@RunWith(SpringRunner.class)
public class StationDataTransferObjectServiceTest {

    private StationRepository stationRepository = mock(StationRepository.class);
    private StationService stationService = new StationServiceImpl(stationRepository);

    @Test
    public void create_station_success() throws StationException {
        Station station = new Station();
        station.setId("01");
        station.setName("JAZMIN");
        station.setDateTime(new Date());
        station.setFileName("./jazmin.txt");

        Sensor barometro = new Sensor("01","BarometroTest","100");
        List<Sensor> sensorList = new ArrayList<>();
        sensorList.add(barometro);

        station.setSensors(sensorList);

        when(stationRepository.save(station)).thenReturn(station);

        StationDataTransferObject dtoStationDataTransferObject = stationService.create(station);

        Assert.assertTrue(station.getId().equals(dtoStationDataTransferObject.getId()));
    }

    @Test(expected = SensorsNotFoundException.class)
    public void create_station_fail_when_sensors_are_null() throws StationException {
        Station station = new Station();
        station.setId("01");
        station.setName("JAZMIN");
        station.setDateTime(new Date());
        station.setFileName("./jazmin.txt");

        stationService.create(station);
    }
}
