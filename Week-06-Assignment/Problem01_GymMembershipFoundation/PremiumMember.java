public class PremiumMember extends GymMember {

    public PremiumMember(String memberId, String name, int monthlyFee) {
        super(memberId, name, monthlyFee);
    }

    @Override
    public void displayInfo() {
        System.out.println("Premium Member ID: " + getMemberId());
        System.out.println("Name: " + getName());
        System.out.println("Monthly Fee: " + getMonthlyFee());
    }
}
