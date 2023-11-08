package service;

import fileReaderWriter.JSONReader;
import fileReaderWriter.JSONWriter;
import model.carts.Cart;
import model.enums.RoleEnum;
import model.users.User;
import util.LoggedUser;
import util.Util;

import java.util.List;

public class UserService {

    private static List<User> allUsers = JSONReader.getAllUsers();


    public String registerUser(String username, String password, RoleEnum role) {

        if (checkUsernameUniqueness(username)) {
            User user = new User(username, password);
            user.getRole().add(role);

            Cart cart = new Cart(user.getId());
            user.setCartId(cart.getCartId());;

            saveUser(user, cart);
            return "User registered successfully!";
        }
        return "Username not unique";
    }

    private boolean checkUsernameUniqueness(String username) {
        User userWithUsername = getUserWithUsername(username);
        return userWithUsername == null;
    }

    private static void saveUser(User user, Cart cart) {
        allUsers.add(user);
        AllServices.getCartService().saveUserCart(cart);
        JSONWriter.appendUser(allUsers, Util.userPathDB());
    }


    public String loginUser(String username, String password) {
        User userWithUsername = getUserWithUsername(username);
        if (userWithUsername != null && checkPasswordEquality(userWithUsername.getPassword(), password)) {
            LoggedUser.login(userWithUsername.getId(), userWithUsername.getUsername());
            return "User logged successfully.";
        }
        return "No such user. Please register first.";
    }

    private boolean checkPasswordEquality(String userPass, String dbPass) {
        return userPass.equals(dbPass);
    }

    private User getUserWithUsername(String username) {
        return allUsers.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public String logoutUser() {
        LoggedUser.logout();
        return "User logged out";
    }
}
