/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

/**
 *
 * @author olehenrikvik
 */
public class Item implements Thing, Comparable<Item> {
    private int volume;
    private String name;

    public Item(String name, int volume) {
        this.volume = volume;
        this.name = name;
    }
    
    
    public int getVolume() {
        return volume;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + volume + " dm^3)";
    }

    @Override
    public int compareTo(Item item) {
        return getVolume() - item.getVolume();
    }
    
    
}
