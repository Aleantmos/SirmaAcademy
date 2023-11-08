package model.items.interfaces;

public interface Sellable {
    double getPrice();
    double getCost();
    double profitPerUnit();
    void sell (Long cartId, Long shopId);
}
