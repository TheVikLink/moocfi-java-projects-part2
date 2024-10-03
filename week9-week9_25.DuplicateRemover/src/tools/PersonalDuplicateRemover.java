/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author olehenrikvik
 */
public class PersonalDuplicateRemover implements DuplicateRemover {

    private List<String> characterStrings;

    public PersonalDuplicateRemover() {
        this.characterStrings = new LinkedList<String>();
    }

    @Override
    public void add(String characterString) {
        characterStrings.add(characterString);
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return characterStrings.size() - getUniqueCharacterStrings().size();
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        Set<String> uniqueCharacterStrings = new HashSet<String>(characterStrings);
        return uniqueCharacterStrings;
    }

    @Override
    public void empty() {
        characterStrings.clear();
    }

}
