package org.dissertation.airline.dao;

import org.dissertation.airline.bean.BookingBean;
import org.dissertation.airline.common.CommonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingDao {

    @Autowired
    private JdbcTemplate template;

    private RowMapper<BookingBean> mapper = new CommonRowMapper(BookingBean.class);

    public List<BookingBean> getBookingByPassengerId(int passengerId) {
        return template.query("select booking_id, passenger_id, flight_id, seat_id, " +
                "payment_id, discount_id, departure_date, create_time, update_time " +
                "from booking where passenger_id = ?",
                new Object[]{passengerId},
                mapper);
    }
}
