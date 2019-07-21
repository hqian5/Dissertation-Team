package org.dissertation.airline.controller;

import org.dissertation.airline.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@ResponseBody
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @RequestMapping(value = "/getFlight", method = GET)
    public Object getFlightByDepartureDate(
            @RequestParam(value = "departureDate") String departureDate,
            @RequestParam(value = "airportDeparture") String airportDeparture,
            @RequestParam(value = "airportDestination") String airportDestination)
    {
        return flightService.getFlight(departureDate, airportDeparture, airportDestination);
    }

    @RequestMapping(value = "/getSeatById", method = GET)
    public Object getSeatBySeatId(
            @RequestParam(value = "flightId") int flightId,
            @RequestParam(value = "seatId") int seatId)
    {
        return flightService.getSeatById(flightId, seatId);
    }

    @RequestMapping(value = "/getAvailableSeats", method = GET)
    public Object getAvailableSeats(
            @RequestParam(value = "flightId") int flightId)
    {
        return flightService.getAvailableSeats(flightId);
    }
}
