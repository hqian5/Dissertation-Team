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

    @RequestMapping(value = "/getFlightById", method = GET)
    public Object getFlightById(
            @RequestParam(value = "flightId") String flightId)
    {
        return flightService.getFlightById(flightId);
    }
}
