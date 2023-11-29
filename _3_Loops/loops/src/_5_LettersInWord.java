import java.util.Scanner;

public class _5_LettersInWord {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        String input = scan.nextLine();

        String[] stringAsChar = input.split("");

        for (int i = 0; i < stringAsChar.length; i++) {
            System.out.println(stringAsChar[i]);
        }
    }
}
