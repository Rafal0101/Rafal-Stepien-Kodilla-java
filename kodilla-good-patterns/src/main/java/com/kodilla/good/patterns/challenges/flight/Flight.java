package com.kodilla.good.patterns.challenges.flight;

import java.time.LocalTime;

public class Flight {
    private String departurePort;
    private String arrivalPort;
    private String medialPort;
    private LocalTime departueTime;

    public Flight(String departurePort, String arrivalPort, String medialPort, LocalTime departueTime) {
        this.departurePort = departurePort;
        this.arrivalPort = arrivalPort;
        this.medialPort = medialPort;
        this.departueTime = departueTime;
    }

    public Flight(String departurePort, String arrivalPort, LocalTime departueTime) {
        this.departurePort = departurePort;
        this.arrivalPort = arrivalPort;
        this.departueTime = departueTime;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public String getArrivalPort() {
        return arrivalPort;
    }

    public String getMedialPort() {
        return medialPort;
    }

    public LocalTime getDepartueTime() {
        return departueTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!departurePort.equals(flight.departurePort)) return false;
        if (!arrivalPort.equals(flight.arrivalPort)) return false;
        if (medialPort != null ? !medialPort.equals(flight.medialPort) : flight.medialPort != null) return false;
        return departueTime.equals(flight.departueTime);
    }

    @Override
    public int hashCode() {
        int result = departurePort.hashCode();
        result = 31 * result + arrivalPort.hashCode();
        result = 31 * result + (medialPort != null ? medialPort.hashCode() : 0);
        result = 31 * result + departueTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departurePort='" + departurePort + '\'' +
                ", arrivalPort='" + arrivalPort + '\'' +
                ", medialPort='" + medialPort + '\'' +
                ", departueTime=" + departueTime +
                '}';
    }
}
