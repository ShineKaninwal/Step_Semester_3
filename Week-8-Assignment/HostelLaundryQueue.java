interface WashType {
    int getDuration();
    double getCharge();
    String getName();
}

class QuickWash implements WashType {
    public int getDuration() { return 30; }
    public double getCharge() { return 20; }
    public String getName() { return "Quick"; }
}

class NormalWash implements WashType {
    public int getDuration() { return 45; }
    public double getCharge() { return 30; }
    public String getName() { return "Normal"; }
}

class HeavyWash implements WashType {
    public int getDuration() { return 60; }
    public double getCharge() { return 45; }
    public String getName() { return "Heavy"; }
}

class Student {
    private String name;

    Student(String name) { this.name = name; }
    public String getName() { return name; }
}

class WashCycle {
    private Student student;
    private WashType type;

    WashCycle(Student student, WashType type) {
        this.student = student;
        this.type = type;
    }
}

class WashingMachine {
    private String id;
    private WashCycle currentCycle;

    WashingMachine(String id) { this.id = id; }

    public boolean startWash(Student student, WashType type) {
        if (currentCycle != null) {
            System.out.println("Machine " + id + " is currently busy.");
            return false;
        }

        currentCycle = new WashCycle(student, type);
        System.out.printf("%s wash started on %s for %s (%d min). Charge: ?%.2f.%n",
                type.getName(), id, student.getName(),
                type.getDuration(), type.getCharge());
        return true;
    }

    public void completeWash() {
        if (currentCycle == null) {
            System.out.println(id + " has no active cycle.");
            return;
        }
        System.out.println(id + " cycle completed.");
        currentCycle = null;
        System.out.println(id + " is now free.");
    }
}

public class HostelLaundryQueue {
    public static void main(String[] args) {
        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        m1.startWash(asha, new QuickWash());
        m1.startWash(ravi, new HeavyWash());
        m2.startWash(ravi, new HeavyWash());
        m1.completeWash();
        m1.startWash(neha, new NormalWash());
    }
}
