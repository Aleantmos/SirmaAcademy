import java.util.Scanner;

public class _22_NumberUpTo1000EndingIn7 {
    public static void main(String[] args) {

        int n = 7;

        for (int i = 0; i < 100; i++) {
            System.out.println(n);
            n += 10;
        }
    }
}
