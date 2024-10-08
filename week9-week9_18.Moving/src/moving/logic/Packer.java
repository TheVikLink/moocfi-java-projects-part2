/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.logic;

import java.util.ArrayList;
import java.util.List;
import moving.domain.Box;
import moving.domain.Thing;

/**
 *
 * @author olehenrikvik
 */
public class Packer {

    private int boxesVolume;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }

    public List<Box> packThings(List<Thing> things) {
        List<Box> boxes = new ArrayList<Box>();
        Box box = new Box(boxesVolume);
        int index = 0;
        while (index < things.size()) {
            if (box.addThing(things.get(index))) {
                System.out.println("Added " + things.get(index));
            } else {
                System.out.println("Box is full, at " + box.getVolume());
                boxes.add(box);
                box = new Box(boxesVolume);
                box.addThing(things.get(index));
                System.out.println("Added " + things.get(index) + " ");
            }
            index++;
        }
        boxes.add(box);
        return boxes;
    }
}
