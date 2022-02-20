import java.math.BigDecimal;

public class Savings extends Account {
    private double annualInterest;

    public Savings(){
        super();
        annualInterest = 0.3;
    }

    public Savings(String name, String accnum, BigDecimal startingBal, double interest){
        super(name, accnum, startingBal);
        annualInterest = interest;
    }

    public boolean equals(Object z) {
        boolean result = false;
        if (z instanceof Account) {
            Account z2 = (Account) z;
            if ( (z2.fullName.equals(fullName)) && (z2.accNumber.equals(accNumber)) && (z2.currentBal.equals(currentBal)) && (z2.annualInterest.equals(annualInterest))){
                result = true;
            }
        }
        return result;
    }

    public String toString() {
        String s;
        s = super.toString() + "type: SAVINGS\n" +
        "annual interest rate: " + annualInterest + "%";
        return s;
    }

}