import java.io.Serializable;
import java.time.LocalDate;

public class RentalTransaction implements Serializable {
    private final Customer customer;
    private final Car car;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final double totalPrice;

    public RentalTransaction(Customer customer, Car car, LocalDate startDate, LocalDate endDate) {
        this.customer = customer;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = car.getPricePerDay() * (endDate.toEpochDay() - startDate.toEpochDay());
    }

    @Override
    public String toString() {
        return customer + " rented " + car + " from " + startDate + " to " + endDate + " | Total: $" + totalPrice;
    }
}
