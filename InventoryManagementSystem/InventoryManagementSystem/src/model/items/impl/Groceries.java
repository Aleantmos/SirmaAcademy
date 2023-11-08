package model.items.impl;

import model.enums.CategoryEnum;
import model.items.AbstractProduct;
import model.items.interfaces.Perishable;


public class Groceries extends AbstractProduct implements Perishable {
    private static final CategoryEnum GROCERIES_CATEGORY = CategoryEnum.GROCERIES;
    private boolean isPerished;

    public Groceries(String name, Double price, Double cost, Integer quantity) {
        super(name, price, cost, quantity);
        setCategory(GROCERIES_CATEGORY);
        isPerished(false);
    }

    @Override
    public boolean isPerished(boolean state) {
        return setPerished(state);
    }

    public boolean setPerished(boolean perished) {
        isPerished = perished;
        return perished;
    }

    @Override
    public String perish(int quantity) {
        //todo
        return null;
    }
}
