import java.util.Scanner;

public class _6_SumOfVowels {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        String[] vowels = {"a", "e", "i", "o", "u"};

        String[] inputAsArr = scan.nextLine().split("");

        int total = 0;

        for (String element : inputAsArr) {
            for (int i = 0; i < vowels.length; i++) {
                if (element.equals(vowels[i])) {
                    total += i + 1;
                    break;
                }
            }
        }

        System.out.println(total);

    }
}
