public class GymMember {
    private String memberId;
    private String name;
    private int monthlyFee;

    public GymMember(String memberId, String name, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("Invalid memberId");
        }

        if (monthlyFee <= 0) {
            throw new IllegalArgumentException("Monthly fee must be positive");
        }

        this.memberId = memberId;
        this.name = name;
        this.monthlyFee = monthlyFee;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public void displayInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + name);
        System.out.println("Monthly Fee: " + monthlyFee);
    }

    public boolean signUpBatch(String[] memberIds) {
        boolean allValid = true;

        for (String id : memberIds) {
            try {
                new GymMember(id, "Batch Member", monthlyFee);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid member ID: " + id);
                allValid = false;
            }
        }

        return allValid;
    }
}
