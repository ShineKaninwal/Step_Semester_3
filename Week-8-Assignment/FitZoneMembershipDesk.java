interface MembershipPlan {
    int getMonths();
    double calculateFee();
    String getName();
}

class MonthlyPlan implements MembershipPlan {
    public int getMonths() { return 1; }
    public double calculateFee() { return 1000; }
    public String getName() { return "Monthly"; }
}

class QuarterlyPlan implements MembershipPlan {
    public int getMonths() { return 3; }
    public double calculateFee() { return 2700; }
    public String getName() { return "Quarterly"; }
}

class AnnualPlan implements MembershipPlan {
    public int getMonths() { return 12; }
    public double calculateFee() { return 9000; }
    public String getName() { return "Annual"; }
}

class Member {
    private String name;

    Member(String name) { this.name = name; }
    public String getName() { return name; }
}

class Membership {
    private Member member;
    private MembershipPlan plan;
    private String status = "Active";

    Membership(Member member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;
        System.out.printf("%s membership created for %s. Fee: ?%.2f. Status: %s.%n",
                plan.getName(), member.getName(), plan.calculateFee(), status);
    }

    public void checkIn() {
        if (status.equals("Active")) {
            System.out.println(member.getName() + " checked in successfully.");
        } else {
            System.out.println("Check-in denied: " + member.getName()
                    + "'s membership is " + status + ".");
        }
    }

    public void freeze() {
        if (status.equals("Expired")) {
            System.out.println("Cannot freeze an Expired membership.");
        } else if (status.equals("Frozen")) {
            System.out.println("Membership is already Frozen.");
        } else {
            status = "Frozen";
            System.out.println(member.getName()
                    + "'s membership frozen. Status: " + status + ".");
        }
    }

    public void unfreeze() {
        if (status.equals("Expired")) {
            System.out.println("Cannot unfreeze an Expired membership.");
        } else if (status.equals("Frozen")) {
            status = "Active";
            System.out.println(member.getName()
                    + "'s membership unfrozen. Status: " + status + ".");
        } else {
            System.out.println("Membership is already Active.");
        }
    }

    public void expire() {
        status = "Expired";
        System.out.println(member.getName()
                + "'s membership expired. Status: " + status + ".");
    }
}

public class FitZoneMembershipDesk {
    public static void main(String[] args) {
        Member asha = new Member("Asha");
        Member ravi = new Member("Ravi");

        Membership m1 = new Membership(asha, new QuarterlyPlan());
        Membership m2 = new Membership(ravi, new MonthlyPlan());

        m1.checkIn();
        m1.freeze();
        m1.checkIn();
        m2.expire();
        m2.freeze();
    }
}
