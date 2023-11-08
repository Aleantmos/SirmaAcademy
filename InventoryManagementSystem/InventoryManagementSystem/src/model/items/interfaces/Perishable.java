package model.items.interfaces;

public interface Perishable {
    boolean isPerished(boolean state);
    String perish(int quantity);

}
