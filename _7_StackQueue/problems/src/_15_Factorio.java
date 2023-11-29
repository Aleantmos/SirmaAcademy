import java.util.*;

public class _15_Factorio {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        String[] input = scan.nextLine().split("\\|");
        ArrayDeque<Robot> robots = new ArrayDeque<>();

        for (String data : input) {
            String[] tokens = data.split("-");
            String name = tokens[0];
            int processingTime = Integer.parseInt(tokens[1]);

            Robot robot = new Robot(name, processingTime);
            robots.offer(robot);
        }


        int[] time = new int[3];

        time = Arrays.stream(scan.nextLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String line = scan.nextLine();

        while (!line.equals("End")) {
            Robot currRobot = robots.poll();
            currRobot.setJob(line);

            time[2]++;
            if (time[2] == 60) {
                time[2] = 0;
                time[1]++;
                if (time[1] == 60) {
                    time[1] = 0;
                    time[0]++;
                    if (time[0] == 24) {
                        time[0] = 0;
                    }
                }
            }

            line = scan.nextLine();
        }

    }

    public static class Robot {
        private String name;
        private int processing;
        private String job;
        private String time;

        public Robot(String name, int processing) {
            this.name = name;
            this.processing = processing;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
