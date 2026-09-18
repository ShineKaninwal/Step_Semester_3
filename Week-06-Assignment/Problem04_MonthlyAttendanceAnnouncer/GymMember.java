public class GymMember {

    protected String memberId;
    protected String name;
    protected int monthlyFee;

    public GymMember(String memberId, String name, int monthlyFee) {
        this.memberId = memberId;
        this.name = name;
        this.monthlyFee = monthlyFee;
    }

    public String displayInfo() {
        return "Standard | Sessions: 0";
    }

    public int getTotalSessionsAttended() {
        return 0;
    }

    public static String batchPrint(GymMember[] members) {
        StringBuilder result = new StringBuilder();

        for (GymMember member : members) {
            result.append(member.displayInfo()).append(" | ");
        }

        return result.toString();
    }
}
