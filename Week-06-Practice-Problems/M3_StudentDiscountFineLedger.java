import java.util.Arrays;


class M3LibraryMember {

    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    private int[] fineHistory;
    private int fineCount;


    public M3LibraryMember(
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

        fineHistory = new int[10];
        fineCount = 0;
    }


    public void borrowBook() {

        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }


    public int getBooksBorrowed() {
        return booksBorrowed;
    }


    protected void chargeFine(int amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Fine amount must be positive"
            );
        }

        if (fineCount < 10) {
            fineHistory[fineCount] = amount;
            fineCount++;
        }
    }


    public int[] getFineHistory() {

        return Arrays.copyOf(
                fineHistory,
                fineCount
        );
    }


    public int getTotalFine() {

        int total = 0;

        for (int i = 0; i < fineCount; i++) {
            total += fineHistory[i];
        }

        return total;
    }
}


class M3StudentMember extends M3LibraryMember {

    private String course;


    public M3StudentMember(
            String memberId,
            int borrowLimit,
            String course) {

        super(memberId, borrowLimit);
        this.course = course;
    }


    @Override
    protected void chargeFine(int amount) {

        int discountedAmount = amount / 2;

        super.chargeFine(discountedAmount);
    }
}


public class M3_StudentDiscountFineLedger {


    public static void main(String[] args) {

        M3LibraryMember member =
                new M3LibraryMember(
                        "LIB1",
                        3
                );


        member.chargeFine(100);

        System.out.println(
                "Library Member Total Fine: "
                + member.getTotalFine()
        );


        M3StudentMember student =
                new M3StudentMember(
                        "STU1",
                        3,
                        "CSE"
                );


        student.chargeFine(100);

        System.out.println(
                "Student Total Fine: "
                + student.getTotalFine()
        );


        int[] history =
                student.getFineHistory();

        System.out.println(
                "Fine History: "
                + Arrays.toString(history)
        );


        history[0] = 9999;


        System.out.println(
                "After External Modification: "
                + Arrays.toString(history)
        );


        System.out.println(
                "Actual Fine History: "
                + Arrays.toString(
                        student.getFineHistory()
                )
        );


        System.out.println(
                "Actual Total Fine: "
                + student.getTotalFine()
        );
    }
}