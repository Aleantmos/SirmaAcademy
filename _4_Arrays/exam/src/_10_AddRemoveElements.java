import java.util.Scanner;

public class _10_AddRemoveElements {
    public static void main(String[] args) {
        Scanner scan = Util.scanner();

        String[] commands = scan.nextLine().split(",");

        int curr = 1;

        int[] arr = new int[0];
        int arrSize = 0;

        for (int i = 0; i < commands.length; i++) {
            int[] newArr;
            if (commands[i].equals("add")) {
                arrSize++;
                newArr = new int[arrSize];

                if (arr.length != 0) {
                    for (int j = 0; j < arr.length; j++) {
                        newArr[j] = arr[j];
                    }
                }
                newArr[arrSize - 1] = curr;
                arr = newArr;
                curr++;

            } else if (commands[i].equals("remove")) {
                if (arr.length != 0) {
                    arrSize--;
                    newArr = new int[arrSize];
                    for (int j = 0; j < newArr.length; j++) {
                        newArr[j] = arr[j];
                    }
                    arr = newArr;
                }
            }
        }

        if (arr.length == 0) {
            System.out.println("Empty");
        } else {
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }
    }

}
