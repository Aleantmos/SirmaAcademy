import java.util.Scanner;

public class _19_CheckerboardPattern {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        int n = Integer.parseInt(scan.nextLine());

        int first;
        int second;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                first = 0;
                second = 1;
            } else {
                first = 1;
                second = 0;
            }
            for (int j = 0; j < n; j++) {
                if (j % 2 == 0) {
                    System.out.print(first + " ");
                } else {
                    System.out.print(second + " ");
                }
            }
            System.out.println();
        }
    }
}
