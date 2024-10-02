package moving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import moving.domain.Box;
import moving.domain.Item;
import moving.domain.Thing;
import moving.logic.Packer;

public class Main {

    public static void main(String[] args) {
        // test your program here
        // the things we want to pack
        List<Thing> things = new ArrayList<Thing>();
        things.add(new Item("Stone", 5));
        things.add(new Item("Stone", 5));
        things.add(new Item("Stone", 4));
        things.add(new Item("Stone", 1));
        things.add(new Item("Stone", 5));
        Packer packer = new Packer(20);
        packer.packThings(things);
        

    }
}
