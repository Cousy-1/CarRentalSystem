// Car.java
import java.io.*;
import java.util.*;

public class Car implements Serializable {
    private final String model;
    private final String plateNumber;
    private final double pricePerDay;
    private boolean isAvailable;

    public Car(String model, String plateNumber, double pricePerDay) {
        this.model = model;
        this.plateNumber = plateNumber;
        this.pricePerDay = pricePerDay;
        this.isAvailable = true;
    }

    public String getModel() {
        return model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return model + ", " + plateNumber + ", $" + pricePerDay + "/day" + ", Available: " + isAvailable;
    }
}



