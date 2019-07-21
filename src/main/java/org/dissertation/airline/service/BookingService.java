package org.dissertation.airline.service;

import com.google.common.collect.ImmutableMap;
import org.dissertation.airline.bean.BookingBean;
import org.dissertation.airline.dao.BookingDao;
import org.dissertation.airline.dao.FlightDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class BookingService {
    @Autowired
    private BookingDao bookingDao;

    @Autowired
    private FlightDao flightDao;


    public List<BookingBean> getBookingByPassengerId(int passengerId) {
        checkNotNull(passengerId);
        return bookingDao.getBookingByPassengerId(passengerId);
    }

    @Transactional
    public Map<String, Integer> newBooking(BookingBean booking) {
        checkNotNull(booking);
        checkNotNull(booking.getFlightId());
        checkNotNull(booking.getPassengerId());
        checkNotNull(booking.getSeatId());
        Map<String, Integer> returnVal = ImmutableMap.of("bookingId", bookingDao.addBooking(booking));
        flightDao.bookSeat(booking.getFlightId(), booking.getSeatId());
        return returnVal;
    }

    public List<BookingBean> getBookingById(int bookingId) {
        return bookingDao.getBookingById(bookingId);
    }
}
