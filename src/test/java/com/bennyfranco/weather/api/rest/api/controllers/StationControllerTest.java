package com.bennyfranco.weather.api.rest.api.controllers;

import com.bennyfranco.weather.api.rest.api.exceptions.APIExceptionHandler;
import com.bennyfranco.weather.api.rest.api.filters.CORSFilter;
import com.bennyfranco.weather.api.rest.dto.SensorDataTransferObject;
import com.bennyfranco.weather.api.rest.dto.StationDataTransferObject;
import com.bennyfranco.weather.api.rest.entities.Sensor;
import com.bennyfranco.weather.api.rest.entities.Station;
import com.bennyfranco.weather.api.rest.services.StationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test for the Station controller.
 *
 * @author Benny Franco
 * @version 0.0.1 29 ene 2017
 */

@RunWith(SpringRunner.class)
public class StationControllerTest {

    private StationService stationService = mock(StationService.class);
    private StationController stationController = new StationController(stationService);

    private MockMvc mockMvc;
    private static String apiURL = "http://localhost:8080/api/stations";
    private Station station;
    private List<Sensor> sensorList = new ArrayList<>();

    @Before
    public void init() {
        final StaticApplicationContext applicationContext = new StaticApplicationContext();
        applicationContext.registerSingleton("exceptionHandler", APIExceptionHandler.class);

        final WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport();
        webMvcConfigurationSupport.setApplicationContext(applicationContext);

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(stationController)
                .setHandlerExceptionResolvers(webMvcConfigurationSupport.handlerExceptionResolver())
                .addFilters(new CORSFilter())
                .build();

        Sensor barometro = new Sensor();
        barometro.setName("BarometroTest");
        barometro.setValue("100");
        sensorList.add(barometro);

        station = new Station();
        station.setId(new ObjectId("507f1f77bcf86cd799439011"));
        station.setName("JAZMIN");
        station.setDateTime(new Date());
        station.setFileName("./jazmin.txt");
        station.setSensors(sensorList);
    }

    @Test
    public void create_station_success() throws Exception {

        StationDataTransferObject stationDTO = new StationDataTransferObject();
        stationDTO.setName("JAZMIN");
        stationDTO.setDateTime(new Date());
        stationDTO.setFileName("./jazmin.txt");

        SensorDataTransferObject barometroDTO = new SensorDataTransferObject("BarometroTest", "100");
        List<SensorDataTransferObject> sensorListDTO = new ArrayList<>();
        sensorListDTO.add(barometroDTO);

        stationDTO.setSensors(sensorListDTO);

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(station);

        when(stationService.create(station)).thenReturn(stationDTO);

        mockMvc.perform(post(apiURL)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonInString))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.data.id", is(stationDTO.getId())))
                .andExpect(jsonPath("$.data.name", is(stationDTO.getName())));

        verify(stationService, times(1)).create(station);
        verifyNoMoreInteractions(stationService);
    }

    @Test
    public void update_station_success() throws Exception {

        station.setName("CAMOTE");

        StationDataTransferObject stationDTO = new StationDataTransferObject();
        stationDTO.setName("CAMOTE");
        stationDTO.setDateTime(new Date());
        stationDTO.setFileName("./jazmin.txt");

        SensorDataTransferObject barometroDTO = new SensorDataTransferObject("BarometroTest", "100");
        List<SensorDataTransferObject> sensorListDTO = new ArrayList<>();
        sensorListDTO.add(barometroDTO);

        stationDTO.setSensors(sensorListDTO);

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(station);

        when(stationService.update(station)).thenReturn(stationDTO);

        mockMvc.perform(put(apiURL)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonInString))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.data.id", is(stationDTO.getId())))
                .andExpect(jsonPath("$.data.name", is(stationDTO.getName())));

        verify(stationService, times(1)).update(station);
        verifyNoMoreInteractions(stationService);
    }

}
