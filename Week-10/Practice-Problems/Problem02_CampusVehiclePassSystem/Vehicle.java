abstract class Vehicle {
    final String passNumber;
    final String owner;
    Vehicle(String passNumber, String owner) { this.passNumber = passNumber; this.owner = owner; }
    abstract int passFee();
    abstract String type();
}
