
import java.util.ArrayList;
import java.util.Collections;
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
public class Hand implements Comparable<Hand> {

    private List<Card> hand;

    public Hand() {
        this.hand = new ArrayList<Card>();
    }

    public void add(Card card) {
        this.hand.add(card);
    }

    public void print() {
        for (Card card : hand) {
            System.out.println(card);
        }
    }

    public void sort() {
        Collections.sort(hand);
    }

    @Override
    public int compareTo(Hand hand) {
        int sumOfCardsThis = 0;
        for (Card card : this.hand) {
            sumOfCardsThis += card.getValue();
        }
        int sumOfCardsOther = 0;
        for (Card card : hand.hand) {
            sumOfCardsOther += card.getValue();
        }
        return sumOfCardsThis - sumOfCardsOther;
    }

    public void sortAgainstSuit() {
        SortAgainstSuitAndValue suitSorter = new SortAgainstSuitAndValue();
        Collections.sort(this.hand, suitSorter);
    }

}
