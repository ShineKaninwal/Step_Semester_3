class M5LibraryMember {

    private static int memberCounter = 100;

    private final String memberNumber;

    protected int borrowLimit;
    protected int booksBorrowed;


    public M5LibraryMember(int borrowLimit) {

        if (borrowLimit <= 0) {
            throw new IllegalArgumentException(
                    "Borrow limit must be positive"
            );
        }


        memberCounter++;

        memberNumber =
                "LIB-" + memberCounter;


        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }


    public void borrowBook() {

        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }


    public void borrowBook(String genre) {

        // Genre is accepted/recorded conceptually,
        // then normal borrowing is performed.
        borrowBook();
    }


    public static boolean isValidRenewalCode(
            String code) {

        if (code == null || code.length() != 4) {
            return false;
        }


        if (code.charAt(0) != 'R') {
            return false;
        }


        if (!Character.isDigit(code.charAt(1))) {
            return false;
        }


        if (!Character.isDigit(code.charAt(2))) {
            return false;
        }


        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }


        return true;
    }


    public static int getMembersEnrolled() {

        return memberCounter - 100;
    }


    public String getMemberNumber() {

        return memberNumber;
    }


    public int getBooksBorrowed() {

        return booksBorrowed;
    }
}


class M5FacultyMember extends M5LibraryMember {

    private String department;


    public M5FacultyMember(
            int borrowLimit,
            String department) {

        super(borrowLimit);
        this.department = department;
    }


    public String getDepartment() {

        return department;
    }
}


public class M5_NightlyCirculationAudit {


    public static String processNightlyAudit(
            M5LibraryMember[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int faculty = 0;
        int regular = 0;


        for (M5LibraryMember member : members) {

            if (member == null) {
                nullSkipped++;
                continue;
            }


            processed++;


            if (member instanceof M5FacultyMember) {
                faculty++;
            } else {
                regular++;
            }
        }


        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + faculty + " faculty | "
                + regular + " regular";
    }


    public static void main(String[] args) {

        M5LibraryMember first =
                new M5LibraryMember(5);


        System.out.println(
                "First Member Number: "
                + first.getMemberNumber()
        );


        System.out.println(
                "Members Enrolled: "
                + M5LibraryMember.getMembersEnrolled()
        );


        System.out.println();


        System.out.println(
                "R12A: "
                + M5LibraryMember.isValidRenewalCode("R12A")
        );


        System.out.println(
                "R1A: "
                + M5LibraryMember.isValidRenewalCode("R1A")
        );


        System.out.println(
                "X12A: "
                + M5LibraryMember.isValidRenewalCode("X12A")
        );


        System.out.println();


        first.borrowBook();
        first.borrowBook("Fiction");


        System.out.println(
                "Books Borrowed: "
                + first.getBooksBorrowed()
        );


        M5FacultyMember faculty =
                new M5FacultyMember(
                        5,
                        "Physics"
                );


        M5LibraryMember regular =
                new M5LibraryMember(3);


        M5LibraryMember[] members = {
                faculty,
                null,
                regular
        };


        System.out.println(
                processNightlyAudit(members)
        );
    }
}