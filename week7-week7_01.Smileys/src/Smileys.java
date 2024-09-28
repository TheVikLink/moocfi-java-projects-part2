
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");
    }
    
    private static void printWithSmileys(String characterString) {
        int lengthCharacterString = characterString.length();
        int lengthSmileySpace = 0;
        boolean even = true;
        if (lengthCharacterString % 2 == 0) {
            lengthSmileySpace = lengthCharacterString + 2;
        } else {
            lengthSmileySpace = lengthCharacterString + 3;
            even = false;
        }
        for (int i = 0; i < lengthSmileySpace + 4; i+= 2) {
            System.out.print(":)");
        }
        System.out.println("");
        System.out.print(":)");
        if (even) {
            System.out.print(" " + characterString + " ");
            System.out.print(":)");
            System.out.println("");
        }
        else {
            System.out.print(" " + characterString + "  ");
            System.out.print(":)");
            System.out.println("");
        }        
        for (int i = 0; i < lengthSmileySpace + 4; i+= 2) {
            System.out.print(":)");
        }
        System.out.println("");
    }

}
