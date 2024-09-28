
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
public class Suitcase {

    private int maxWeight;
    private ArrayList<Thing> things;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
    }

    public void addThing(Thing thing) {
        if (totalWeight() + thing.getWeight() <= this.maxWeight) {
            this.things.add(thing);
        }
    }

    @Override
    public String toString() {
        if (this.things.size() == 0) {
            return "empty (" + totalWeight() + " kg)";
        } else if (this.things.size() == 1) {
            return this.things.size() + " thing (" + totalWeight() + " kg)";
        }
        return this.things.size() + " things (" + totalWeight() + " kg)";
    }

    public void printThings() {
        System.out.println("Your suitcase contains the following things:");
        for (Thing thing : this.things) {
            System.out.println(thing.toString());
        }
    }

    public int totalWeight() {
        int totalWeight = 0;
        for (Thing thing : things) {
            totalWeight += thing.getWeight();
        }
        return totalWeight;
    }
    
    public Thing heaviestThing() {
        int heaviestWeight = 0;
        int indexHeaviestThing = 0;
        if (this.things.size() > 0) {
            for (int i = 0; i < this.things.size(); i++) {
                if (this.things.get(i).getWeight() > heaviestWeight) {
                    heaviestWeight = this.things.get(i).getWeight();
                    indexHeaviestThing = i;
                }
            }
            return this.things.get(indexHeaviestThing);
        } else {
            return null;
        }
    }
}
