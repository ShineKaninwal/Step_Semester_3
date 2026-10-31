abstract class Staff {
    final String name;
    Staff(String name) { this.name = name; }
    abstract long calculatePay();
    abstract String type();
}
