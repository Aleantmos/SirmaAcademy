import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _12_TaskScheduler {
    public static void main(String[] args) {
        Scanner scan = Util.scan();


        PriorityQueue<Task>  priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a-> a.priority * (-1)));

        String info = scan.nextLine();

        while (!info.isBlank()) {
            String[] tokens = info.split(" ");

            String command = tokens[0];

            if (command.equals("Add")) {
                Task task = new Task(tokens[1], Integer.parseInt(tokens[2]));
                priorityQueue.add(task);
            } else if (command.equals("getNextTask")) {
                System.out.println(priorityQueue.peek());
            }

            info = scan.nextLine();
        }
    }

    public static class Task {
        private String name;
        private int priority;

        public Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        @Override
        public String toString() {
            return String.format("%s - %d", this.name, this.priority);
        }
    }


}
