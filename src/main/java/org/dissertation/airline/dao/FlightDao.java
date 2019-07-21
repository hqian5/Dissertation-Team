package org.dissertation.airline.dao;

import org.dissertation.airline.bean.FlightBean;
import org.dissertation.airline.common.CommonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightDao {
    @Autowired
    private JdbcTemplate template;

    private RowMapper<FlightBean> mapper = new CommonRowMapper(FlightBean.class);

    public List<FlightBean> listFlights() {
        return template.query(
                "select flight_id, name, airport_departure, " +
                "airport_destination, departure_start_time, " +
                "flight_duration_minute, price, description  from flight",
                mapper);
    }
}
