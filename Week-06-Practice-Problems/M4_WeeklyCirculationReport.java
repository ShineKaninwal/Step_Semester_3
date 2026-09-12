class M4LibraryMember {

    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;


    public M4LibraryMember(
            String memberId,
            int borrowLimit) {

        if (memberId == null || memberId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Member ID cannot be blank"
            );
        }

        if (memberId.trim().length() < 4) {
            throw new IllegalArgumentException(
                    "Member ID must contain at least 4 characters"
            );
        }

        if (borrowLimit <= 0) {
            throw new IllegalArgumentException(
                    "Borrow limit must be positive"
            );
        }

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }


    public void borrowBook() {

        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }


    public int getBooksBorrowed() {
        return booksBorrowed;
    }


    public String displayInfo() {

        return "General | Books: "
                + booksBorrowed;
    }
}


class M4StudentMember extends M4LibraryMember {

    private String course;


    public M4StudentMember(
            String memberId,
            int borrowLimit,
            String course) {

        super(memberId, borrowLimit);
        this.course = course;
    }


    public String getCourse() {
        return course;
    }


    @Override
    public String displayInfo() {

        return "Student | Course: "
                + course
                + " | Books: "
                + booksBorrowed;
    }
}


public class M4_WeeklyCirculationReport {


    public static String batchPrint(
            M4LibraryMember[] members) {

        StringBuilder report =
                new StringBuilder();


        for (M4LibraryMember member : members) {

            report.append(
                    member.displayInfo()
            );


            if (member instanceof M4StudentMember) {

                M4StudentMember student =
                        (M4StudentMember) member;

                report.append(
                        " [Course via downcast: "
                );

                report.append(
                        student.getCourse()
                );

                report.append("]");
            }


            report.append(" | ");
        }


        return report.toString();
    }


    public static void main(String[] args) {

        M4LibraryMember general =
                new M4LibraryMember(
                        "LB5",
                        3
                );


        M4StudentMember student =
                new M4StudentMember(
                        "STU6",
                        3,
                        "ECE"
                );


        M4LibraryMember[] members = {
                general,
                student
        };


        System.out.println(
                batchPrint(members)
        );


        // Demonstrating an unsafe downcast
        try {

            M4StudentMember bad =
                    (M4StudentMember) general;

        } catch (ClassCastException e) {

            System.out.println(
                    "ClassCastException: Invalid downcast"
            );
        }
    }
}