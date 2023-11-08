package util;

import model.shop.Shop;

public class LoggedUser {

    private Long userId;
    private String username;
    private static final LoggedUser loggedUser = new LoggedUser();
    private Shop inShop = null;

    private LoggedUser() {}

    public static LoggedUser loggedUser() {
        return loggedUser;
    }

    public static void login(Long userId, String username) {
        loggedUser.setUserId(userId);
        loggedUser.setUsername(username);
    }


    public static boolean isLogged() {
        return loggedUser().username != null && loggedUser().userId != null;
    }

    public static void logout() {
        loggedUser.setUserId(null);
        loggedUser.setUsername(null);
    }

    public Long getUserId() {
        return userId;
    }

    private void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }


    public String goInShop(Shop shop) {
        this.inShop = shop;
        return String.format("Welcome to %s. Enjoy shopping!", shop.getShopName());
    }

    public void leaveShop() {
        this.inShop = null;
    }

    public Shop checkTheShop() {
        return this.inShop;
    }
}
