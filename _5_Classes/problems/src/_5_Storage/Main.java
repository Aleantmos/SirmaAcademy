package _5_Storage;

public class Main {
    public static void main(String[] args) {
        Product productOne = new Product("cucumber",1.50,15);
        Product productTwo = new Product("tomato", 0.90, 25);
        Product productThree = new Product("bread", 1.10, 8);

        var storage = new Storage(50);

        storage.addProduct(productOne);
        storage.addProduct(productTwo);
        storage.addProduct(productThree);
        storage.getProducts();
        System.out.println(storage.getCapacity());
        System.out.println(storage.totalCost());
        System.out.println(storage.getProducts());
    }
}
