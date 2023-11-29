import java.util.Scanner;

public class _25_CoinsAndNotes {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int oneCnt = Integer.parseInt(scan.nextLine());
        int twoCnt = Integer.parseInt(scan.nextLine());
        int fiveCnt = Integer.parseInt(scan.nextLine());

        int amount = Integer.parseInt(scan.nextLine());

        for (int i = 0; i <= oneCnt; i++) {
            for (int j = 0; j <= twoCnt; j++) {
                for (int k = 0; k <= fiveCnt; k++) {
                    int sum = i + j * 2 + k * 5;
                    if (sum == amount) {
                        System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 = %d lv.%n", i, j, k, sum);
                    }
                }
            }

        }
    }
}
