
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author olehenrikvik
 */
public class TextUserInterface {

    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        System.out.println("Statements:");
        System.out.println("  add - adds a word pair to the dictionary");
        System.out.println("  translate - asks a word and prints its translation");
        System.out.println("  quit - quit the text user interface");
        System.out.println("");
        
        while (true) {
            System.out.println("");
            System.out.print("Statement: ");
            String input = this.reader.nextLine();
            if (input.equals("quit")) {
                System.out.print("Cheers!");
                break;
            } else if (input.equals("add")) {
                System.out.print("In Finnish: ");
                String word = this.reader.nextLine();
                System.out.print("Translation: ");
                String translation = this.reader.nextLine();
                this.dictionary.add(word, translation);

            } else if (input.equals("translate")) {
                System.out.print("Give a word: ");
                String word = this.reader.nextLine();
                System.out.print("Translation: ");
                System.out.print(this.dictionary.translate(word));
            } else {
                System.out.println("Unknown statement");

            }
        }
    }
}
