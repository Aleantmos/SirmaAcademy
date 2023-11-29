import java.util.Scanner;

public class _28_PyramidOfNumbers {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int n = Integer.parseInt(scan.nextLine());

        int curr = 1;
        int currRowSize = 1;
        int rowCnt = 1;

        while (curr <= n) {
            System.out.print(curr + " ");
            if (rowCnt == currRowSize) {
                System.out.println();
                currRowSize++;
                rowCnt = 0;
            }
            rowCnt++;
            curr++;
        }




        /*
        int rowSize = 1;
        int curr = 1;

        boolean isFinished = false;

        for (int i = 1; i <= n; i++) {

            int cnt = 1;
            while (cnt <= rowSize) {
                System.out.print(curr + " ");
                cnt++;
                curr++;

                if (curr > n) {
                    isFinished = true;
                    break;
                }

            }
            if (isFinished) {
                break;
            }
            System.out.println();
            rowSize++;
        }*/

    }
}
