class Payment {

    // Normal payment
    void pay(double amount) {
        System.out.println(
            "Paid (cash): Rs " + amount
        );
    }
}

class CardPayment extends Payment {

    // Card payment with 2% processing fee
    void payWithProcessingFee(double amount) {

        double total = amount + (amount * 0.02);

        System.out.println(
            "Charged (card, incl. fee): Rs " + total
        );
    }
}

class PaymentProcessor {

    double totalCollected = 0;

    // Process payment according to its type
    void processTransaction(
        Payment payment,
        double amount
    ) {

        if (payment instanceof CardPayment) {

            CardPayment card =
                (CardPayment) payment;

            card.payWithProcessingFee(amount);

            totalCollected =
                totalCollected + amount +
                (amount * 0.02);

        } else {

            payment.pay(amount);

            totalCollected =
                totalCollected + amount;
        }
    }
}

public class A5_CanteenPayments {

    public static void main(String[] args) {

        Payment[] payments = {
            new CardPayment(),
            new Payment(),
            new CardPayment(),
            new Payment(),
            new CardPayment()
        };

        double[] amounts = {
            100,
            50,
            200,
            75,
            120
        };

        PaymentProcessor processor =
            new PaymentProcessor();

        // Process all transactions in one pass
        for (int i = 0; i < payments.length; i++) {

            processor.processTransaction(
                payments[i],
                amounts[i]
            );
        }

        System.out.println(
            "Total Collected: Rs " +
            processor.totalCollected
        );
    }
}