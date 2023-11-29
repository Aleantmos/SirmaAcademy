import java.util.Arrays;
import java.util.Scanner;

public class TODO_18_ListOfProducts {
    public static void main(String[] args) {
        Scanner scan = Util.scanner();

        int[] arr = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[] input = scan.nextLine().split(", ");

        for (int i = 0; i < input.length; i++) {
            String[] data = input[i].split(" ");
            String command = data[0];

            int[] newArr = null;

            if (command.equals("Add")) {
                int element = Integer.parseInt(data[1]);

                newArr = grow(arr.length + 1, arr);
                newArr[newArr.length - 1] = element;

            } else if (command.equals("Remove")) {
                int element = Integer.parseInt(data[1]);
                newArr = remove(arr, element);

            } else if (command.equals("RemoveAt")) {
                int index = Integer.parseInt(data[1]);

                newArr = removeAt(arr, index);

            } else if (command.equals("Insert")) {
                int element = Integer.parseInt(data[1]);
                int index = Integer.parseInt(data[2]);

                newArr = insertIn(element, index, arr);
            }

            arr = newArr;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }

    }

    private static int[] insertIn(int element, int index, int[] arr) {
        int[] newArr = new int[arr.length + 1];

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                newArr[cnt++] = element;
                i--;
                index = -1;
            } else {
                newArr[cnt++] = arr[i];
            }
        }
        return newArr;
    }

    private static int[] removeAt(int[] arr, int index) {

        int[] newArr = new int[arr.length - 1];
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                newArr[cnt++] = arr[i];
            }
        }

        return newArr;
    }

    private static int[] remove(int[] arr, int element) {

        int[] newArr = new int[arr.length - 1];
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != element) {
                newArr[cnt++] = arr[i];
            }
        }
        if (newArr.length == arr.length) {
            return arr;
        } else {
            return newArr;
        }
    }

    private static int[] grow(int size, int[] arr) {

        int[] newArr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}
