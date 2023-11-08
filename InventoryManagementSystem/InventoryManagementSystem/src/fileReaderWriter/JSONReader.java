package fileReaderWriter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.carts.Cart;
import model.items.AbstractProduct;
import model.shop.Shop;
import model.users.User;
import util.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {
    public static List<Shop> getAllShops() {
        List<Shop> shopList;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(Util.shopPathDb());
            shopList = objectMapper.readValue(file,
                    new TypeReference<List<Shop>>(){});
        } catch (IOException e) {
            return new ArrayList<>();
        }
        return (List<Shop>) shopList;
    }

    public static List<User> getAllUsers() {
        List<User> userList;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(Util.userPathDB());
            userList = objectMapper.readValue(file,
                    new TypeReference<List<User>>() {});

        } catch (IOException e) {
            return new ArrayList<>();
        }
        return (List<User>) userList;
    }

    public static List<AbstractProduct> getAllProducts() {
        List<AbstractProduct> productList;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            productList = objectMapper.readValue(new File(Util.itemPathDB()),
                    new TypeReference<List<AbstractProduct>>(){});
        } catch (IOException e) {
            return new ArrayList<>();
        }
        return productList;
    }

    public static List<? extends Serializable> getAllCategories() {
        List<String> categoryList;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            categoryList = objectMapper.readValue(new File(Util.itemPathDB()),
                    new TypeReference<List<String>>(){});
        } catch (IOException e) {
            return new ArrayList<>();
        }
        return categoryList;
    }



    public static List<Cart> getAllCarts() {
        List<Cart> cartList;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            cartList = objectMapper.readValue(new File(Util.cartPathDb()),
                    new TypeReference<List<Cart>>(){});
        } catch (IOException e) {
            return new ArrayList<>();
        }
        return cartList;
    }
}
