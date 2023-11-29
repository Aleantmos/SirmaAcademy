import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class _4_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = Util.scan();


        String[] input = scan.nextLine().split(" ");

        ArrayDeque<String> data = new ArrayDeque<>();

        for (String element : input) {
            data.push(element);
        }

        int result = 0;
        while (data.size() > 1) {
            int n1 = Integer.parseInt(data.pop());
            String command = data.pop();;


            if (command.equals("+")) {
                result += n1;
            } else {
                result -= n1;
            }
        }

        result += Integer.parseInt(data.pop());

        System.out.println(result);
    }
}
