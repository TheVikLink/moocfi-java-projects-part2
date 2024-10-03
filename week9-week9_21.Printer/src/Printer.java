
import java.io.File;
import java.io.FileNotFoundException;
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
public class Printer {

    private String filename;

    public Printer(String filename) throws Exception {
        this.filename = filename;
    }

    public void printLinesWhichContain(String word) throws FileNotFoundException {
        File f = new File(filename);
        Scanner reader = new Scanner(f, "UTF-8");
        while (reader.hasNextLine()) {
            String currentLine = reader.nextLine();

            if (currentLine.contains(word)) {
                System.out.println(currentLine);
            }
        }
    }
}
