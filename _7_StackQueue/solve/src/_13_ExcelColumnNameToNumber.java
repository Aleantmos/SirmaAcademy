import java.util.Arrays;
import java.util.Scanner;

public class _13_ExcelColumnNameToNumber {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        String input = scan.nextLine();

        int result = excelColumnToNumber(input);

        System.out.println(result);

    }

    public static int excelColumnToNumber(String column) {
        int result = 0;
        for (int i = 0; i < column.length(); i++) {
            int element = column.charAt(i) - 'A' + 1;
            result = result * 26 + element;
        }
        return result;
    }
}
