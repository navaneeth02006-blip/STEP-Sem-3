class PiggyBankk {
    private double savings;
    private final String id;

    PiggyBankk(String id) {
        this.id = id;
        this.savings = 0;
    }
    public void deposit(double amount) {
        savings += amount;
    }
    public void withdraw(double amount) {
        if (amount <= savings) {
            savings -= amount;
        } else {
            System.out.println("Withdrawal rejected");
        }
    }
    public double getSavings() {
        return savings;
    }
    public String getId() {
        return id;
    }
}
public class Piggybank {
    public static void main(String[] args) {

        PiggyBankk pb = new PiggyBankk("PB-1");
        pb.deposit(100);
        System.out.println("Savings after deposit: " + pb.getSavings());
        pb.withdraw(30);
        System.out.println("Savings after withdrawal: " + pb.getSavings());
        pb.withdraw(500);
        System.out.println("Savings after rejected withdrawal: " + pb.getSavings());
    }
}