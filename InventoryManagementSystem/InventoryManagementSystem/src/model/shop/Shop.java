package model.shop;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import model.items.AbstractProduct;
import service.AllServices;

import java.util.ArrayList;
import java.util.List;
//"productIdsInStock", "productIdsSold"
@JsonIgnoreProperties({"totalCost", "totalRevenue"})

public class Shop {
    private static Long cntId = 0L;
    private Long shopId;
    private Long ownerId;
    private String shopName;
    private List<AbstractProduct> productIdsInStock;
    private List<AbstractProduct> productIdsSold;
    private double totalCost = 0;
    private double totalRevenue = 0;

    public Shop() {
    }

    public Shop(Long ownerId, String shopName) {
        this.ownerId = ownerId;
        this.shopName = shopName;
        setShopId();
        this.productIdsInStock = new ArrayList<>();
        this.productIdsSold = new ArrayList<>();
    }


    private void setShopId() {
        this.shopId = ++cntId;
    }


    /*public String buyStock(Long itemId, int quantity) {
        *//*return AllServices.getShopService()
                .addNewItem(itemId, quantity);*//*
        return null;
    }*/
    public String sellItemQuantity(Long itemId, Long quantity) {

        return "todo";
    }

    public Long getOwnerId() {
        return ownerId;
    }

	public double getTotalRevenue() {
        return this.totalRevenue;
    }
	public double getTotalCost() {
        return this.totalCost;
    }
	public String averageCostPerUnitSold() {
        double averageCost = AllServices.getShopService()
                .calculateAverageCost(productIdsSold);
        return String.format("Average cost per unit for units sold - %.2f", averageCost);
    }
	public String averageRevenuePerUnitSold() {
        double averageRevenue = AllServices.getShopService()
                .calculateAverageRevenue(productIdsSold);
        return String.format("Average revenue per unit for units sold - %.2f", averageRevenue);
    }

    public void setTotalCost(double totalCost) {
        this.totalCost += totalCost;
    }

    public Long getShopId() {
        return this.shopId;
    }

    public List<AbstractProduct> getProductIdsInStock() {
        return this.productIdsInStock;
    }

    public List<AbstractProduct> getProductIdsSold() {
        return productIdsSold;
    }

    public String getShopName() {
        return shopName;
    }

    public AbstractProduct getProductById(long productId) {
        return productIdsInStock.stream()
                .filter(s -> s.getId().equals(productId))
                .findFirst()
                .orElse(null);
    }


}
