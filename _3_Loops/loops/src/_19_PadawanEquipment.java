import java.util.Scanner;

public class _19_PadawanEquipment {
    public static void main(String[] args) {
        Scanner scan = Util.importScanner();

        int budget = Integer.parseInt(scan.nextLine());
        int studentsCnt = Integer.parseInt(scan.nextLine());

        double saberP = Double.parseDouble(scan.nextLine());
        double robeP = Double.parseDouble(scan.nextLine());
        double beltP = Double.parseDouble(scan.nextLine());

        double total = studentsCnt * (robeP) +  ((studentsCnt - studentsCnt/6) * beltP) + (Math.ceil(studentsCnt * 1.1) * saberP);

        if (budget >= total) {
            System.out.printf("The money is enough - it would cost %.2flv.", total);
        } else {
            double needed = total - budget;
            System.out.printf("George Lucas will need %.2flv more.", needed);
        }
    }
}
