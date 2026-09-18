import java.util.Arrays;

public class PremiumMember extends GymMember {

    private int[] lateFeeHistory = new int[10];
    private int lateFeeCount = 0;

    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);

        if (lateFeeCount < 10) {
            lateFeeHistory[lateFeeCount++] = amount / 2;
        }
    }

    public int[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, lateFeeCount);
    }
}
