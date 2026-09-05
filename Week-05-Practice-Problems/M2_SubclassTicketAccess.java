class AccessChecker {

    static String classifyAccess(
            String fieldModifier,
            String accessorContext) {

        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }

        if (fieldModifier.equals("private")) {
            if (accessorContext.equals("SAME_CLASS")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        if (fieldModifier.equals("default")) {
            if (accessorContext.equals("SAME_CLASS") ||
                accessorContext.equals("SAME_PACKAGE")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        if (fieldModifier.equals("protected")) {

            if (accessorContext.equals("SAME_CLASS") ||
                accessorContext.equals("SAME_PACKAGE") ||
                accessorContext.equals(
                    "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {

                return "ALLOWED";
            }

            return "DENIED";
        }

        return "DENIED";
    }
}

class MovieTicket {
    protected double ticketPrice;

    MovieTicket(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}

class PremiumMovieTicket extends MovieTicket {

    PremiumMovieTicket(double ticketPrice) {
        super(ticketPrice);
    }

    void displayPrice() {
        System.out.println("Ticket Price: " + ticketPrice);
    }
}

public class M2_SubclassTicketAccess {

    public static void main(String[] args) {

        System.out.println(
            AccessChecker.classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"
            )
        );

        System.out.println(
            AccessChecker.classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"
            )
        );

        PremiumMovieTicket ticket =
            new PremiumMovieTicket(250);

        ticket.displayPrice();
    }
}