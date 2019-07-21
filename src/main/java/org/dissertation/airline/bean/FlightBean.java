package org.dissertation.airline.bean;

public class FlightBean {
    private int FlightId;
    private String name;
    private int airportDeparture;
    private int airportDestination;
    private String departureStartTime;
    private int flightDurationMinute;
    private String description;

    public int getFlightId() {
        return FlightId;
    }

    public void setFlightId(int flightId) {
        FlightId = flightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAirportDeparture() {
        return airportDeparture;
    }

    public void setAirportDeparture(int airportDeparture) {
        this.airportDeparture = airportDeparture;
    }

    public int getAirportDestination() {
        return airportDestination;
    }

    public void setAirportDestination(int airportDestination) {
        this.airportDestination = airportDestination;
    }

    public String getDepartureStartTime() {
        return departureStartTime;
    }

    public void setDepartureStartTime(String departureStartTime) {
        this.departureStartTime = departureStartTime;
    }

    public int getFlightDurationMinute() {
        return flightDurationMinute;
    }

    public void setFlightDurationMinute(int flightDurationMinute) {
        this.flightDurationMinute = flightDurationMinute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
