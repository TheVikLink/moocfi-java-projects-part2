/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author olehenrikvik
 */
public class WordInspection {

    private File file;
    private ArrayList<String> lines;

    public WordInspection(File file) throws FileNotFoundException {
        this.file = file;
        this.lines = new ArrayList<String>();
        Scanner reader = new Scanner(file, "UTF-8");
        while (reader.hasNextLine()) {
            String currentLine = reader.nextLine();
            this.lines.add(currentLine);
        }
    }

    public int wordCount() throws FileNotFoundException {
        return lines.size();
    }

    public List<String> wordsContainingZ() throws FileNotFoundException {
        List<String> wordsContainingZ = new ArrayList<String>();
        for (String line : lines) {
            if (line.contains("z")) {
                wordsContainingZ.add(line);
            }
        }
        return wordsContainingZ;
    }

    public List<String> wordsEndingInL() throws FileNotFoundException {
        List<String> wordsEndingInL = new ArrayList<String>();
        for (String line : lines) {
            if (line.endsWith("l")) {
                wordsEndingInL.add(line);
            }
        }
        return wordsEndingInL;
    }

    public List<String> palindromes() throws FileNotFoundException {
        List<String> palindromes = new ArrayList<String>();
        for (String line : lines) {
            if (isPalindrome(line)) {
                palindromes.add(line);
            }
        }
        return palindromes;
    }

    public boolean isPalindrome(String line) {
        if (line.length() % 2 == 0) {
            return line.substring(0, line.length() / 2).equals(reverse(line.substring(line.length() / 2, line.length())));
        } else {
            return line.substring(0, line.length() / 2).equals(reverse(line.substring(line.length() / 2 + 1, line.length())));
        }
    }

    public String reverse(String substring) {
        String reversed = "";
        for (int i = substring.length() - 1; i >= 0; i--) {
            reversed += String.valueOf(substring.charAt(i));
        }
        return reversed;
    }

    public List<String> wordsWhichContainAllVowels() {
        List<String> wordsWhichContainAllVowels = new ArrayList<String>();
        CharSequence allVowels = "aeiouyäö";
        Boolean containsAllVowels = true;
        for (String line : lines) {
            containsAllVowels = true;
            for (int i = 0; i < allVowels.length(); i++) {
                if (line.indexOf(allVowels.charAt(i)) == -1) {
                    containsAllVowels = false;
                    break;
                }
            }
            if (containsAllVowels) {
                wordsWhichContainAllVowels.add(line);
            }
        }
        return wordsWhichContainAllVowels;
    }
}
