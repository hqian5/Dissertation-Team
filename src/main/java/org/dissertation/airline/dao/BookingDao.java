package org.dissertation.airline.dao;

import org.dissertation.airline.bean.BookingBean;
import org.dissertation.airline.common.CommonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;

@Component
public class BookingDao {

    @Autowired
    private JdbcTemplate template;

    private RowMapper<BookingBean> mapper = new CommonRowMapper(BookingBean.class);

    public List<BookingBean> getBookingByPassengerId(int passengerId) {
        return template.query(
                "select booking_id, passenger_id, flight_id, seat_id, " +
                        "payment_id, discount_id, create_time, update_time " +
                        "from booking where passenger_id = ?",
                new Object[]{passengerId},
                mapper);
    }

    public int addBooking(BookingBean booking) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = conn -> {
            PreparedStatement ps =
                    conn.prepareStatement("INSERT INTO booking(passenger_id, flight_id, " +
                                    "seat_id, payment_id, discount_id) VALUES (?, ?, ?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, booking.getPassengerId());
            ps.setInt(2, booking.getFlightId());
            ps.setInt(3, booking.getSeatId());
            if (booking.getPaymentId() != null) {
                ps.setInt(4, booking.getPaymentId());
            } else {
                ps.setNull(4, Types.INTEGER);
            }

            if (booking.getDiscountId() != null) {
                ps.setInt(5, booking.getDiscountId());
            } else {
                ps.setNull(5, Types.INTEGER);
            }
            return ps;
        };

        template.update(preparedStatementCreator, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public List<BookingBean> getBookingById(int bookingId) {
        return template.query(
        "select booking_id, passenger_id, flight_id, seat_id, " +
                "payment_id, discount_id, create_time, update_time " +
                "from booking where booking_id = ?",
                new Object[]{bookingId},
                mapper);
    }
}
