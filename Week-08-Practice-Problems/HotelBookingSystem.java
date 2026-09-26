import java.time.LocalDate;
import java.util.*;

abstract class Room {
    protected String roomNumber;

    Room(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public abstract double calculatePrice(long nights);
}

class StandardRoom extends Room {
    StandardRoom(String number) {
        super(number);
    }

    public double calculatePrice(long nights) {
        return nights * 100;
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(String number) {
        super(number);
    }

    public double calculatePrice(long nights) {
        return nights * 180;
    }
}

class Suite extends Room {
    Suite(String number) {
        super(number);
    }

    public double calculatePrice(long nights) {
        return nights * 300;
    }
}

class HotelCustomer {
    String name;

    HotelCustomer(String name) {
        this.name = name;
    }
}

class Reservation {
    private HotelCustomer customer;
    private Room room;
    private LocalDate start;
    private LocalDate end;
    private LocalDate cancellationDeadline;
    private boolean active = true;

    Reservation(HotelCustomer customer, Room room, LocalDate start,
                LocalDate end, LocalDate deadline) {
        this.customer = customer;
        this.room = room;
        this.start = start;
        this.end = end;
        this.cancellationDeadline = deadline;
    }

    public boolean overlaps(LocalDate from, LocalDate to) {
        return active && start.isBefore(to) && from.isBefore(end);
    }

    public void cancel(LocalDate today) {
        if (!active) {
            System.out.println("Reservation is already inactive.");
        } else if (today.isAfter(cancellationDeadline)) {
            System.out.println("Cancellation deadline has passed.");
        } else {
            active = false;
            System.out.println("Reservation for " + customer.name + ", " +
                    room.getRoomNumber() + " cancelled successfully.");
        }
    }

    public boolean isActive() {
        return active;
    }
}

class Hotel {
    private List<Reservation> reservations = new ArrayList<>();

    public boolean isAvailable(Room room, LocalDate start, LocalDate end) {
        if (!start.isBefore(end)) {
            return false;
        }

        for (Reservation r : reservations) {
            if (r.isActive() &&
                r.overlaps(start, end) &&
                rRoomMatches(r, room)) {
                return false;
            }
        }
        return true;
    }

    // Match rooms by their unique room number.
    private boolean rRoomMatches(Reservation reservation, Room room) {
        try {
            java.lang.reflect.Field field =
                    Reservation.class.getDeclaredField("room");
            field.setAccessible(true);
            Room bookedRoom = (Room) field.get(reservation);
            return bookedRoom.getRoomNumber().equals(room.getRoomNumber());
        } catch (Exception e) {
            return false;
        }
    }

    public void book(HotelCustomer customer, Room room, LocalDate start,
                     LocalDate end, LocalDate deadline) {
        if (!isAvailable(room, start, end)) {
            System.out.println(room.getRoomNumber() + " is not available.");
            return;
        }

        long nights = java.time.temporal.ChronoUnit.DAYS.between(start, end);
        if (nights <= 0) {
            System.out.println("Invalid reservation dates.");
            return;
        }

        reservations.add(new Reservation(customer, room, start, end, deadline));
        System.out.println("Reservation confirmed for " + customer.name +
                ", " + room.getRoomNumber() + " (" + start + " to " + end + ").");
        System.out.println("Price: $" + room.calculatePrice(nights));
    }
}

public class HotelBookingSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        HotelCustomer a = new HotelCustomer("HotelCustomer A");
        HotelCustomer b = new HotelCustomer("HotelCustomer B");
        HotelCustomer c = new HotelCustomer("HotelCustomer C");

        Room standard = new StandardRoom("101");
        Room deluxe = new DeluxeRoom("201");

        LocalDate start = LocalDate.of(2026, 1, 1);
        LocalDate end = LocalDate.of(2026, 1, 5);

        System.out.println("Standard Room 101 is " +
                (hotel.isAvailable(standard, start, end) ? "available" : "not available") + ".");

        hotel.book(a, standard, start, end, LocalDate.of(2025, 12, 25));
        hotel.book(b, standard, LocalDate.of(2026, 1, 3),
                LocalDate.of(2026, 1, 7), LocalDate.of(2025, 12, 25));

        // Demonstration cancellation date is before the deadline.
        // In a real application, the Reservation would be retrieved by ID.
        hotel.book(c, deluxe, LocalDate.of(2026, 2, 10),
                LocalDate.of(2026, 2, 12), LocalDate.of(2026, 2, 1));
    }
}

