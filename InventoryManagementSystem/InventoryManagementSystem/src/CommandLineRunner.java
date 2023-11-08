import model.enums.CategoryEnum;
import model.enums.RoleEnum;
import model.shop.Shop;
import service.AllServices;
import util.LoggedUser;
import util.Util;

import java.util.List;

public class CommandLineRunner {
    public static void main(String[] args) {

        System.out.println("Welcome to shop!");

        boolean isRunning = true;
        while (isRunning) {
            displayMenu();
            String command = Util.scan().nextLine();

            switch (command) {
                case "0":
                    isRunning = false;
                    break;
                case "1":
                    System.out.println("Submit username:");
                    String username = Util.scan().nextLine();
                    System.out.println("Submit password:");
                    String password = Util.scan().nextLine();

                    System.out.println(AllServices
                            .getUserService()
                            .loginUser(username, password));
                    break;
                case "2":
                    System.out.println("Submit username:");
                    username = Util.scan().nextLine();
                    System.out.println("Submit password:");
                    password = Util.scan().nextLine();

                    System.out.println(AllServices
                            .getUserService()
                            .registerUser(username, password, RoleEnum.USER));
                    break;
                case "3":
                    System.out.println(AllServices
                            .getUserService()
                            .logoutUser());
                    break;
                case "4":
                    //Todo
                    AllServices.getAdminService()
                            .goToAdminPanel();
                    break;
                case "9":
                    System.out.println("Choose shop by id:");
                    List<Shop> allShops = AllServices.getShopService().getAllShops();

                    allShops.forEach(e -> System.out.printf("%s -> id: %d%n",
                            e.getShopName(), e.getShopId()));

                    //todo check if number
                    long shopId = Long.parseLong(Util.scan().nextLine());

                    Shop shopToGoInTo = AllServices.getShopService().getAllShops()
                            .stream()
                            .filter(e -> e.getShopId().equals(shopId))
                            .findFirst()
                            .orElse(null);

                    if (shopToGoInTo != null) {
                        String message = LoggedUser.loggedUser().goInShop(shopToGoInTo);
                        System.out.println(message);

                        AllServices.getCustomerShoppingService().goToShoppingPanel(shopToGoInTo);
                    } else {
                        System.out.println("Shop does not exist! Please try again.");
                    }
                    break;

            }
        }
    }



    private static void displayMenu() {
        System.out.println("""
                ------Choose command:------
                0)End program -> press 0
                1)Login -> press 1
                2)Register -> press 2
                3)Logout -> press 3
                4)Go to admins panel -> press 4
                9)Go in shop -> press 9""");
              
    }

    private static boolean checkIfUserLogged() {
        return LoggedUser.isLogged();
    }

}
