package bankAccount;

public class checkingAccount extends bankAccount {

    private int remainingChecks;

    //constructors
    public checkingAccount(){
        super();                //calling constructor of parent class
        remainingChecks = 100;  //default value
    }

    public checkingAccount(String owner, double initialBalance, int remainingChecks){
        super(owner, initialBalance);                //calling constructor of parent class
        this.remainingChecks = remainingChecks;
    }

    //methods
    public void useCheck(){
        remainingChecks --; //subtracts remaining checks by one
    }

    public void getCheck(){
        remainingChecks ++; //adds one to remaining checks
    }
}
