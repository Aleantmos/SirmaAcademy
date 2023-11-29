import java.util.Scanner;

public class _2_DayOfWeek {
    public static void main(String[] args) {
        Scanner scan = Util.scanner();

        int n = Integer.parseInt(scan.nextLine());

        String[] dayOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        System.out.println(dayOfWeek[n - 1]);
    }
}
