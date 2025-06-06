import java.io.*;
import java.util.*;

public class RentalAgency {
    private final List<Car> cars;
    private final List<Customer> customers;
    private final Map<String, String> rentals; // plate -> customerId

    public RentalAgency() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new HashMap<>();
    }

    public void addCar(Car car) {
        cars.add(car);
        System.out.println(" Car added: " + car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println(" Customer added: " + customer);
    }

    public boolean rentCar(String plateNumber, String customerId) {
        for (Car car : cars) {
            if (car.getPlateNumber().equalsIgnoreCase(plateNumber) && car.isAvailable()) {
                car.setAvailable(false);
                rentals.put(plateNumber, customerId);
                return true;
            }
        }
        return false;
    }

    public boolean returnCar(String plateNumber) {
        for (Car car : cars) {
            if (car.getPlateNumber().equalsIgnoreCase(plateNumber) && !car.isAvailable()) {
                car.setAvailable(true);
                rentals.remove(plateNumber);
                return true;
            }
        }
        return false;
    }




    public void showAllRentals() {
        if (rentals.isEmpty()) {
            System.out.println("No rentals found.");
            return;
        }

        for (Map.Entry<String, String> entry : rentals.entrySet()) {
            String plateNumber = entry.getKey();
            String customerId = entry.getValue();
            Car rentedCar = findCarByPlate(plateNumber);
            Customer rentingCustomer = findCustomerById(customerId);

            if (rentedCar != null && rentingCustomer != null) {
                System.out.println("📋 " + rentedCar.getModel() + " (" + plateNumber + ") is rented by " +
                        rentingCustomer.getName() + " (" + customerId + ")");
            }
        }
    }

    private Car findCarByPlate(String plateNumber) {
        for (Car car : cars) {
            if (car.getPlateNumber().equalsIgnoreCase(plateNumber)) {
                return car;
            }
        }
        return null;
    }

    private Customer findCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equalsIgnoreCase(id)) {
                return customer;
            }
        }
        return null;
    }

    public Car[] getCars() {
        return cars.toArray(new Car[0]);
    }
}
