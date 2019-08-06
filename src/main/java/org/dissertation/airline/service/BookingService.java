package org.dissertation.airline.service;

import com.google.common.collect.ImmutableMap;
import org.dissertation.airline.bean.BookingBean;
import org.dissertation.airline.mapper.BookingMapper;
import org.dissertation.airline.mapper.FlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class BookingService {
    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private FlightMapper flightMapper;


    @Transactional
    public Map<String, Integer> newBooking(BookingBean booking) {
        checkNotNull(booking);
        checkNotNull(booking.getFlightId());
        checkNotNull(booking.getPassengerId());
        checkNotNull(booking.getSeatNumber());
        bookingMapper.addBooking(booking);
        int bookingId = booking.getBookingId();
        Map<String, Integer> returnVal = ImmutableMap.of("bookingId", bookingId);
        flightMapper.bookSeat(booking.getFlightId(), booking.getSeatNumber());
        return returnVal;
    }

    public List<BookingBean> getBookingById(int bookingId) {
        return bookingMapper.getBookingById(bookingId);
    }
}
