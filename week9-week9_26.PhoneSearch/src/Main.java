
import java.util.Scanner;
import phonesearch.logic.Persons;
import phonesearch.logic.PhoneSearchUI;


public class Main {

    public static void main(String[] args) {
        // Start your program here
        // ATTENTION: In your program, you can create only one instance of class Scanner!
        // Write your main program here. Implementing your own classes will be very useful.
        Scanner reader = new Scanner(System.in);
        Persons persons = new Persons();

        PhoneSearchUI phoneSearchUI = new PhoneSearchUI(reader, persons);
        phoneSearchUI.start();
    }
}
