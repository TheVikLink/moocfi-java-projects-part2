
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
public class Container {
    private int maximumWeightLimit;
    private ArrayList<Suitcase> container;

    public Container(int maximumWeightLimit) {
        this.maximumWeightLimit = maximumWeightLimit;
        this.container = new ArrayList<Suitcase>();
    }
    
    public void addSuitcase(Suitcase suitcase) {
        if (suitcase.totalWeight() + totalWeight() <= this.maximumWeightLimit) {
            this.container.add(suitcase);
        }
    }
    
    public String toString() {
        return this.container.size() + " suitcases (" + totalWeight() + " kg)";
    }
    
    public int totalWeight() {
        int totalWeight = 0;
        for (Suitcase suitcase : this.container) {
            totalWeight += suitcase.totalWeight();
        }
        return totalWeight;
    }
    
    public void printThings() {
        System.out.println("There are the following things in the container suitcases:");
        for (Suitcase suitcase : this.container) {
            suitcase.printThings();
        }
    }
}
