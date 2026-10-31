import java.util.*;
public class StudentClubRegistrationManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Student> members = new HashSet<>();
        List<Student> checks = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] p = line.split("\s+", 3);
            if (p.length < 3) continue;
            Student student = new Student(p[1], p[2]);
            if (p[0].equalsIgnoreCase("ADD"))
                System.out.println(members.add(student) ? "Added" : "duplicate rejected");
            else if (p[0].equalsIgnoreCase("CONTAINS")) checks.add(student);
        }
        System.out.println("member count " + members.size());
        for (Student student : checks) System.out.println("contains: " + members.contains(student));
    }
}
