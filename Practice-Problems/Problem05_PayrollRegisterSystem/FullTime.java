class FullTime extends Staff {
    private final long salary;
    FullTime(String name, long salary) { super(name); this.salary = salary; }
    @Override long calculatePay() { return salary; }
    @Override String type() { return "FullTime"; }
}
