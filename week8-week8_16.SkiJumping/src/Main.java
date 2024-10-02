
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be very useful.
                Scanner reader = new Scanner(System.in);
        //Plane plane = new Plane();
        //Flight flight = new Flight();
        SkiJumpingUI uiSkiJumping = new SkiJumpingUI(reader);
        uiSkiJumping.start();
    }
}
