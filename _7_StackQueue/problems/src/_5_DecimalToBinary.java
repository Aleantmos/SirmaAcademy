import java.util.ArrayDeque;
import java.util.Scanner;

public class _5_DecimalToBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> binary = new ArrayDeque<>();

        if (n == 0) {
            System.out.println(0);
        } else {
            while (n != 0) {
                binary.push(n % 2);
                n /= 2;
            }
        }

        while (!binary.isEmpty()) {
            System.out.print(binary.pop());
        }
    }
}
