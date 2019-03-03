package bankAccount;

public class savingsAccount extends bankAccount{

    private final double INTEREST_RATE = 0.05;   //final means variable will not change

    //constructors
    public savingsAccount(){
        super();                //calling constructor of parent class
    }

    public savingsAccount(String owner, double initialBalance){
        super(owner, initialBalance);                //calling constructor of parent class
    }

    //methods
    public void addInterest(){
        double increaseBy = (this.getBalance() * INTEREST_RATE);
        this.deposit(increaseBy);
    }



}
