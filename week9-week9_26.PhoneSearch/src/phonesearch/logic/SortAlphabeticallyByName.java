/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonesearch.logic;

import java.util.Comparator;

/**
 *
 * @author olehenrikvik
 */

//The purpose of this class is to be created as an instance to be used in Collections.sort(),
//so that a list of persons is sorted alphabetically.
public class SortAlphabeticallyByName implements Comparator<Person> {


    @Override
    public int compare(Person person1, Person person2) {
        return person1.getName().compareToIgnoreCase(person2.getName());
    }
    
    
}
