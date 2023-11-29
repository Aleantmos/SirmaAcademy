import java.util.Scanner;

public class _18_MagicNumber {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();
        
        int from = Integer.parseInt(scan.nextLine());
        int to = Integer.parseInt(scan.nextLine());
        int magic = Integer.parseInt(scan.nextLine());

        int combo = 0;

        boolean isFound = false;

        for (int i = from; i <= to; i++) {
            for (int j = from; j <= to; j++) {
                combo++;
                int sum = i + j;
                if (sum == magic) {
                    System.out.printf("Combination: %d - (%d + %d = %d)", combo, i, j, sum);
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }

        if (!isFound) {
            System.out.printf("%d combinations - neither equals %d", combo, magic);
        }
    }
}
