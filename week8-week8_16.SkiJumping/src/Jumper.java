
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olehenrikvik
 */
public class Jumper {
    private String name;
    private List<Integer> jumpLengths;
    private int points;

    public Jumper(String name) {
        this.name = name;
        this.jumpLengths = new ArrayList<Integer>();
        this.points = 0;
    }

    @Override
    public String toString() {
        return name + " (" + points + " points)";
    }

    public int getPoints() {
        return points;
    }
    
    public void addJumpLength(int jumpLength) {
        jumpLengths.add(jumpLength);
    }
    
    public void addPoints(int jumpLength, int judgePoints) {
        points += jumpLength + judgePoints;
    }

    public String getName() {
        return name;
    }
    
    public String printJumpLengths() {
        String returnString = "";
        for (Integer jumpLength : jumpLengths) {
            returnString += ", " + jumpLength + "m";
        }
        return returnString.substring(2);
    }
    
    
}
