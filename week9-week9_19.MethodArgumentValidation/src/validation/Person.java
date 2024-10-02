package validation;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        
        if (name == null || name.isEmpty() || name.length() > 40 || 0 > age || age > 120) {
            throw new IllegalArgumentException("The name cannot be empty, be null or be longer than 40 characters");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
