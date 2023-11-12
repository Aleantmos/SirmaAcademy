package utils;

import java.util.Scanner;

public class Util {

    public static Scanner scan() {
        return new Scanner(System.in);
    }

    public static String employeeFilePath() {
        return "src/resources/employees";
    }
}
