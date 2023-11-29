import java.util.Scanner;

public class _17_NewBuilding {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();
        int floors = Integer.parseInt(scan.nextLine());
        int rooms = Integer.parseInt(scan.nextLine());

        String type = "";

        for (int i = floors; i >= 1; i--) {
            int cnt = 0;
            String[] row = new String[rooms];
            if (i == floors) {
                type = "L";
            } else if (i % 2 == 1) {
                type = "A";
            } else {
                type = "O";
            }
            while (cnt < rooms) {
                String s = String.valueOf(i);
                String cntStr = String.valueOf(cnt + 1);
                String print = type + s + cntStr;
                row[cnt] = print;
                cnt++;
            }
            System.out.println(String.join(" ", row));
        }
    }
}