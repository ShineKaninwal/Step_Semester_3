public class GymMember {

    private static int nextMembershipNumber = 2001;

    private int membershipNumber;
    private int monthlyFee;
    private int feesPaid;

    public GymMember(int monthlyFee) {
        this.membershipNumber = nextMembershipNumber++;
        this.monthlyFee = monthlyFee;
        this.feesPaid = 0;
    }

    public int getMembershipNumber() {
        return membershipNumber;
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public void payFee(int amount) {
        feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        payFee(amount);
    }

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }

        if (code.charAt(0) != 'G') {
            return false;
        }

        if (!Character.isDigit(code.charAt(1)) ||
            !Character.isDigit(code.charAt(2))) {
            return false;
        }

        return Character.isUpperCase(code.charAt(3)) &&
               Character.isLetter(code.charAt(3));
    }

    public static void processWeeklyCheckIn(GymMember member) {
        if (member == null) {
            return;
        }

        if (member instanceof GroupClassMember) {
            System.out.println("Group class check-in processed.");
        } else {
            System.out.println("Regular gym check-in processed.");
        }
    }
}
