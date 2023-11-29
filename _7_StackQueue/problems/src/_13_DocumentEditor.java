import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

public class _13_DocumentEditor {

    //Todo - redo example
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> stack = new ArrayDeque<>();


        String input = scan.nextLine();

        while (!input.equals("End")) {

            String[] elements = input.split("\\(");

            String command = elements[0];

            if (command.equals("Insert")) {
                String currElement = elements[1].substring(1, elements[1].length() - 2);
                queue.offer(currElement);
            } else if (command.equals("Undo")) {
                stack.push(queue.removeLast());
            } else if (command.equals("Redo")) {
                queue.offer(stack.pop());
            }

            printElements(queue);
            System.out.println();
            input = scan.nextLine();
        }
    }

    private static void printElements(ArrayDeque<String> queue) {

        for (String element : queue) {
            System.out.print(element + " ");
        }
     /*
        if (!queue.isEmpty()) {
            Iterator<String> iterator = queue.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
        }*/
    }
}
