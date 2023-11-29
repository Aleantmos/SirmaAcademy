import java.util.Scanner;

public class _39_ArrowPattern {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int num = Integer.parseInt(scan.nextLine());

        int n = num - 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("* ");

            }
            System.out.println();

            if (i == n - 1) {
                for (int j = 0; j < n; j++) {
                    int starsCnt;
                    int spaceEnd;
                    if (num % 2 == 0) {
                        starsCnt = n;
                        spaceEnd = starsCnt / 2 - 1;
                    } else {
                        starsCnt = n - 1;
                        spaceEnd = starsCnt / 2;
                    }

                    for (int h = 0; h <= spaceEnd; h++) {
                        System.out.print(" ");
                    }
                    for (int k = spaceEnd + 1; k <= starsCnt + spaceEnd; k++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }
        }

    }
}
