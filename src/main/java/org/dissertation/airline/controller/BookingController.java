package org.dissertation.airline.controller;

import org.dissertation.airline.bean.BookingBean;
import org.dissertation.airline.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@ResponseBody
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "/getBookingById", method = GET)
    public Object getBookingById(@RequestParam(value = "bookingId") int bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    @RequestMapping(value = "/newBooking", method = POST)
    public Object newBooking(@RequestBody BookingBean booking) {
        return bookingService.newBooking(booking);
    }
}
