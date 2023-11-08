package model.items.impl;

import model.enums.CategoryEnum;
import model.items.AbstractProduct;
import model.items.interfaces.Breakable;

public class Appliances extends AbstractProduct implements Breakable {
    private static final CategoryEnum APPLIANCES_CATEGORY = CategoryEnum.APPLIANCES;
    private boolean isBroken;
    public Appliances(String name,
                      Double price,
                      Double cost,
                      Integer quantity) {
        super(name, price, cost, quantity);
        setCategory(APPLIANCES_CATEGORY);
        isBroken(false);
    }

    @Override
    public boolean isBroken(boolean state) {
        return setBroken(state);
    }

    public boolean setBroken(boolean broken) {
        this.isBroken = broken;
        return broken;
    }

    @Override
    public String broken(int quantity) {
        //todo
        return "";
    }
}
