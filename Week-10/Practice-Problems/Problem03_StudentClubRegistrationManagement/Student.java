import java.util.Objects;
class Student {
    final String rollNumber;
    final String name;
    Student(String rollNumber, String name) { this.rollNumber = rollNumber; this.name = name; }
    @Override public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        return rollNumber.equals(((Student) obj).rollNumber);
    }
    @Override public int hashCode() { return Objects.hash(rollNumber); }
}
