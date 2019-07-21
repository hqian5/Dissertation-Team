package org.dissertation.airline.bean;

public class FlightBean {
    private Integer FlightId;
    private String name;
    private Integer airportDeparture;
    private Integer airportDestination;
    private String departureDate;
    private String departureTime;
    private String destinationDate;
    private String destinationTime;
    private String description;

    public Integer getFlightId() {
        return FlightId;
    }

    public void setFlightId(Integer flightId) {
        FlightId = flightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAirportDeparture() {
        return airportDeparture;
    }

    public void setAirportDeparture(Integer airportDeparture) {
        this.airportDeparture = airportDeparture;
    }

    public Integer getAirportDestination() {
        return airportDestination;
    }

    public void setAirportDestination(Integer airportDestination) {
        this.airportDestination = airportDestination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestinationDate() {
        return destinationDate;
    }

    public void setDestinationDate(String destinationDate) {
        this.destinationDate = destinationDate;
    }

    public String getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(String destinationTime) {
        this.destinationTime = destinationTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
