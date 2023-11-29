import java.util.Scanner;

public class _13_PalindromeCheck {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        String[] input = scan.nextLine().split("");

        boolean isPalindrome = true;

        int size = input.length;

        for (int i = 0; i < size / 2; i++) {
            if (!input[i].equals(input[size - 1 - i])) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome);

    }
}
