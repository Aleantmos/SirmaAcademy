package model.items;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.enums.CategoryEnum;
import model.items.interfaces.Item;

public class AbstractProduct implements Item {
    private static Long cntId = 0l;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("cost")
    private Double cost;
    @JsonProperty("quantity")
    private Integer quantity;
    private CategoryEnum category;

    public AbstractProduct() {
    }

    public AbstractProduct(String name, Double price, Double cost, Integer quantity) {
        setId();
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.quantity = quantity;
    }

    public void setId() {
        this.id = ++cntId;
    }

    @Override
    public String getCategory() {
        return this.category.toString();
    }

    protected void setCategory(CategoryEnum category) {
        this.category = category;
    }

    @Override
    public void saveCategoryType(String Category) {
        //todo
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }



    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public double getCost() {
        return this.cost;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public double profitPerUnit() {
        return getPrice() - getCost();
    }

    @Override
    public void sell(Long cartId, Long shopId) {
        //todo
    }

    @Override
    public String toString() {
        return String.format("%s() - id: %d,price: %.2f",
                getName(), getId(), getPrice());
    }
}
