class M2LibraryMember {

    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    public M2LibraryMember(
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

        return "General Member | Books Borrowed: "
                + booksBorrowed;
    }
}


class M2StudentMember extends M2LibraryMember {

    protected String course;

    public M2StudentMember(
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

        return "Student Member | Course: "
                + course
                + " | Books Borrowed: "
                + booksBorrowed;
    }
}


class M2HonorsStudentMember extends M2StudentMember {

    private int bonusLimit;

    public M2HonorsStudentMember(
            String memberId,
            int borrowLimit,
            String course,
            int bonusLimit) {

        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }


    @Override
    public String displayInfo() {

        return "Honors Student Member | Course: "
                + course
                + " | Bonus Limit: "
                + bonusLimit
                + " | Books Borrowed: "
                + booksBorrowed;
    }
}


class M2FacultyMember extends M2LibraryMember {

    private String department;

    public M2FacultyMember(
            String memberId,
            int borrowLimit,
            String department) {

        super(memberId, borrowLimit);
        this.department = department;
    }


    @Override
    public String displayInfo() {

        return "Faculty Member | Department: "
                + department
                + " | Books Borrowed: "
                + booksBorrowed;
    }
}


public class M2_MembershipTree {


    public static String classifyGeneration(
            M2LibraryMember member) {

        if (member instanceof M2HonorsStudentMember) {

            return "Multilevel descendant (3 generations deep)";
        }

        if (member instanceof M2FacultyMember) {

            return "Hierarchical sibling (independent branch)";
        }

        return "General member";
    }


    public static int getTotalBooksBorrowed(
            M2LibraryMember[] members) {

        int total = 0;

        for (M2LibraryMember member : members) {
            total += member.getBooksBorrowed();
        }

        return total;
    }


    public static void main(String[] args) {

        M2LibraryMember general =
                new M2LibraryMember(
                        "GEN1",
                        5
                );


        M2StudentMember student =
                new M2StudentMember(
                        "STU1",
                        5,
                        "CSE"
                );


        M2HonorsStudentMember honors =
                new M2HonorsStudentMember(
                        "HON1",
                        5,
                        "ECE",
                        2
                );


        M2FacultyMember faculty =
                new M2FacultyMember(
                        "FAC1",
                        5,
                        "Physics"
                );


        System.out.println(
                general.displayInfo()
        );

        System.out.println(
                student.displayInfo()
        );

        System.out.println(
                honors.displayInfo()
        );

        System.out.println(
                faculty.displayInfo()
        );


        System.out.println();


        System.out.println(
                classifyGeneration(honors)
        );

        System.out.println(
                classifyGeneration(faculty)
        );


        student.borrowBook();
        student.borrowBook();

        honors.borrowBook();

        faculty.borrowBook();
        faculty.borrowBook();
        faculty.borrowBook();


        M2LibraryMember[] members = {
                student,
                honors,
                faculty
        };


        System.out.println(
                "Total Books Borrowed: "
                + getTotalBooksBorrowed(members)
        );
    }
}