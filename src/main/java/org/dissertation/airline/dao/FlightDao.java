package org.dissertation.airline.dao;

import com.google.common.base.Throwables;
import org.dissertation.airline.bean.FlightBean;
import org.dissertation.airline.bean.SeatBean;
import org.dissertation.airline.common.CommonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

@Component
public class FlightDao {
    @Autowired
    private JdbcTemplate template;
    private RowMapper<SeatBean> seatMapper = new CommonRowMapper(SeatBean.class);
    private RowMapper<FlightBean> mapper = new CommonRowMapper(FlightBean.class);

    public FlightDao() {
        parser.setTimeZone(TimeZone.getTimeZone("UTC"));
    }


    private SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);

    public List<FlightBean> getFlight(String departureDate, String airportDeparture, String airportDestination) {
        try {
            java.util.Date dt = parser.parse(departureDate);
            return template.query(
                    "select flight_id, name, airport_departure, " +
                            "airport_destination, departure_date, departure_time, " +
                            "destination_date, destination_time, price, description  from flight" +
                            " where departure_date = ? " +
                            "and airport_departure = ? " +
                            "and airport_destination = ?",
                    new Object[]{new java.sql.Date(dt.getTime()),
                            airportDeparture, airportDestination},
                    mapper);
        } catch (ParseException e) {
            Throwables.propagate(e);
        }
        return null;

    }

    public List<SeatBean> getSeatById(int flightId, int seatId) {
        return template.query("select seat_id, flight_id, location_x, location_y,  level, booked " +
                "from seat where flight_id = ? and seat_id = ?",
                new Object[]{flightId, seatId},
                seatMapper);
    }

    public void bookSeat(Integer flightId, Integer seatId) {
        template.update("update seat set booked = 1 where flight_id = ? and seat_id = ?",
                new Object[] {flightId, seatId});
    }

    public List<SeatBean> getAvailableSeats(int flightId) {
        return template.query("select * from seat where flight_id = ? and booked = ?",
                new Object[]{flightId, 0},
                seatMapper);
    }

    public Object getFlightById(String flightId) {
        return template.query(
                "select flight_id, name, airport_departure, " +
                        "airport_destination, departure_date, departure_time, " +
                        "destination_date, destination_time, price, description  from flight" +
                        " where flight_id = ? ",
                new Object[]{flightId},
                mapper);
    }
}
