package model.carts;

import model.items.AbstractProduct;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static Long idCnt = 0L;
    private Long cartId;
    private Long userId;
    private Double budget;
    private List<AbstractProduct> itemsAdded;

    public Cart() {
    }

    public Cart(Long userId) {
        setCartId();
        this.userId = userId;
        this.budget = 0.0;
        this.itemsAdded = new ArrayList<>();
    }

    public Long getCartId() {
        return cartId;
    }

    private void setCartId() {
        this.cartId = ++idCnt;
    }

    public Long getUserId() {
        return userId;
    }

    private void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getBudget() {
        return budget;
    }

    private void setBudget(Double budget) {
        this.budget = budget;
    }

    public List<AbstractProduct> getItemsAdded() {
        return itemsAdded;
    }

    private void setItemsAdded(List<AbstractProduct> itemsAdded) {
        this.itemsAdded = itemsAdded;
    }
}
