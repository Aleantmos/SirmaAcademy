package service;

import fileReaderWriter.JSONReader;
import fileReaderWriter.JSONWriter;
import model.items.AbstractProduct;
import model.shop.Shop;
import util.LoggedUser;

import java.util.List;

import static util.LoggedUser.loggedUser;

public class ShopService {
    private static List<Shop> allShops = JSONReader.getAllShops();

    public Shop loggedUserShop() {
        return findShopByOwnerId(LoggedUser.loggedUser().getUserId());
    }

    public String addStockToExistingItemInShop(Long itemId, int quantity) {
        AbstractProduct productById = getItemFromItemsInShop(itemId);

        if (productById == null) {
            return "No such product in shop";
        }

        addQuantityForStock(productById, quantity);
        saveShop();

        return "Item quantity successfully increased";
    }

    private AbstractProduct getItemFromItemsInShop(Long itemId) {
        return loggedUserShop().getProductIdsInStock()
                .stream()
                .filter(i -> i.getId().equals(itemId))
                .findFirst()
                .orElse(null);
    }

    private void addQuantityForStock(AbstractProduct productById, int quantity) {
        productById.setQuantity(productById.getQuantity() + quantity);
    }

    public String addNewItem(AbstractProduct productById, int quantity) {

        if (productById == null) {
            return "No such product in shop";
        }

        if (!checkIfItemAlreadyAdded(productById)) {
            AllServices.getShopService().setShop(quantity, productById);
            return "Item added successfully";
        }

        return "Item already added";
    }

    private boolean checkIfItemAlreadyAdded(AbstractProduct productById) {
        return loggedUserShop().getProductIdsInStock().contains(productById);
    }

    private void setShop(int quantity, AbstractProduct productById) {
        productById.setQuantity(quantity);
        //loggedUserShop = findShopByOwnerId(loggedUser().getUserId());
        loggedUserShop().getProductIdsInStock().add(productById);
        saveShop();
    }



    private Shop findShopById(Long ownerId) {
        return allShops.stream()
                .filter(s -> s.getOwnerId().equals(ownerId))
                .findFirst()
                .orElse(null);
    }


    public double calculateAverageCost(List<AbstractProduct> productIdsSold) {
        double totalAverageCost = 0;
        double totalAverageQuantity = 0;

        for (AbstractProduct product : productIdsSold) {
            AbstractProduct productById = AllServices
                    .getProductService()
                    .getProductById(product
                            .getId());
            Integer quantityOfProductSold = product.getQuantity();

            double totalCost = productById.getCost() * quantityOfProductSold;
            double totalQuantity = quantityOfProductSold;

            totalAverageCost += totalCost / totalQuantity;
            totalAverageQuantity++;
        }
        return totalAverageCost / totalAverageQuantity;
    }

    public double calculateAverageRevenue(List<AbstractProduct> productIdsSold) {
        double totalAverageRevenue = 0;
        double totalAverageQuantity = 0;

        if (productIdsSold.isEmpty()) {
            return 0;
        } else {
            for (AbstractProduct product : productIdsSold) {
                AbstractProduct productById = AllServices
                        .getProductService()
                        .getProductById(product
                                .getId());
                Integer quantityOfProductSold = product.getQuantity();

                double totalCost = productById.getPrice() * quantityOfProductSold;
                double totalQuantity = quantityOfProductSold;

                totalAverageRevenue += totalCost / totalQuantity;
                totalAverageQuantity++;
            }
            return totalAverageRevenue / totalAverageQuantity;
        }
    }

    public List<Shop> getAllShops() {
        return JSONReader.getAllShops();
    }

    public Shop findShopByOwnerId(Long userId) {
        Shop shop = allShops.stream()
                .filter(s -> s.getOwnerId().equals(userId))
                .findFirst()
                .orElse(null);
        return shop;
    }

    public void printProductsInShop() {
        //loggedUserShop = findShopById(loggedUser().getUserId());
        loggedUserShop()
                .getProductIdsInStock()
                .forEach(p -> System.out.println(p.toString()));
    }

    public double getAverageCostPerUnit() {
        //loggedUserShop = findShopById(loggedUser().getUserId());
        return calculateAverageCost(loggedUserShop().getProductIdsInStock());
    }


    public double getAverageRevenuePerUnit() {
        //loggedUserShop = findShopById(loggedUser().getUserId());
        return calculateAverageRevenue(loggedUserShop().getProductIdsSold());
    }

    private Integer getProductQuantityFromProductsInStockForProduct(Long productId) {
        //loggedUserShop = findShopById(loggedUser().getUserId());
        return loggedUserShop().getProductIdsInStock()
                .stream()
                .filter(e -> e.getId().equals(productId))
                .findFirst()
                .map(AbstractProduct::getQuantity)
                .orElse(null);
    }

    public String addShop(Shop shop) {
        allShops.add(shop);
        saveShop();
        return "Shop saved successfully";
    }

    private static void saveShop() {
        JSONWriter.appendShop(allShops);
    }
}
