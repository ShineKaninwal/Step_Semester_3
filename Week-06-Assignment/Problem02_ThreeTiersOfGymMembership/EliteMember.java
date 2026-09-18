public class EliteMember extends GymMember {

    private int sessions;

    public EliteMember(String memberId, String name, int monthlyFee, int sessions) {
        super(memberId, name, monthlyFee);
        this.sessions = sessions;
    }

    @Override
    public void displayInfo() {
        System.out.println("Elite Member - Sessions: " + sessions);
    }

    @Override
    public int getTotalSessionsAttended() {
        return sessions;
    }
}
