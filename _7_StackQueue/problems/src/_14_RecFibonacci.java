import java.util.Scanner;

public class _14_RecFibonacci {
    public static void main(String[] args) {
        Scanner scan = Util.scan();


        int n = Integer.parseInt(scan.nextLine());

        int fib = getFib(n);
        System.out.println(fib);

    }

    private static int getFib(int n) {
        if (n <= 1) {
            return n;
        }
        return getFib(n - 1) + getFib(n - 2);
    }
}
