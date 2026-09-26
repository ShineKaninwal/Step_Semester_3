import java.time.LocalDate;

abstract class LeaveEmployee {
    protected String name;

    LeaveEmployee(String name) {
        this.name = name;
    }

    // Subclasses define their own leave policy.
    public abstract boolean isLeaveAllowed(int days);
}

class FullTimeEmployee extends LeaveEmployee {
    FullTimeEmployee(String name) {
        super(name);
    }

    public boolean isLeaveAllowed(int days) {
        return days > 0 && days <= 30;
    }
}

class PartTimeEmployee extends LeaveEmployee {
    PartTimeEmployee(String name) {
        super(name);
    }

    public boolean isLeaveAllowed(int days) {
        return days > 0 && days <= 10;
    }
}

class Contractor extends LeaveEmployee {
    Contractor(String name) {
        super(name);
    }

    public boolean isLeaveAllowed(int days) {
        return days > 0 && days <= 5;
    }
}

class LeaveRequest {
    private LeaveEmployee employee;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status = "Pending";

    LeaveRequest(LeaveEmployee employee, LocalDate start, LocalDate end) {
        this.employee = employee;
        this.startDate = start;
        this.endDate = end;
    }

    public void review(String decision, String reviewer) {
        if (!status.equals("Pending")) {
            System.out.println("Cannot change leave request status from " + status + " to " + decision + ".");
            return;
        }

        if (!decision.equals("Approved") && !decision.equals("Rejected")) {
            System.out.println("Invalid decision.");
            return;
        }

        int days = (int) (endDate.toEpochDay() - startDate.toEpochDay() + 1);

        if (decision.equals("Approved") && !employee.isLeaveAllowed(days)) {
            System.out.println("Leave policy does not allow this request.");
            return;
        }

        status = decision;
        System.out.println(employee.name + "'s leave request (" + startDate + " to " +
                endDate + ") " + decision.toLowerCase() + " by " + reviewer + ".");
        System.out.println("Status: " + status);
    }

    public String getStatus() {
        return status;
    }
}

public class EmployeeLeaveWorkflow {
    public static void main(String[] args) {
        LeaveEmployee john = new FullTimeEmployee("John");
        LeaveEmployee jane = new PartTimeEmployee("Jane");

        LeaveRequest r1 = new LeaveRequest(john,
                LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 5));
        System.out.println("Leave request submitted for John. Status: Pending.");
        r1.review("Approved", "Alice");
        r1.review("Pending", "John");

        LeaveRequest r2 = new LeaveRequest(jane,
                LocalDate.of(2026, 2, 10), LocalDate.of(2026, 2, 11));
        System.out.println("Leave request submitted for Jane. Status: Pending.");
        r2.review("Rejected", "Bob");
    }
}

