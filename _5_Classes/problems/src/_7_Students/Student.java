package _7_Students;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String hometown;

    public Student(String firstName, String lastName, int age, String hometown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hometown = hometown;
    }

    public String getHometown() {
        return hometown;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old", this.firstName, this.lastName, this.age);
    }
}
