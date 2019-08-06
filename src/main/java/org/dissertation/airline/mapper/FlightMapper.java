package org.dissertation.airline.mapper;

public interface FlightMapper {
    Object getFlightById(String flightid);

    void bookSeat(Integer flightId, Integer seatNumber);
}
