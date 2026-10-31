class Bike extends Vehicle {
    Bike(String passNumber, String owner) { super(passNumber, owner); }
    @Override int passFee() { return 300; }
    @Override String type() { return "Bike"; }
}
