package service;

import fileReaderWriter.JSONReader;
import model.enums.CategoryEnum;
import model.items.AbstractProduct;
import util.Util;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    private static final List<AbstractProduct> allProducts = Util.initAllProducts();

    public List<String> getAllProducts() {
        return allProducts.stream()
                .map(AbstractProduct::toString)
                .collect(Collectors.toList());
    }


    public List<String> getAllProductsByCategory(CategoryEnum categoryChosen) {
        return allProducts.stream()
                .filter(p -> p.getCategory().equals(categoryChosen.toString()))
                .map(AbstractProduct::toString)
                .collect(Collectors.toList());
    }

    public AbstractProduct getProductById(long productId) {
        return allProducts.stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst()
                .orElse(null);
    }
}
