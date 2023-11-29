package _12_GenericBox;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Box box = new Box();

        for (int i = 0; i < n; i++) {
            String s = scan.nextLine();
            try {
                Double element = Double.parseDouble(s);
                box.add(element);
            } catch (NumberFormatException e) {
                box.add(s);
            }
        }

        /*
        int[] swapData = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        box.swap(swapData[0], swapData[1]);
        */

        Double element =  Double.parseDouble(scan.nextLine());

        System.out.println(box.countGreaterThan(element));

    }
}
