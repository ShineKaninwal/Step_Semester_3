class Payslip {
    final Staff staff;
    Payslip(Staff staff) { this.staff = staff; }
    @Override public String toString() {
        return "Payslip[name=" + staff.name + ", type=" + staff.type() + ", pay=" + staff.calculatePay() + "]";
    }
}
