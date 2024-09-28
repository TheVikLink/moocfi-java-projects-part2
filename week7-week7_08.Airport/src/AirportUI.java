
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author olehenrikvik
 */
public class AirportUI {

    private Scanner reader;
    private ArrayList<Plane> planes;
    private ArrayList<Flight> flights;

    public AirportUI(Scanner reader) {
        this.reader = reader;
        this.planes = new ArrayList<Plane>();
        this.flights = new ArrayList<Flight>();
    }
    
    public void start() {
        airportPanel();
        flightService();
    }
    
    public void airportPanel() {
        welcomeAirportPanel();
        while (true) {
            chooseOperationAirportPanel();
            String input = this.reader.nextLine();
            if (input.equals("1")) {
                Plane plane = new Plane(getPlaneID(), getPlaneCapacity());
                addAirplane(plane);
            } else if (input.equals("2")) {
                Flight flight = new Flight(getPlane(), getDepartureAirportCode(), getDestinationAirportCode());
                addFlight(flight);
            } else if (input.equals("x")) {
                System.out.println("");
                break;
            }
        }
    }

    public void welcomeAirportPanel() {
        System.out.println("Airport panel\n"
                + "--------------------\n");
    }

    public void chooseOperationAirportPanel() {
        System.out.print("Choose operation:\n"
                + "[1] Add airplane\n"
                + "[2] Add flight\n"
                + "[x] Exit\n"
                + "> ");
    }

    public String getPlaneID() {
        System.out.print("Give plane ID: ");
        return this.reader.nextLine();
    }

    public int getPlaneCapacity() {
        System.out.print("Give plane capacity: ");
        return Integer.parseInt(this.reader.nextLine());
    }

    public void addAirplane(Plane plane) {
        planes.add(plane);
    }

    public Plane getPlane() {
        while (true) {
            System.out.print("Give plane ID: ");
            String planeID = this.reader.nextLine();
            for (Plane plane : this.planes) {
                if (plane.getPlaneID().equals(planeID)) {
                    return plane;
                }
            }
        }
    }

    public String getDepartureAirportCode() {
        System.out.print("Give departure airport code: ");
        return this.reader.nextLine();
    }

    public String getDestinationAirportCode() {
        System.out.print("Give destination airport code: ");
        return this.reader.nextLine();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void flightService() {
        welcomeFlightService();
        chooseOperationFlightService();
        while (true) {
            String input = this.reader.nextLine();
            if (input.equals("1")) {
                printPlanes();
                chooseActionFlightService();

            } else if (input.equals("2")) {
                printFlights();
                chooseOperationFlightService();

            } else if (input.equals("3")) {
                printPlaneInfo(getPlaneInfo());
                chooseOperationFlightService();
            } else if (input.equals("x")) {
                System.out.println("");
                break;
            }
        }
    }

    public void welcomeFlightService() {
        System.out.println("Flight service\n"
                + "------------");
    }

    public void chooseOperationFlightService() {
        System.out.println("");
        System.out.print("Choose operation:\n"
                + "[1] Print planes\n"
                + "[2] Print flights\n"
                + "[3] Print plane info\n"
                + "[x] Quit\n"
                + "> ");
    }

    public void chooseActionFlightService() {
        System.out.println("Choose action:\n"
                + "[1] Print planes\n"
                + "[2] Print flights\n"
                + "[3] Print plane info\n"
                + "[x] Quit\n"
                + "> ");
    }

    public void printPlanes() {
        for (Plane plane : planes) {
            System.out.println(plane.toString());
        }
    }

    public void printFlights() {
        for (Flight flight : flights) {
            System.out.println(flight.toString());
        }
    }

    public String getPlaneInfo() {
        System.out.println("");
        System.out.print("Give plane ID: ");
        return this.reader.nextLine();
    }

    public void printPlaneInfo(String planeID) {
        for (Plane plane : planes) {
            if (plane.getPlaneID().equals(planeID)) {
                System.out.println(plane.toString());
            }
        }
    }

}
