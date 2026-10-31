import java.util.*;
public class BankAccountWithdrawalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, BankAccount> accounts = new HashMap<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] p = line.split("\s+");
            if (p[0].equalsIgnoreCase("Savings") && p.length >= 3)
                accounts.put(p[1], new SavingsAccount(p[1], Long.parseLong(p[2])));
            else if (p[0].equalsIgnoreCase("Current") && p.length >= 3)
                accounts.put(p[1], new CurrentAccount(p[1], Long.parseLong(p[2])));
            else if (p[0].equalsIgnoreCase("WITHDRAW") && p.length >= 3) {
                BankAccount account = accounts.get(p[1]);
                System.out.println(account == null ? "Account not found" : account.withdraw(Long.parseLong(p[2])));
            }
        }
    }
}
