import java.util.*;

abstract class Vehicle {
    private String id;
    private boolean available = true;

    Vehicle(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Each vehicle category calculates its own rental charge.
    public abstract double calculateCharge(int days);
}

class Sedan extends Vehicle {
    Sedan(String id) {
        super(id);
    }

    public double calculateCharge(int days) {
        return days * 50;
    }
}

class SUV extends Vehicle {
    SUV(String id) {
        super(id);
    }

    public double calculateCharge(int days) {
        return days * 80;
    }
}

class Truck extends Vehicle {
    Truck(String id) {
        super(id);
    }

    public double calculateCharge(int days) {
        return days * 120;
    }
}

class RentalCustomer {
    String name;

    RentalCustomer(String name) {
        this.name = name;
    }
}

class Rental {
    private Vehicle vehicle;
    private RentalCustomer customer;
    private int days;
    private boolean active = true;

    Rental(Vehicle vehicle, RentalCustomer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
    }

    public void returnVehicle() {
        if (active) {
            active = false;
            vehicle.setAvailable(true);
            System.out.println(vehicle.getId() + " returned by " + customer.name);
        }
    }
}

class RentalService {
    private List<Rental> rentals = new ArrayList<>();

    public void rentVehicle(Vehicle vehicle, RentalCustomer customer, int days) {
        if (days <= 0) {
            System.out.println("Invalid rental duration.");
            return;
        }

        if (!vehicle.isAvailable()) {
            System.out.println(vehicle.getId() + " is currently unavailable.");
            return;
        }

        vehicle.setAvailable(false);
        rentals.add(new Rental(vehicle, customer, days));

        System.out.println(vehicle.getId() + " rented successfully by " + customer.name);
        System.out.println("Rental charge: $" + vehicle.calculateCharge(days));
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        RentalService service = new RentalService();

        Vehicle sedan = new Sedan("Sedan A");
        Vehicle suv = new SUV("SUV B");

        RentalCustomer c1 = new RentalCustomer("RentalCustomer 1");
        RentalCustomer c2 = new RentalCustomer("RentalCustomer 2");
        RentalCustomer c3 = new RentalCustomer("RentalCustomer 3");

        service.rentVehicle(sedan, c1, 3);
        service.rentVehicle(sedan, c2, 2);

        // Returning the vehicle makes it available again.
        sedan.setAvailable(true);
        System.out.println("Sedan A returned by RentalCustomer 1.");

        service.rentVehicle(suv, c3, 5);
    }
}

