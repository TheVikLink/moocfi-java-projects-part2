/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olehenrikvik
 */
public class Flight {
    private Plane plane;
    private String departureAirport;
    private String destinationAirport;

    public Flight(Plane planeID, String departureAirport, String destinationAirport) {
        this.plane = planeID;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
    }

    @Override
    public String toString() {
        return plane.toString() + " (" + departureAirport + "-" + destinationAirport + ")";
    }
}
