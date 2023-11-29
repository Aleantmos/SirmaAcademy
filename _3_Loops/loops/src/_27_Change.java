import java.math.BigDecimal;
import java.util.Scanner;

public class _27_Change {
    // float -> not working
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        BigDecimal[] coins = {
                new BigDecimal("20"),
                new BigDecimal("10"),
                new BigDecimal("5"),
                new BigDecimal("2"),
                new BigDecimal("1"),
                new BigDecimal("0.5"),
                new BigDecimal("0.2"),
                new BigDecimal("0.1"),
                new BigDecimal("0.05"),
                new BigDecimal("0.02"),
                new BigDecimal("0.01")
        };
        int coinsCnt = 0;

        BigDecimal amount = new BigDecimal(scan.nextLine());

        for (int i = 0; i < coins.length; i++) {

            while (amount.compareTo(coins[i]) >= 0) {
                amount = amount.subtract(coins[i]);
                coinsCnt++;
            }
        }
        System.out.println(coinsCnt);
    }
}
