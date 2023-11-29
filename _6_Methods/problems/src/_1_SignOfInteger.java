import java.util.Scanner;

public class _1_SignOfInteger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        signOfInteger(n);
    }

    public static void signOfInteger(int n) {
        if (n > 0) {
            System.out.println("The number " + n + " is positive");
        } else if (n == 0) {
            System.out.println("The number " + n + " is zero");
        } else {
            System.out.println("The number" + n + " is negative");
        }
    }
}
