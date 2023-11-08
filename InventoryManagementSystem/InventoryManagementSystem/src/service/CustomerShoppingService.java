package service;

import model.enums.CategoryEnum;
import model.items.AbstractProduct;
import model.shop.Shop;
import util.LoggedUser;
import util.Util;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerShoppingService {
    public void goToShoppingPanel(Shop shopToGoInTo) {
        boolean isRunning  = true;

        while (isRunning) {
            displayMenu();
            String command = Util.scan().nextLine();
            switch (command) {
                case "0" :
                    LoggedUser.loggedUser().leaveShop();
                    isRunning = false;
                    System.out.println("Successfully left shop.");
                    break;
                case "1":
                    if (!checkIfUserLogged()) {
                        System.out.println("Please login first.");
                    } else {
                        shopToGoInTo.getProductIdsInStock()
                                .forEach(System.out::println);
                    }
                    break;
                case "2":
                    if (checkIfUserLogged()) {
                        System.out.println("Please login first.");
                    }
                    System.out.println("Choose category:" +
                            "For Groceries -> press 1" +
                            "For Appliances -> press 2" +
                            "For Clothes -> press 3");

                    int categoryIndex =
                            Integer.parseInt(Util.scan().nextLine());
                    CategoryEnum categoryChosen;
                    switch (categoryIndex) {
                        case 1 -> categoryChosen = CategoryEnum.GROCERIES;
                        case 2 -> categoryChosen = CategoryEnum.APPLIANCES;
                        case 3 -> categoryChosen = CategoryEnum.CLOTHES;
                        default -> categoryChosen = null;
                    }

                    List<AbstractProduct> allProductsByCategory = shopToGoInTo.getProductIdsInStock()
                            .stream()
                            .filter(p -> CategoryEnum.valueOf(p.getCategory()).equals(categoryChosen))
                            .toList();

                    if (allProductsByCategory.isEmpty()) {
                        System.out.println("No products with this category");
                    } else {
                        allProductsByCategory
                                .forEach(System.out::println);
                    }
                    break;
                case "3":
                    System.out.println("Choose product by id to add to cart:");
                    shopToGoInTo.getProductIdsInStock()
                            .forEach(e -> System.out.println(e.toString()));

                    int productId = Integer.parseInt(Util.scan().nextLine());

                    AbstractProduct productToAddToCart = shopToGoInTo.getProductById(productId);

                    AllServices.getCartService()
                            .addItemToCart(productToAddToCart);


                    break;
            }
        }
    }

    private static boolean checkIfUserLogged() {
        return LoggedUser.isLogged();
    }

    private void displayMenu() {
        System.out.println("""
                -----Choose command:-----
                0)Go back to main menu -> press 0
                1)Check out all products -> press 1
                2)Check out all products by category -> press 2
                3)Add product to cart -> press 3
                4)Buy products -> press 4""");
    }
}
