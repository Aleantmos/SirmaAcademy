package service;

import fileReaderWriter.JSONReader;
import fileReaderWriter.JSONWriter;
import model.carts.Cart;
import model.items.AbstractProduct;
import util.LoggedUser;
import util.Util;

import java.util.List;

import static util.LoggedUser.loggedUser;

public class CartService {

    private List<Cart> allCarts = JSONReader.getAllCarts();

    public void saveUserCart(Cart cart) {
        allCarts.add(cart);
        JSONWriter.appendCart(allCarts);
    }

    public void addItemToCart(AbstractProduct productToAddToCart) {
        Cart cart = allCarts.stream()
                .filter(c -> c.getUserId().equals(loggedUser().getUserId()))
                .findFirst()
                .orElse(null);
        List<AbstractProduct> itemsAdded = cart.getItemsAdded();

        itemsAdded.add(productToAddToCart);

        JSONWriter.appendCart(allCarts);
    }
}
