/**
 * @author Omar Abdallah
 */
public class Account {

    private int accountNumber ;
    private double balance ;

    //
    public Account(int accountNumber,double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    //
    public void accountNumber(int number) {
        this.accountNumber = number;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    //
    public void setBalance(double bal) {
        this.balance = bal;
    }
    public double getBalance() {
        return balance;
    }
    @Override
    public String toString() {
        return "Account number: "+ accountNumber + "\nBalance: " + balance +"\n";
    }
    public void withdraw( double money){
        if(this.balance >= money){
          this.balance = this.balance - money ;
            System.out.println("\nSuccessful operation.");
        }else {
            System.out.println("\nERROR!: There is not enough money.");
        }
    }
    public void  deposit(double money){
        this.balance = this.balance + money ;
        System.out.println("\nSuccessful operation.");
    }
}
class SpecialAccount extends Account {

    public SpecialAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }
    public void  withdraw( double money){
        if(this.getBalance() >= money){
            double New_Money = this.getBalance() - money ;
            this.setBalance(New_Money);
            System.out.println("\nSuccessful operation.");
        }else if(((  money - this.getBalance()) <= 1000)) {
            this.setBalance((getBalance() - money));
            System.out.println("\nSuccessful operation.");
        }else {
            System.out.println("\nERROR!: There is not enough money.");
        }
    }

    @Override
    public String toString() {
        return "Account number: "+ getAccountNumber() + "\nBalance(Special): " + getBalance() + "\n";
    }
}
class TestAccount{
    public static void main(String [] args){
        Account a1 = new Account(5,3000);
        System.out.println(a1);
        a1.deposit(1000);
        System.out.println(a1);
        a1.withdraw(2000);
        System.out.println(a1);
        a1.withdraw(3000);
        System.out.println(a1);

        Account a2 = new SpecialAccount(2,3000);
        System.out.println(a2);
        a2.deposit(1000);
        System.out.println(a2);
        a2.withdraw(2000);
        System.out.println(a2);
        a2.withdraw(3000);
        System.out.println(a2);

    }
}
