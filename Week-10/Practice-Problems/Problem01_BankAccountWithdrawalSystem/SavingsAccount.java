class SavingsAccount extends BankAccount {
    SavingsAccount(String id, long balance) { super(id, balance); }
    @Override String withdraw(long amount) {
        if (amount <= 0) return id + " rejected: invalid amount";
        if (balance - amount < 1000) return id + " rejected: minimum balance 1000";
        balance -= amount;
        return id + " balance " + balance;
    }
}
