public class GymMember {

    protected int lateFee;

    public GymMember() {
        lateFee = 0;
    }

    protected void chargeLateFee(int amount) {
        lateFee += amount;
    }

    public int getLateFee() {
        return lateFee;
    }
}
