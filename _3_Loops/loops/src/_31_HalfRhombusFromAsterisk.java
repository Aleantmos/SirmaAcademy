import javax.security.auth.kerberos.EncryptionKey;
import java.beans.Encoder;
import java.util.Scanner;

public class _31_HalfRhombusFromAsterisk {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int n = Integer.parseInt(scan.nextLine());

        StringBuilder sb = new StringBuilder();
        int rowCnt = 1;

        for (int i = 1; i <= n; i++) {
            int cnt = 1;
            while (cnt <= rowCnt) {
                if (cnt == rowCnt) {
                    System.out.print("*");
                } else {
                    System.out.print("* ");
                }
                cnt++;
            }
            System.out.println();
            rowCnt++;
        }

        rowCnt = n - 1;

        for (int i = n - 1; i >= 1; i--) {
            int cnt = 1;
            while (cnt <= rowCnt) {

                if (cnt == rowCnt) {
                    System.out.print("*");
                } else {
                    System.out.print("* ");
                }
                cnt++;

            }
            System.out.println();
            rowCnt--;
        }
    }
}
