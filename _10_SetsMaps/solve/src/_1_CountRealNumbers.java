import java.util.*;

public class _1_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        double[] input = Arrays.stream(scan.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double, Integer> numberCnt = new LinkedHashMap<>();

        for (double num : input) {
            numberCnt.putIfAbsent(num, 0);
            numberCnt.put(num, numberCnt.get(num) + 1);
        }

        for (Double key : numberCnt.keySet()) {
            System.out.printf("%.2f -> %d%n", key, numberCnt.get(key));
        }

    }
}
