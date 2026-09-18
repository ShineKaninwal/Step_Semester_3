public class GymMember {
    private String memberId;
    private String name;
    private int monthlyFee;

    public GymMember(String memberId, String name, int monthlyFee) {
        this.memberId = memberId;
        this.name = name;
        this.monthlyFee = monthlyFee;
    }

    public void displayInfo() {
        System.out.println("Standard Member: " + name);
    }

    public int getTotalSessionsAttended() {
        return 0;
    }

    public static String classifyGeneration(int age) {
        if (age >= 60) {
            return "Senior";
        } else if (age >= 30) {
            return "Adult";
        } else {
            return "Young";
        }
    }
}
