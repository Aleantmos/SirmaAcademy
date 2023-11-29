package _7_Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        String line = scan.nextLine();
        while (!line.equals("end")) {
            String[] tokens = line.split(" ");

            Student student = new Student(tokens[0], tokens[1], Integer.parseInt(tokens[2]), tokens[3]);
            students.add(student);
            line = scan.nextLine();
        }

        String town = scan.nextLine();

        students.stream()
                .filter(s -> s.getHometown().equals(town))
                .forEach(s -> System.out.println(s.toString()));
    }
}
