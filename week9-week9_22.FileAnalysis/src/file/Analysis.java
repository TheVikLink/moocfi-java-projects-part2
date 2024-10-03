/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author olehenrikvik
 */
public class Analysis {

    private File file;

    public Analysis(File file) throws Exception {
        this.file = file;
    }

    public int lines() throws FileNotFoundException {
        Scanner reader = new Scanner(file, "UTF-8");
        int numberOfLines = 0;
        while (reader.hasNextLine()) {
            reader.nextLine();
            numberOfLines++;
        }
        return numberOfLines;
    }

    public int characters() throws FileNotFoundException {
        Scanner reader = new Scanner(file, "UTF-8");
        int numberOfCharacters = 0;
        while (reader.hasNextLine()) {
            String currentLine = reader.nextLine();
            numberOfCharacters += currentLine.length() + 1;
        }
        return numberOfCharacters;
        }
    }

