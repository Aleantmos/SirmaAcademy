package model.items.impl;

import model.enums.CategoryEnum;
import model.items.AbstractProduct;
import model.items.interfaces.Perishable;

public class Clothes extends AbstractProduct implements Perishable {
    private static final CategoryEnum CLOTHES_CATEGORY = CategoryEnum.CLOTHES;
    private boolean isPerished;
    public Clothes(String name, Double price, Double cost, Integer quantity) {
        super(name, price, cost, quantity);
        setCategory(CLOTHES_CATEGORY);
        isPerished(false);
    }

    @Override
    public boolean isPerished(boolean state) {
        return setPerished(state);
    }

    public boolean setPerished(boolean perished) {
        this.isPerished = perished;
        return perished;
    }

    @Override
    public String perish(int quantity) {
        //todo
        return null;
    }
}
