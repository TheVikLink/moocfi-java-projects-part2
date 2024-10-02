/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

import java.util.ArrayList;

/**
 *
 * @author olehenrikvik
 */
public class Box implements Thing {
    private int maximumCapacity;
    private ArrayList<Thing> box;

    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.box = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing) {
        if (this.getVolume() + thing.getVolume() <= maximumCapacity) {
            box.add(thing);
            return true;
        }
        return false;
    }

    @Override
    public int getVolume() {
        int volume = 0;
        for (Thing thing : box) {
            volume += thing.getVolume();
        }
        return volume;
    }

    public void printItems() {
        for (Thing thing : box) {
            System.out.println(thing);
        }
    }
    
}
