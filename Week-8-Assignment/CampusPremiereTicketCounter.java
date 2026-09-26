import java.util.*;

abstract class Seat {
    private String seatId;

    Seat(String id) { seatId = id; }
    public String getSeatId() { return seatId; }
    public abstract double getPrice();
}

class RegularSeat extends Seat {
    RegularSeat(String id) { super(id); }
    public double getPrice() { return 150; }
}

class PremiumSeat extends Seat {
    PremiumSeat(String id) { super(id); }
    public double getPrice() { return 250; }
}

class ReclinerSeat extends Seat {
    ReclinerSeat(String id) { super(id); }
    public double getPrice() { return 400; }
}

class Customer {
    private String name;

    Customer(String name) { this.name = name; }
    public String getName() { return name; }
}

class Show {
    private String time;
    private boolean started = false;
    private Set<String> bookedSeats = new HashSet<>();

    Show(String time) { this.time = time; }

    public boolean isAvailable(Seat seat) {
        return !bookedSeats.contains(seat.getSeatId());
    }

    public boolean reserve(List<Seat> seats) {
        for (Seat seat : seats) {
            if (!isAvailable(seat)) {
                System.out.println("Seat " + seat.getSeatId()
                        + " is already booked for this show.");
                return false;
            }
        }
        for (Seat seat : seats) bookedSeats.add(seat.getSeatId());
        return true;
    }

    public void release(List<Seat> seats) {
        for (Seat seat : seats) bookedSeats.remove(seat.getSeatId());
    }

    public boolean hasStarted() { return started; }
    public void startShow() { started = true; }
}

class Booking {
    private Customer customer;
    private Show show;
    private List<Seat> seats;
    private boolean cancelled = false;

    Booking(Customer customer, Show show, List<Seat> seats) {
        this.customer = customer;
        this.show = show;
        this.seats = new ArrayList<>(seats);
    }

    public double getTotal() {
        double total = 0;
        for (Seat seat : seats) total += seat.getPrice();
        return total;
    }

    public void cancel() {
        if (cancelled) {
            System.out.println("Booking is already cancelled.");
        } else if (show.hasStarted()) {
            System.out.println("Cannot cancel: show has already started.");
        } else {
            show.release(seats);
            cancelled = true;
            System.out.println(customer.getName() + "'s booking cancelled.");
            List<String> names = new ArrayList<>();
            for (Seat seat : seats) names.add(seat.getSeatId());
            System.out.println("Seats " + String.join(", ", names) + " released.");
        }
    }
}

public class CampusPremiereTicketCounter {
    static Booking book(Customer customer, Show show, Seat... seats) {
        if (seats.length < 1 || seats.length > 6) {
            System.out.println("A booking must contain 1 to 6 seats.");
            return null;
        }

        List<Seat> selected = Arrays.asList(seats);
        Set<String> ids = new HashSet<>();
        for (Seat seat : selected) {
            if (!ids.add(seat.getSeatId())) {
                System.out.println("Duplicate seats in booking.");
                return null;
            }
        }

        if (!show.reserve(selected)) return null;

        Booking booking = new Booking(customer, show, selected);
        List<String> names = new ArrayList<>();
        for (Seat seat : selected) names.add(seat.getSeatId());

        System.out.printf("Booking confirmed for %s: %s. Total: ?%.2f.%n",
                customer.getName(), String.join(", ", names),
                booking.getTotal());
        return booking;
    }

    public static void main(String[] args) {
        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer neha = new Customer("Neha");
        Show show = new Show("7 PM");

        Booking b1 = book(asha, show, new RegularSeat("A1"),
                new RegularSeat("A2"), new PremiumSeat("F5"));
        book(ravi, show, new RegularSeat("A2"));
        book(ravi, show, new ReclinerSeat("R1"));
        b1.cancel();
        book(neha, show, new RegularSeat("A2"));
    }
}
