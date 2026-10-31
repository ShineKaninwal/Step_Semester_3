class ECar extends Vehicle implements Chargeable {
    ECar(String passNumber, String owner) { super(passNumber, owner); }
    @Override int passFee() { return 1000; }
    @Override String type() { return "ECar"; }
    @Override public String bookChargingBay() { return passNumber + " charging bay allotted"; }
}
