package org.dissertation.airline.service;

import org.dissertation.airline.bean.BookingBean;
import org.dissertation.airline.bean.FlightBean;
import org.dissertation.airline.dao.BookingDao;
import org.dissertation.airline.dao.FlightDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private FlightDao flightDao;

    @Autowired
    private BookingDao bookingDao;

    public List<FlightBean> listFlights() {
        return flightDao.listFlights();
    }

    public List<BookingBean> getBookingByPassengerId(int passengerId) {
        return bookingDao.getBookingByPassengerId(passengerId);
    }
}
