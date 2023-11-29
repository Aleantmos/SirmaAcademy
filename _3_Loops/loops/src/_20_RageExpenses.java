import java.util.Scanner;

public class _20_RageExpenses {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int lostGamesCnt = Integer.parseInt(scan.nextLine());

        float headsetP = Float.parseFloat(scan.nextLine());
        float mouseP = Float.parseFloat(scan.nextLine());
        float keyboardP = Float.parseFloat(scan.nextLine());
        float displayP = Float.parseFloat(scan.nextLine());

        int headsetCnt = lostGamesCnt / 2;
        int mouseCnt = lostGamesCnt / 3;
        int keyboardCnt = lostGamesCnt / 6;
        int displayCnt = lostGamesCnt / 12;

        double total = headsetCnt*headsetP + mouseCnt*mouseP + keyboardCnt*keyboardP + displayCnt*displayP;

        System.out.printf("Rage expenses: %.2f lv.", total);
    }
}
