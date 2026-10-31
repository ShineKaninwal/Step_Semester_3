class Car extends Vehicle {
    Car(String passNumber, String owner) { super(passNumber, owner); }
    @Override int passFee() { return 1000; }
    @Override String type() { return "Car"; }
}
