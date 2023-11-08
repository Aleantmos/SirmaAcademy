package service;

import model.items.AbstractProduct;
import model.shop.Shop;
import util.Util;

import java.util.List;

import static util.LoggedUser.isLogged;
import static util.LoggedUser.loggedUser;

public class AdminService {
    public void goToAdminPanel() {
        boolean inAdminPanel = true;
        while (inAdminPanel) {
            displayAdminPanel();
            int command = Integer.parseInt(Util.scan().nextLine());

            switch (command) {
                case 0:
                    inAdminPanel = false;
                    System.out.println("Left admin panel.");
                    break;
                case 1:
                    System.out.println("Please submit shop name:");
                    String shopName = Util.scan().nextLine();
                    System.out.println(makeShop(shopName));
                    break;
                case 2:
                    System.out.println("Choose product by id:");
                    List<String> allProducts = AllServices
                            .getProductService()
                            .getAllProducts();

                    allProducts.forEach(System.out::println);
                    long productId = Long.parseLong(Util.scan().nextLine());
                    AbstractProduct productById = AllServices
                            .getProductService()
                            .getProductById(productId);

                    if (productById == null) {
                        System.out.println("Product with given id does not exist.");
                    } else {

/*                        List<AbstractProduct> productIdsInStock = AllServices
                                .getShopService()
                                .findShopByOwnerId(loggedUser().getUserId())
                                .getProductIdsInStock();*/

                        System.out.println("Choose quantity:");
                        int stockOfProductToAdd = Integer.parseInt(Util.scan().nextLine());

                        String result = AllServices
                                .getShopService()
                                .addNewItem(productById, stockOfProductToAdd);
                        System.out.println(result);

                    }
                    break;
                case 3:
                    System.out.println("Choose from products in shop(submit id):");
                    AllServices.getShopService().printProductsInShop();

                    long productIdChosen = Long.parseLong(Util.scan().nextLine());

                    System.out.println("Choose quantity:");
                    int stockOfProductToAdd = Integer.parseInt(Util.scan().nextLine());

                    String result = AllServices
                            .getShopService()
                            .addStockToExistingItemInShop(productIdChosen, stockOfProductToAdd);

                    System.out.println(result);
                    break;
                case 4:
                    double averageCostPerUnit = AllServices.getShopService()
                            .getAverageCostPerUnit();
                    System.out.printf("The average cost per unit is %.2f", averageCostPerUnit);
                    break;

                case 5:
                    double averageRevenuePerUnit = AllServices.getShopService()
                            .getAverageRevenuePerUnit();
                    System.out.printf("The average revenue per unit is %.2f", averageRevenuePerUnit);
                    break;
            }
        }
    }

    private String makeShop(String shopName) {
        if (!isLogged()) {
            return "Please, go back to main and login first.";
        }
        Shop shop = new Shop(loggedUser().getUserId(), shopName);

        return AllServices.getShopService().addShop(shop);
    }

    private void displayAdminPanel() {
        System.out.println("""
                -----ADMIN PANEL-----
                0)Leave admin panel -> press 0
                1)Make new shop -> press 1
                2)Add new product in shop -> press 2
                3)Fill product stock -> press 3
                4)Get average cost per unit for shop -> press 4
                5)Get average revenue per unit for shop -> press 5""");
    }
}
