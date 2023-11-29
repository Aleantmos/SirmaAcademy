import java.util.Scanner;

public class _3_1toNTrough2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= num; i += 2) {
            System.out.println(i);
        }
    }
}
