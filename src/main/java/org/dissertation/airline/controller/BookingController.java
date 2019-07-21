package org.dissertation.airline.controller;

import org.dissertation.airline.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@ResponseBody
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "/listFlights", method = GET)
    public Object listFlights(){
        return bookingService.listFlights();
    }

    @RequestMapping(value="/getBookingByPassengerId", method = GET)
    public Object getBookingByPassengerId(@RequestParam(value = "passengerId") int passengerId) {
        return bookingService.getBookingByPassengerId(passengerId);
    }
}
