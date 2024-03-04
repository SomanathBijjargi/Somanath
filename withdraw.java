public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds \n");
        } else {
            balance -= amount;
            System.out.println("Withdrew Rs : " + amount + "\n");
        }
    }

    public void checkBalance() {
        System.out.println(" \n Current balance: Rs : " + balance + "\n");
    }
}
