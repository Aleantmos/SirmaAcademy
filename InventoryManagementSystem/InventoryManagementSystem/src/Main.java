import fileReaderWriter.JSONReader;
import model.shop.Shop;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shop> allShops = JSONReader.getAllShops();

        if (allShops.isEmpty()) {
            System.out.println("empty");
        } else {
            for (Shop allShop : allShops) {
                System.out.println(allShop.toString());
            }
        }
    }
}
