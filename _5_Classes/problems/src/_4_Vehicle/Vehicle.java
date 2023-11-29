package _4_Vehicle;

public class Vehicle {
    private String type;
    private String model;
    private Engine engine;
    private int fuel;

    public Vehicle(String type, String model, Engine engine, int fuel) {
        this.type = type;
        this.model = model;
        this.engine = engine;
        setFuel(fuel);
    }

    public void drive(int fuelLoss) {
        int currFuel = this.getFuel();
        currFuel -= fuelLoss;
        setFuel(currFuel);
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
}
