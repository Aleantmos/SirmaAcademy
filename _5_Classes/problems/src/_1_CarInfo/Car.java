package _1_CarInfo;

public class Car {
    private String brand;
    private String model;
    private int horsepower;


    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsepower = -1;
    }

    public Car(String brand, String model) {
        this(brand);
        setModel(model);
        this.horsepower = -1;
    }

    public Car(String brand, int horsepower) {
        this(brand);
        this.model = "unknown";
        setHorsepower(horsepower);
    }

    public Car(String brand, String model, int horsepower) {
        this(brand);
        setModel(model);
        setHorsepower(horsepower);
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String carInfo() {
        return String.format("The car is: %s %s – %d HP.", this.brand, this.model, this.horsepower);
    }
}
