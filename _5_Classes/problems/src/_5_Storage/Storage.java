package _5_Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Storage {
    private int capacity;
    private List<Product> products;

    public Storage(int capacity) {
        this.capacity = capacity;
        this.products = new ArrayList<>();
    }

    public double totalCost() {
        return products.stream()
                .mapToDouble(product -> product.getPrice() * product.getQuantity())
                .sum();
    }

    public void addProduct(Product product) {
        reduceCapacity(product.getQuantity());
        products.add(product);
    }


    public String getProducts() {
        return products.stream()
                .map(Product::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private void reduceCapacity(int amount) {
        this.capacity -= amount;
    }

    public int getCapacity() {
        return capacity;
    }
}
