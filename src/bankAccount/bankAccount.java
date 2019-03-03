package bankAccount;

public class bankAccount {

    private String owner;           //only bankAccount can access these vars
    private double balance;

    //constructors
    public bankAccount(){
        owner = "bob";
        balance = 0.00;
    }

    public bankAccount(String owner, double balance){
        this.owner = owner;         //this.owner means the class owner in other words bankAccount.owner(private string). owner is the local variable
        this.balance = balance;
    }

    //methods
    public void deposit(double amount){
        balance += amount;   //balance = balance + amount
    }

    public void withdraw(double amount){
        balance -= amount;   //balance = balance - amount
    }

    public String getOwner(){
        return this.owner;
    }

    public double getBalance(){
        return this.balance;
    }


}
