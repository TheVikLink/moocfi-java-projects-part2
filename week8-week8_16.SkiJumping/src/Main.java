
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be very useful.
                Scanner reader = new Scanner(System.in);
        //Plane plane = new Plane();
        //Flight flight = new Flight();
        String input = ("1" + "HA-LOL" + "42"
                + "1" + "G-OWAC" + "101"
                + "2" + "HEL" + "BAL"
                + "2" + "JFK" + "BAL"
                + "2" + "BAL" + "HEL"
                + "x" 
                + "1" 
                + "2"
                + "3"
                + "G-OWAC"
                + "x");
        SkiJumpingUI uiSkiJumping = new SkiJumpingUI(reader);
        uiSkiJumping.start();
    }
}
