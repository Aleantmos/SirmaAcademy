package _1_CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cnt = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < cnt; i++) {
            String[] tokens = scan.nextLine().split(" ");
            String brand = tokens[0];

            Car car = null;

            if (tokens.length == 1) {
                car = new Car(brand);
            } else if (tokens.length == 2) {
                String model = tokens[1];
                car = new Car(brand, model);
            } else if (tokens.length == 3) {
                String model = tokens[1];
                int horsepower = Integer.parseInt(tokens[2]);
                car = new Car(brand, model, horsepower);
            }
            System.out.println(car.carInfo());
        }
    }
}
