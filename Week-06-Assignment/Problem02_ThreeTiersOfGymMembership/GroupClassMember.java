public class GroupClassMember extends GymMember {

    private String className;

    public GroupClassMember(String memberId, String name, int monthlyFee, String className) {
        super(memberId, name, monthlyFee);
        this.className = className;
    }

    @Override
    public void displayInfo() {
        System.out.println("Group Class Member - Class: " + className);
    }

    @Override
    public int getTotalSessionsAttended() {
        return 8;
    }
}
