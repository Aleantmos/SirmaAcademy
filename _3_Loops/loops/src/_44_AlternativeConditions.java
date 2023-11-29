import java.util.Scanner;

public class _44_AlternativeConditions {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int n = Integer.parseInt(scan.nextLine());

        int cnt = 0;
        boolean toBreak = false;

        for (int i = n; i >= 1; i--) {

            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= n - i; j++) {
                System.out.print(++cnt);
               /* if (cnt == n) {
                    toBreak = true;
                    break;
                }*/
            }

            if (toBreak) {
                break;
            }
            System.out.println();
        }
    }
}
