abstract class BankAccount {
    protected final String id;
    protected long balance;
    BankAccount(String id, long balance) { this.id = id; this.balance = balance; }
    abstract String withdraw(long amount);
}
