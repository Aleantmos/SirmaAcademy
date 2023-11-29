package _18_List;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        CustomList<String> customList = new CustomListImpl<>();

        while (!input.equals("end")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String element = tokens[1];
                    customList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(tokens[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    String searched = tokens[1];
                    System.out.println(customList.contains(searched));
                    break;
                case "Swap":
                    int i1 = Integer.parseInt(tokens[1]);
                    int i2 = Integer.parseInt(tokens[2]);
                    customList.swap(i1, i2);
                    break;
                case "Greater":
                    String greater = tokens[1];
                    System.out.println(customList.countGreaterThan(greater));
                    break;
                case "Max":
                    String max = customList.getMax();
                    System.out.println(max);
                    break;
                case "Min":
                    String min = customList.getMin();
                    System.out.println(min);
                    break;
                case "Print":
                    for (int i = 0; i < customList.size(); i++) {
                        System.out.println(customList.get(i));
                    }
                    break;


            }

            input = scan.nextLine();
        }
    }
}
