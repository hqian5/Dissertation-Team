package org.dissertation.airline.mapper;

import org.dissertation.airline.bean.FlightBean;
import org.dissertation.airline.bean.SeatBean;

import java.util.List;

public interface FlightMapper {
    List<FlightBean> getFlight(String departureDate, String airportDeparture, String airportDestination);
    List<SeatBean> getSeatById(int flightId, int seatId);
    void bookSeat(Integer flightId, Integer seatId);
    List<SeatBean> getAvailableSeats(int flightId);
    Object getFlightById(String flightId);
}
