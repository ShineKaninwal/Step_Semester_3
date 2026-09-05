public class M5_AccountPayments {

    public static void main(String[] args) {

        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        PaymentProcessor processor =
            new PaymentProcessor();

        for (int i = 0; i < accounts.length; i++) {
            processor.processPayment(accounts[i], 60000);
        }

        processor.printCounts();
    }
}

class FeeAccount {
}

class HostelFeeAccount extends FeeAccount {
}

class PaymentProcessor {

    int hostelCount = 0;
    int dayScholarCount = 0;

    void processPayment(FeeAccount account, double amount) {

        if (account instanceof HostelFeeAccount) {
            System.out.println(
                "Paid in two installments (hostel account)"
            );
            hostelCount++;
        } else {
            System.out.println(
                "Paid in one go (day-scholar account)"
            );
            dayScholarCount++;
        }
    }

    void printCounts() {
        System.out.println(
            "Hostel accounts processed: " + hostelCount +
            " | Day-scholar accounts processed: " +
            dayScholarCount
        );
    }
}