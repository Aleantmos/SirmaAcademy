package fileReaderWriter;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.carts.Cart;
import model.shop.Shop;
import model.users.User;
import util.Util;

import java.io.*;
import java.util.List;

public class JSONWriter {



    public static void appendUser(List<User> users, String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        try {
            writer.writeValue(new File(filePath), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void appendCategory(String category, String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        try {
            writer.writeValue(new File(filePath), category);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendCart(List<Cart> cart) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        try {
            writer.writeValue(new File(Util.cartPathDb()), cart);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendShop(List<Shop> shop) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        try {
            writer.writeValue(new File(Util.shopPathDb()), shop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
