package org.dissertation.airline.service;

import org.dissertation.airline.mapper.FlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FlightService {
    @Autowired
    private FlightMapper flightMapper;

    public Object getFlightById(String flightid) {
        return flightMapper.getFlightById(flightid);
    }
}
