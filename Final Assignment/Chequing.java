import java.math.BigDecimal;
import java.util.*;

public class Chequing extends Account {
    private double serviceCharge;
    private double totalCharge;
    private ArrayList<BigDecimal> transactions = new ArrayList<BigDecimal>();

    public Chequing(){
        super();
        serviceCharge = 0.25;
    }

    public Chequing(String name, String accnum, BigDecimal bal, double charge){
        super(name,accnum,bal);
        serviceCharge = charge;
    }

    public boolean deposit(BigDecimal amount) {
        double temp = doubleValue(amount);
        if(temp < 0) {
            return false;
        }
        else {
            currentBal.add(amount); 
            transactions.add(amount);
            return true;
        }
    }

    public boolean withdraw(BigDecimal amount) {
        BigDecimal temp = currentBal.subtract(amount);
        if(doubleValue(amount) < 0 || doubleValue(temp) < 0){
            return false;
        }
        else {
            currentBal.subtract(amount); 
            currentBal.subtract(BigDecimalValue(serviceCharge));
            totalCharge += serviceCharge;
            transactions.add(amount.multiply(BigDecimalValue(-1))); 
            return true;
        }
    }

    public boolean equals(Object z) {
        boolean result = false;
        if (z instanceof Account) {
            Account z2 = (Account) z;
            if ((z2.fullName.equals(fullName)) && (z2.accNumber.equals(accNumber)) && (z2.currentBal.equals(currentBal)) & (z2.serviceCharge.equals(serviceCharge)) && (z2.transactions.equals(transactions))){
                result = true;
            }
        }
      return result;
    }
    
    public String toString(){
        String s;
        s = super.toString() + "type: CHEQUING\n" +
        "service charge: $" + serviceCharge + "\n" +
        "number of transactions: " + transactions.size() + "\n" +
        "total amount of service charge: $" + totalCharge;
        return s;
    }
  

}