
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
public class Box implements ToBeStored {
    private double maxWeight;
    private ArrayList<ToBeStored> box;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.box = new ArrayList<ToBeStored>();
    }
    
    public void add(ToBeStored item) {
        if (weight() + item.weight() <= maxWeight) {
            this.box.add(item);
        }
    }

    @Override
    public String toString() {
        return "Box: " + box.size() + " things, total weight " + weight() + " kg";
    }

    public double weight() {
        double weight = 0;
        for (ToBeStored item : box) {
            weight += item.weight();
        }
        return weight;
    }

    
    
}
