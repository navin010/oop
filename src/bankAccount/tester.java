package bankAccount;

public class tester {

    public static void main(String[] args) {
        bankAccount ba = new bankAccount("Red", 10.00);
        l(ba.getOwner());
        l(ba.getBalance());
        l("-----------------");
        savingsAccount sa = new savingsAccount("bob", 125.00);
        sa.deposit(20.00);
        sa.addInterest();
        l(sa.getBalance());
        l("-----------------");
        checkingAccount ca = new checkingAccount("Dee", 250.00, 50);
        ca.withdraw(25.00);
        ca.useCheck();
        l(ca.getBalance());
        l("-----------------");
        checkingAccountFees caf = new checkingAccountFees("To", 220.00, 20);
        caf.withdraw(20.00);
        caf.useCheck();
        caf.deductFees();
        l(caf.getBalance());
        l("-----------------");
        lol(ba);
        lol(sa);
        lol(ca);
        lol(caf);
    }

    //Print method
    public static void l(Object s){             //object can take in all var types, as all var types are subclasses of object
        System.out.println(s);
    }

    public static void lol(bankAccount b){
        l(b.getOwner());
    }

}
