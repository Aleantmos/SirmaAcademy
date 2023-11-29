import java.util.Scanner;

public class _2_Nto0 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = n; i >= 0; i--) {
            System.out.println(i);
        }
    }
}
