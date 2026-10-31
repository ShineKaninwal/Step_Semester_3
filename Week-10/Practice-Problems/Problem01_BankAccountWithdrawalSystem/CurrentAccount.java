class CurrentAccount extends BankAccount {
    CurrentAccount(String id, long balance) { super(id, balance); }
    @Override String withdraw(long amount) {
        if (amount <= 0) return id + " rejected: invalid amount";
        if (balance - amount < -5000) return id + " rejected: overdraft limit 5000";
        balance -= amount;
        return id + " balance " + balance;
    }
}
