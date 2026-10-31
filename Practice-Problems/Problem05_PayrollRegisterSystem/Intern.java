class Intern extends Staff {
    private final long stipend;
    Intern(String name, long stipend) { super(name); this.stipend = stipend; }
    @Override long calculatePay() { return stipend; }
    @Override String type() { return "Intern"; }
}
