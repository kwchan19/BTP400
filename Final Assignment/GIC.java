import java.math.BigDecimal;

public class GIC extends Account {
    private int poi;
    private double annualInterest;

    public GIC(){
        super();
        poi = 1;
        annualInterest = 1.25;
    }

    public GIC(String name, String accnum, BigDecimal bal, int period, double interest){
        super(name,accnum,bal);
        poi = period;
        annualInterest = interest;
    }

    public boolean deposit(BigDecimal amount){
        return false;
    }

    public boolean withdraw(BigDecimal amount){
        return false;
    }
    
    public double getBalanceAtMaturity(){

        double temp = Math.pow((1 + annualInterestRate), investmentPeriod);
		
		balanceAtMaturity = BigDecimal.valueOf(super.getBalance() * temp);
		
		double d = balanceAtMaturity.doubleValue();
		return d; 
    }

    public boolean equals(Object z){
        boolean result = false;
        if ( z instanceof Account ){
            Account z2 = (Account) z;
            if ((z2.fullName.equals(fullName)) && (z2.accountNum.equals(accountNum)) && (z2.accountBalance.equals(accountBalance)) && (z2.periodOfInvestment==serviceCharge) && (z2.interestRate==transactions)){
                result = true;
            }
        }
        return result;
    }

    public String toString(){
        String s;
        s = super.toString() + "type: GIC\n" +
        "annual interest rate: " + annualInterest + "%\n"
        + "period of investment: " + poi + " years\n" + 
        "new balance at maturity: $" + getBalanceAtMaturity();
        return s;
    }

}