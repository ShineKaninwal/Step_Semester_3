import java.util.*;
public class PayrollRegisterSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Staff> staffList = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] p = line.split("\s+");
            switch (p[0]) {
                case "FullTime": if (p.length >= 3) staffList.add(new FullTime(p[1], Long.parseLong(p[2]))); break;
                case "PartTime": if (p.length >= 4) staffList.add(new PartTime(p[1], Long.parseLong(p[2]), Long.parseLong(p[3]))); break;
                case "Intern": if (p.length >= 3) staffList.add(new Intern(p[1], Long.parseLong(p[2]))); break;
                default: break;
            }
        }
        Payslip[] payslips = new Payslip[staffList.size()];
        long sum = 0, best = Long.MIN_VALUE;
        String top = "";
        for (int i = 0; i < staffList.size(); i++) {
            Staff staff = staffList.get(i);
            payslips[i] = new Payslip(staff);
            long pay = staff.calculatePay();
            sum += pay;
            if (pay > best) { best = pay; top = staff.name; }
        }
        for (Payslip slip : payslips) System.out.println(slip);
        System.out.println("Total " + sum);
        System.out.println("top earner " + top);
    }
}
