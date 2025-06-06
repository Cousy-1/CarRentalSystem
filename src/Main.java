public class Main {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();

        // Add cars
        agency.addCar(new Car("Toyota Corolla", "KDA123A", 30));
        agency.addCar(new Car("Mazda Demio", "KDA456B", 25));

        // Add customer
        agency.addCustomer(new Customer("Cousin Alukwe", "DL-00123"));

        // List available cars
        System.out.println("Available Cars:");
        for (Car car : agency.getCars()) {
            System.out.println(car);
        }

        // Rent a car
        System.out.println("\nRenting Car:");
        boolean success = agency.rentCar("KDA123A", "DL-00123");
        System.out.println(success ? "Rental successful!" : "Rental failed.");

        // List cars after renting
        System.out.println("\nUpdated Car List:");
        for (Car car : agency.getCars()) {
            System.out.println(car);
        }
    }
}

