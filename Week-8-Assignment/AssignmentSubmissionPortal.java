import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract class Assignment {
    private String title;
    private int maxMarks;
    private LocalDate dueDate;

    Assignment(String title, int maxMarks, LocalDate dueDate) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    public String getTitle() { return title; }
    public int getMaxMarks() { return maxMarks; }

    public long getLateDays(LocalDate date) {
        return Math.max(0, ChronoUnit.DAYS.between(dueDate, date));
    }

    public abstract double applyPenalty(double marks, long days);
}

class CodingAssignment extends Assignment {
    CodingAssignment(String title, int marks, LocalDate date) {
        super(title, marks, date);
    }

    public double applyPenalty(double marks, long days) {
        return Math.max(0, marks * (1 - 0.10 * days));
    }
}

class WrittenAssignment extends Assignment {
    WrittenAssignment(String title, int marks, LocalDate date) {
        super(title, marks, date);
    }

    public double applyPenalty(double marks, long days) {
        return Math.max(0, marks * (1 - 0.20 * days));
    }
}

class Student {
    private String name;

    Student(String name) { this.name = name; }
    public String getName() { return name; }
}

class Submission {
    private Student student;
    private Assignment assignment;
    private LocalDate submissionDate;
    private String status = "Submitted";

    Submission(Student student, Assignment assignment, LocalDate date) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDate = date;
    }

    public void grade(double marks) {
        if (!status.equals("Submitted")) {
            System.out.println("Cannot grade: submission is already graded.");
            return;
        }
        if (marks < 0 || marks > assignment.getMaxMarks()) {
            System.out.println("Invalid marks.");
            return;
        }

        long days = assignment.getLateDays(submissionDate);
        double finalMarks = assignment.applyPenalty(marks, days);
        status = "Graded";

        System.out.printf("%s graded: %.0f/%d", student.getName(),
                finalMarks, assignment.getMaxMarks());

        if (days > 0) {
            double rate = assignment instanceof CodingAssignment ? 10 : 20;
            System.out.printf(" after %.0f%% late penalty", days * rate);
        }
        System.out.println(". Status: " + status + ".");
    }

    public void resubmit(LocalDate date) {
        if (status.equals("Graded")) {
            System.out.println("Cannot resubmit: '" + assignment.getTitle()
                    + "' has already been graded.");
        } else {
            submissionDate = date;
            System.out.println(student.getName() + " resubmitted '"
                    + assignment.getTitle() + "'.");
        }
    }
}

public class AssignmentSubmissionPortal {
    public static void main(String[] args) {
        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Assignment coding = new CodingAssignment(
                "Linked List Lab", 50, LocalDate.of(2026, 3, 10));
        Assignment written = new WrittenAssignment(
                "Design Essay", 50, LocalDate.of(2026, 3, 12));

        Submission s1 = new Submission(
                asha, coding, LocalDate.of(2026, 3, 10));
        Submission s2 = new Submission(
                ravi, written, LocalDate.of(2026, 3, 14));

        System.out.println("Asha's submission for 'Linked List Lab' received (on time). Status: Submitted.");
        System.out.println("Ravi's submission for 'Design Essay' received (2 days late). Status: Submitted.");

        s1.grade(45);
        s2.grade(40);
        s1.resubmit(LocalDate.of(2026, 3, 11));
    }
}
