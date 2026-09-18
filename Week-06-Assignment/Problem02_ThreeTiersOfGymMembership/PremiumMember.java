public class PremiumMember extends GymMember {

    private String trainerName;

    public PremiumMember(String memberId, String name, int monthlyFee, String trainerName) {
        super(memberId, name, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    public void displayInfo() {
        System.out.println("Premium Member - Trainer: " + trainerName);
    }

    @Override
    public int getTotalSessionsAttended() {
        return 10;
    }
}
