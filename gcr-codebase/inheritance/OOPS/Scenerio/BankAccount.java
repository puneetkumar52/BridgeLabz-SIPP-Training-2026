class BankAccount {
    int accountNumber;
    String holder;
    double balance;
    static int totalAccounts = 0;

    BankAccount(int accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        totalAccounts++;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println(holder + " deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(holder + " withdrew: " + amount);
        } else {
            System.out.println("Overdraft! Withdrawal denied for " + holder);
        }
    }

    void getStatement() {
        System.out.println("Account: " + accountNumber + ", Holder: " + holder + ", Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount(101, "Ravi", 5000);
        BankAccount a2 = new BankAccount(102, "Anita", 3000);
        BankAccount a3 = new BankAccount(103, "Vikram", 10000);

        a1.deposit(2000); a1.withdraw(1000); a1.withdraw(7000); a1.deposit(500); a1.getStatement();
        a2.withdraw(500); a2.deposit(1000); a2.withdraw(4000); a2.deposit(200); a2.getStatement();
        a3.deposit(5000); a3.withdraw(2000); a3.withdraw(15000); a3.deposit(1000); a3.getStatement();

        System.out.println("Total Accounts Created: " + BankAccount.totalAccounts);
    }
}
