class FeeAccount {

    String regNo;
    double totalFee;

    // Constructor
    FeeAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    // final prevents this method from being overridden
    final double calculateLateFee(int daysLate) {
        return totalFee * 0.01 * daysLate;
    }

    // Print fee details or skip on-time accounts
    final void printSummary(int daysLate) {

        if (daysLate <= 0) {
            System.out.println(
                regNo + " - On time, no late fee"
            );
        } else {

            double lateFee = calculateLateFee(daysLate);

            System.out.println(
                regNo + " | Total Fee: Rs " + totalFee +
                " | Late Fee: Rs " + lateFee
            );
        }
    }
}

public class M3_LateFees {

    public static void main(String[] args) {

        String[] regNos = {
            "RA001",
            "RA002",
            "RA003",
            "RA004"
        };

        double[] totalFees = {
            200000,
            150000,
            180000,
            220000
        };

        int[] daysLate = {
            10,
            0,
            -2,
            5
        };

        // Process every account in one pass
        for (int i = 0; i < regNos.length; i++) {

            FeeAccount account =
                new FeeAccount(regNos[i], totalFees[i]);

            account.printSummary(daysLate[i]);
        }
    }
}