public class BankAccount {
    public static void main(String[] args) {
        solution acc1 = new solution("abcd", 123456789, 10000);
        acc1.deposit(-2500);
        acc1.displayAccDetails();
        acc1.withdraw(1000);
        acc1.setAccName("sampath");
        acc1.setAccNumber(7654289);
        acc1.displayAccDetails();

    }
}

class solution {
    private String accName;
    private int accNumber;
    private double accBalance;

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        if (accName != null) {
            this.accName = accName;
        } else {
            System.out.println("Name Should Not Be Null!!");
        }
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        if (accNumber != 0) {
            this.accNumber = accNumber;
        } else {
            System.out.println("Enter A Valid Account Number!!");
        }

    }

    solution(String name, int number, double balance) {
        this.accName = name;
        this.accNumber = number;
        this.accBalance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            accBalance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("Updated Balance: " + accBalance);
            System.out.println("============================");

        } else {
            System.out.println("Enter Positive Amounts Only");
            System.out.println("============================");
        }
    }

    public void withdraw(double amount) {
        if (amount > accBalance) {
            System.out.println("Insufficient Balance");
            System.out.println("============================");
        } else {
            accBalance -= amount;
            System.out.println("Withdraw Amount: " + amount);
            System.out.println("Remaining Balance: " + accBalance);
            System.out.println("============================");

        }
    }

    public void displayAccDetails() {
        System.out.println("Account Holder Name: " + accName);
        System.out.println("Account Number: " + accNumber);
        System.out.println("Balance: " + accBalance);
        System.out.println("============================");
    }

}
