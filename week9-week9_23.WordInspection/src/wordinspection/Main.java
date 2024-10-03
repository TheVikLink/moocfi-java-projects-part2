package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // test your code here

        File file = new File("src/shortList.txt");
        WordInspection test = new WordInspection(file);
        System.out.println("Palindromes: " + test.palindromes());
        System.out.println("Word count: " + test.wordCount());
        System.out.println("Words ending in l: " + test.wordsEndingInL());
        System.out.println("Words containing z: " + test.wordsContainingZ());
        System.out.println("Words which contain all vowels: " + test.wordsWhichContainAllVowels());
        // all words are in file src/wordList.txt

    }
}
