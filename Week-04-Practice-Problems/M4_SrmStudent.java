class SrmStudent {

    static String collegeName;
    static String academicYear;

    // Static block executes only once
    static {
        collegeName = "SRM Institute of Science and Technology";
        academicYear = "2026-27";

        System.out.println("College info loaded");
    }

    String name;

    // Constructor for student record
    SrmStudent(String name) {
        this.name = name;

        System.out.println(
            "Student record created: " + name
        );
    }
}

public class M4_SrmStudent {

    public static void main(String[] args) {

        String[] names = {
            "Ravi",
            "Meera",
            "Karthik",
            "Divya",
            "Anitha"
        };

        // Create multiple student objects
        for (int i = 0; i < names.length; i++) {
            new SrmStudent(names[i]);
        }
    }
}