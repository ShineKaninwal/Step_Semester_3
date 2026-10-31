class PartTime extends Staff {
    private final long hours, rate;
    PartTime(String name, long hours, long rate) { super(name); this.hours = hours; this.rate = rate; }
    @Override long calculatePay() { return hours * rate; }
    @Override String type() { return "PartTime"; }
}
