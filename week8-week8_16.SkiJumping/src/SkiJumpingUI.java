
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author olehenrikvik
 */
public class SkiJumpingUI {

    private Scanner reader;
    private ArrayList<Jumper> jumpers;

    public SkiJumpingUI(Scanner reader) {
        this.reader = reader;
        this.jumpers = new ArrayList<Jumper>();
    }

    public void start() {
        welcomeskiJumpingPanel();
        addJumpers();
        int round = 1;
        while (jumpOrQuit()) {
            newRound(round);
            round++;
        }
        exitPanel();
    }

    public void newRound(int round) {
        printRoundNumberAndJumpingOrder(round);
        printRoundResults(round);
    }

    public void printRoundNumberAndJumpingOrder(int round) {
        sortJumpers();
        System.out.print("Round " + round + "\n"
                + "\n"
                + "Jumping order:\n");
        for (Jumper jumper : jumpers) {
            System.out.print("  " + (jumpers.indexOf(jumper) + 1) + ". ");
            System.out.print(jumper.toString() + "\n");

        }
        System.out.print("\nResults of round " + round + "\n");
    }

    public void updateJumper(Jumper jumper, int jumpLength, ArrayList<Integer> judgeVotes) {
        jumper.addJumpLength(jumpLength);
        jumper.addPoints(jumpLength, calculateJudgePoints(judgeVotes));
    }

    public void printJumperResults(Jumper jumper, int jumpLength, ArrayList<Integer> judgeVotes) {
        System.out.println("  "
                + jumper.getName()
                + "\n"
                + "    length: "
                + jumpLength
                + "\n"
                + "    judge votes: "
                + judgeVotes);
    }

    public void printRoundResults(int round) {

        for (Jumper jumper : jumpers) {
            int jumpLength = calculateJumpLength();
            ArrayList judgeVotes = calculateJudgeVotes();
            updateJumper(jumper, jumpLength, judgeVotes);
            printJumperResults(jumper, jumpLength, judgeVotes);
        }

    }

    public void printExitStatement() {
        System.out.println("\nThanks!\n"
                + "\n"
                + "Tournament results:\n"
                + "Position    Name");
    }

    public void printTournamentResults() {
        sortJumpers();
        Collections.reverse(jumpers);
        for (Jumper jumper : jumpers) {
            System.out.print(jumpers.indexOf(jumper) + 1);
            System.out.print("           "
                    + jumper.getName()
                    + " ("
                    + jumper.getPoints()
                    + " points)\n"
                    + "            jump lengths: "
                    + jumper.printJumpLengths()
                    + "\n");
        }
    }

    public void welcomeskiJumpingPanel() {
        System.out.println("Kumpula ski jumping week\n"
                + "\n"
                + "Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
    }

    public void exitPanel() {
        printExitStatement();
        printTournamentResults();
    }

    public boolean jumpOrQuit() {
        System.out.print("\nWrite \"jump\" to jump; otherwise you quit: ");
        if (this.reader.nextLine().equalsIgnoreCase("jump")) {
            System.out.println("");
            return true;
        }
        return false;
    }

    public void addJumper(Jumper jumper) {
        jumpers.add(jumper);
    }

    public int calculateJumpLength() {
        return ThreadLocalRandom.current().nextInt(60, 121);
    }

    public ArrayList calculateJudgeVotes() {
        ArrayList<Integer> judgeVotes = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            judgeVotes.add(ThreadLocalRandom.current().nextInt(10, 21));
        }
        return judgeVotes;
    }

    public int calculateJudgePoints(ArrayList<Integer> judgeVotes) {
        Collections.sort(judgeVotes);
        int judgePoints = 0;
        for (Integer vote : judgeVotes.subList(1, judgeVotes.size() - 1)) {
            judgePoints += vote;
        }
        return judgePoints;
    }

    public void sortJumpers() {
        SortJumpers sortJumpers = new SortJumpers();
        Collections.sort(this.jumpers, sortJumpers);
    }

    public void addJumpers() {
        while (true) {
            System.out.print("  Participant name: ");
            String input = this.reader.nextLine();
            if (!input.isEmpty()) {
                Jumper jumper = new Jumper(input);
                addJumper(jumper);
            } else {
                System.out.println("");
                System.out.println("The tournament begins!");
                break;
            }
        }
    }

}
