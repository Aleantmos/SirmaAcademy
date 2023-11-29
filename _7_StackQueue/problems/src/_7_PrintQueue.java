import java.util.ArrayDeque;
import java.util.Scanner;

public class _7_PrintQueue {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        ArrayDeque<String> queue = new ArrayDeque<>();

        String input = scan.nextLine();

        while (!input.equals("print")) {

            if (input.equals("cancel") && queue.isEmpty()) {
                System.out.println("Standby");
            } else if (input.equals("cancel")) {
                String toCancel = queue.poll();
                System.out.println("Canceled " + toCancel);
            } else {
                queue.offer(input);
            }
            input = scan.nextLine();
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
