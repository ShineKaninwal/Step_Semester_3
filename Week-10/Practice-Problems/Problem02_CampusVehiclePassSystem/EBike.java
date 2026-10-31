class EBike extends Vehicle implements Chargeable {
    EBike(String passNumber, String owner) { super(passNumber, owner); }
    @Override int passFee() { return 300; }
    @Override String type() { return "EBike"; }
    @Override public String bookChargingBay() { return passNumber + " charging bay allotted"; }
}
