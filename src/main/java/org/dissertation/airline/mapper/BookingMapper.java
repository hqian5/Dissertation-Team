package org.dissertation.airline.mapper;

import org.dissertation.airline.bean.BookingBean;

import java.util.List;

public interface BookingMapper {
    int addBooking(BookingBean booking);
    List<BookingBean> getBookingById(int bookingId);
}
