package util;

import model.items.AbstractProduct;
import model.items.impl.Appliances;
import model.items.impl.Clothes;
import model.items.impl.Groceries;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Util {

    public static Scanner scan() {
        return new Scanner(System.in);
    }

    public static String userPathDB() {
        return "src/db/users";
    }

    public static String itemPathDB() {
        return "src/db/products";

    }

    public static String cartPathDb() {
        return "src/db/carts";
    }

    public static String shopPathDb() {
        return "src/db/shops";
    }

    public static List<AbstractProduct> initAllProducts() {

        List<AbstractProduct> abstracItemstList = new ArrayList<>();
        Clothes clothes1 = new Clothes("T-Shirt", 25.0, 10.0, 0);
        abstracItemstList.add(clothes1);

        Clothes clothes2 = new Clothes("Jeans", 60.0, 30.0, 0);
        abstracItemstList.add(clothes2);

        Clothes clothes3 = new Clothes("Dress", 80.0, 40.0, 0);
        abstracItemstList.add(clothes3);

        Appliances appliance1 = new Appliances("Refrigerator", 500.0, 300.0, 0);
        abstracItemstList.add(appliance1);

        Appliances appliance2 = new Appliances("Washing Machine", 400.0, 250.0, 0);
        abstracItemstList.add(appliance2);

        Appliances appliance3 = new Appliances("Microwave", 200.0, 100.0, 0);
        abstracItemstList.add(appliance3);

        Groceries groceries1 = new Groceries("Apples", 2.0, 1.0, 0);
        abstracItemstList.add(groceries1);

        Groceries groceries2 = new Groceries("Milk", 3.0, 1.5, 0);
        abstracItemstList.add(groceries2);

        Groceries groceries3 = new Groceries("Bread", 1.5, 0.75, 0);
        abstracItemstList.add(groceries3);

        return abstracItemstList;
    }
}
