/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olehenrikvik
 */
public class Book implements ToBeStored {

    private String writer;
    private String name;
    private double weight;

    public Book(String writer, String title, double weight) {
        this.writer = writer;
        this.name = title;
        this.weight = weight;
    }

    public double weight() {
        return this.weight;
    }
    
    @Override
    public String toString() {
        return writer + ": " + name;
    }
    
}
