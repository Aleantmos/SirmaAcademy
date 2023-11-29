import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _9_HotPotato {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

       List<String> input = new ArrayList<>(
               Arrays.stream(scan.nextLine().split(" ")).toList());

       int n = Integer.parseInt(scan.nextLine());
       int rotations = input.size() % n;

       int currIndex = 0;

       while (input.size() > 1) {

           currIndex = (currIndex + n - 1) % input.size();

           String toRemove = input.remove(currIndex);

           System.out.println("Remove " + toRemove);
       }
        System.out.println("Last is " + input.get(0));
    }
}
