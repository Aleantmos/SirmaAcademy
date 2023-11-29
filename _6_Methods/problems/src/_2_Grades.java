import java.util.Scanner;

public class _2_Grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double n = Double.parseDouble(scan.nextLine());

        String result = getGrade(n);
    }

    public static String getGrade(double n) {
        String result = "";

        if (n > 5.5) {
            result = "Excellent";
        } else if (n > 4.5) {
            result = "Very good";
        } else if (n > 3.5) {
            result = "Good";
        } else if (n > 3) {
            result = "Poor";
        } else {
            result = "Fail";
        }

        return result;
    }
}
