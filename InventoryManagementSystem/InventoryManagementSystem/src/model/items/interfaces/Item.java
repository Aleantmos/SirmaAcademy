package model.items.interfaces;

public interface Item extends Categorizable, Sellable {
    Long getId();
    String getName();
}
