class CineScreen {

    private int seatsTotal;
    private int seatsAvailable;

    CineScreen(int seatsTotal) {

        if (seatsTotal <= 0) {
            throw new IllegalArgumentException(
                "Invalid number of seats"
            );
        }

        this.seatsTotal = seatsTotal;
        this.seatsAvailable = seatsTotal;
    }

    void bookSeat() {

        if (seatsAvailable > 0) {
            seatsAvailable--;
        }
    }

    void cancelBooking() {

        if (seatsAvailable < seatsTotal) {
            seatsAvailable++;
        }
    }

    int getSeatsAvailable() {
        return seatsAvailable;
    }
}

public class M3_SeatBookingEncapsulation {

    public static void main(String[] args) {

        try {

            CineScreen c = new CineScreen(2);

            c.bookSeat();
            c.bookSeat();
            c.bookSeat();

            System.out.println(
                c.getSeatsAvailable()
            );

            c.cancelBooking();
            c.cancelBooking();
            c.cancelBooking();

            System.out.println(
                c.getSeatsAvailable()
            );

        } catch (IllegalArgumentException e) {

            System.out.println("Construction rejected");
        }
    }
}