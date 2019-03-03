package bankAccount;

public class checkingAccountFees extends checkingAccount{

    private final double FEES = 20.00;

    //constructors
    public checkingAccountFees(){
        super();
    }

    public checkingAccountFees(String owner, double initialBalance, int initialCheckAccount){
        super(owner, initialBalance, initialCheckAccount);
    }

    //methods
    public void deductFees(){
        this.withdraw(FEES);
    }


}
