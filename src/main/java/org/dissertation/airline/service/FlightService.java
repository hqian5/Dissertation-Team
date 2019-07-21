package org.dissertation.airline.service;

import org.dissertation.airline.bean.FlightBean;
import org.dissertation.airline.dao.FlightDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class FlightService {
    @Autowired
    private FlightDao flightDao;

    public List<FlightBean> getFlight(String departureDate, String airportDeparture, String airportDestination) {
        checkNotNull(departureDate);
        checkNotNull(airportDeparture);
        checkNotNull(airportDestination);
        return flightDao.getFlight(departureDate, airportDeparture, airportDestination);
    }


    public Object getSeatById(int flightId, int seatId) {
        return flightDao.getSeatById(flightId, seatId);
    }

    public Object getAvailableSeats(int flightId) {
        return flightDao.getAvailableSeats(flightId);
    }

    public Object getFlightById(String flightId) {
        return flightDao.getFlightById(flightId);
    }
}
