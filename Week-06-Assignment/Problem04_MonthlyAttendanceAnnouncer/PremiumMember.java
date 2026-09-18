public class PremiumMember extends GymMember {

    private String trainerName;

    public PremiumMember(String memberId, String name, int monthlyFee, String trainerName) {
        super(memberId, name, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    public String displayInfo() {
        return "Premium | Trainer: " + trainerName + " | Sessions: " 
                + getTotalSessionsAttended() + " [Trainer via downcast: " + trainerName + "]";
    }

    @Override
    public int getTotalSessionsAttended() {
        return 0;
    }
}
