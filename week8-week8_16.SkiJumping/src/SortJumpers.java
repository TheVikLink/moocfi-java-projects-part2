import java.util.Comparator;

public class SortJumpers implements Comparator<Jumper> {
    @Override
    public int compare(Jumper jumper1, Jumper jumper2) {
        // Return 0 if points are the same, otherwise return based on point difference
        return Integer.compare(jumper1.getPoints(), jumper2.getPoints());
    }
}
