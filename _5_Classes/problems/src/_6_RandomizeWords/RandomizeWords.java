package _6_RandomizeWords;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            Random random = new Random();
            int index = random.nextInt(i, input.length);
            System.out.println(input[index]);
        }
    }
}
