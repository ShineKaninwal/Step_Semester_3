import java.util.*;
public class CampusVehiclePassSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new HashMap<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] p = line.split("\s+", 4);
            if (p[0].equalsIgnoreCase("PASS") && p.length >= 4) {
                Vehicle v;
                switch (p[1].replace("-", "").toLowerCase()) {
                    case "bike": v = new Bike(p[2], p[3]); break;
                    case "car": v = new Car(p[2], p[3]); break;
                    case "ebike": v = new EBike(p[2], p[3]); break;
                    case "ecar": v = new ECar(p[2], p[3]); break;
                    default: continue;
                }
                vehicles.put(p[2], v);
                System.out.println(v.passNumber + " (" + v.type() + ") pass fee " + v.passFee());
            } else if (p[0].equalsIgnoreCase("CHARGE") && p.length >= 2) {
                Vehicle v = vehicles.get(p[1]);
                if (v == null) System.out.println("Vehicle not found");
                else if (v instanceof Chargeable) System.out.println(((Chargeable) v).bookChargingBay());
                else System.out.println(p[1] + " rejected: charging unsupported");
            }
        }
    }
}
