
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olehenrikvik
 */
public class Calculator {
    
    private Reader reader;
    private int calculations;

    public Calculator() {
        this.reader = new Reader();
        this.calculations = calculations;
    }
      
    
    public void start() {
        
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
            } else if (command.equals("product")) {
                product();
            }
        }
        
        statistics();

        }
        
        private ArrayList values() {
            ArrayList values = new ArrayList<Integer>();
            System.out.print("value1: ");
            int value1 = Integer.parseInt(reader.readString());
            System.out.print("value2: ");
            int value2 = Integer.parseInt(reader.readString());
            values.add(value1);
            values.add(value2);
            return values;
        }
        private void sum() {
            ArrayList<Integer> values = values();
            System.out.println("sum of the values " + (values.get(0) + values.get(1)));
            System.out.println("");
            calculations++;
        }
        
        private void difference() {
            ArrayList<Integer> values = values();
            System.out.println("difference of the values " + (values.get(0) - values.get(1)));
            System.out.println("");
            calculations++;
        }
        
        private void product() {
            ArrayList<Integer> values = values();
            System.out.println("product of the values " + (values.get(0) * values.get(1)));
            System.out.println("");
            calculations++;
        }
        
        private void statistics() {
            System.out.println("Calculations done " + this.calculations);
        }
}
