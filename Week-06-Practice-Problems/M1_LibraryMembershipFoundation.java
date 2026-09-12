class M1LibraryMember {
    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    public M1LibraryMember(String memberId, int borrowLimit) {

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
}


class M1StudentMember extends M1LibraryMember {

    private String course;

    public M1StudentMember(
            String memberId,
            int borrowLimit,
            String course) {

        super(memberId, borrowLimit);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }
}


public class M1_LibraryMembershipFoundation {

    public static String enrollBatch(
            String[] memberIds,
            int borrowLimit) {

        int enrolled = 0;
        int rejected = 0;

        for (String memberId : memberIds) {

            try {
                new M1LibraryMember(memberId, borrowLimit);
                enrolled++;

            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Enrolled: " + enrolled
                + " | Rejected: " + rejected;
    }


    public static void main(String[] args) {

        try {
            new M1LibraryMember("LB1", 3);

        } catch (IllegalArgumentException e) {
            System.out.println(
                    "Rejected: " + e.getMessage()
            );
        }


        M1StudentMember student =
                new M1StudentMember(
                        "STU10",
                        3,
                        "CSE"
                );

        student.borrowBook();
        student.borrowBook();

        System.out.println(
                "Books Borrowed: "
                + student.getBooksBorrowed()
        );


        String[] memberIds = {
                "STU1",
                "LB1",
                "STU2",
                " ",
                "STU3"
        };

        System.out.println(
                enrollBatch(memberIds, 3)
        );
    }
}