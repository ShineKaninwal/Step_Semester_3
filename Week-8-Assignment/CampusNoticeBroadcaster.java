import java.util.*;

interface NotificationChannel {
    void send(String studentName, String title);
}

class EmailChannel implements NotificationChannel {
    public void send(String name, String title) {
        System.out.println("[Email ? " + name + "] " + title);
    }
}

class SmsChannel implements NotificationChannel {
    public void send(String name, String title) {
        System.out.println("[SMS ? " + name + "] " + title);
    }
}

class AppChannel implements NotificationChannel {
    public void send(String name, String title) {
        System.out.println("[App ? " + name + "] " + title);
    }
}

class Student {
    private String name;
    private String department;
    private List<NotificationChannel> channels;

    Student(String name, String department,
            List<NotificationChannel> channels) {
        this.name = name;
        this.department = department;
        this.channels = new ArrayList<>(channels);
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }

    public List<NotificationChannel> getChannels() {
        return Collections.unmodifiableList(channels);
    }
}

class Notice {
    private String title;
    private Set<String> departments;

    Notice(String title, Set<String> departments) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Notice title is required.");
        }
        if (departments == null || departments.isEmpty()) {
            throw new IllegalArgumentException(
                    "At least one target department is required.");
        }
        this.title = title;
        this.departments = new LinkedHashSet<>(departments);
    }

    public String getTitle() { return title; }

    public Set<String> getDepartments() {
        return Collections.unmodifiableSet(departments);
    }
}

class NoticeBoard {
    private List<Student> students = new ArrayList<>();

    public void registerStudent(Student student) {
        students.add(student);
    }

    public void postNotice(String title, Set<String> departments) {
        Notice notice;
        try {
            notice = new Notice(title, departments);
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot post notice: " + e.getMessage());
            return;
        }

        System.out.println("Notice '" + notice.getTitle()
                + "' posted to " + String.join(", ", notice.getDepartments()) + ".");

        for (Student student : students) {
            if (notice.getDepartments().contains(student.getDepartment())) {
                for (NotificationChannel channel : student.getChannels()) {
                    channel.send(student.getName(), notice.getTitle());
                }
            }
        }
    }
}

public class CampusNoticeBroadcaster {
    public static void main(String[] args) {
        NoticeBoard board = new NoticeBoard();

        Student asha = new Student("Asha", "CSE",
                Arrays.asList(new EmailChannel(), new AppChannel()));
        Student ravi = new Student("Ravi", "ECE",
                Arrays.asList(new SmsChannel()));

        board.registerStudent(asha);
        board.registerStudent(ravi);

        board.postNotice("Lab Closed Tomorrow",
                new LinkedHashSet<>(Arrays.asList("CSE")));

        board.postNotice("Fee Deadline Extended",
                new LinkedHashSet<>(Arrays.asList("CSE", "ECE")));

        board.postNotice("Sports Day", new LinkedHashSet<>());
    }
}
