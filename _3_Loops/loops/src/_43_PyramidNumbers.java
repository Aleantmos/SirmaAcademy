import java.util.Scanner;

public class _43_PyramidNumbers {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int n = Integer.parseInt(scan.nextLine());

        int cnt = 0;
        boolean toBreak = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(++cnt + " ");
                if (cnt == n) {
                    toBreak = true;
                    break;
                }
            }
            if (toBreak) {
                break;
            }
            System.out.println();
        }
    }
}



/*

1
2 3
4 5 6


* */