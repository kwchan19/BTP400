public class Account {
    private String fullName;
    private String accNumber;
    private int currentBal;
    
    //default constructor
    public Account(){
        this.fullName = "";
        this.accNumber = "";
        this.currentBal = 0;
    }

    //constructor with 3 args
    public Account(String name, String num, int bal){
        if(name != null) {
            setFullName(name);
        } 
        else {
            setFullName("");
        } 

        if(num != null){
            setAccountNumber(num);
        }
        else {
            setAccountNumber("");
        }

        if(bal == -1){
            setAccountBalance(0);
        }
        else {
            setAccountBalance(bal);
        }


   
    }

    //toString method
    public String toString(){
        String s;
        s =  fullName + ", " + accNumber + ", " + currentBal + ": ";
        return s;



    }

    //setter for name
    public void setFullName(String name){
        fullName = name;
    }
    
    //setter for account number
    public void setAccountNumber(String num){
        accNumber = num;
    }

    //setter for account balance
    public void setAccountBalance(int bal){
        currentBal = bal;
    }

    //getter for full name
    public String getFullName(){
        return fullName;
    }
    
    //getter for account number
    public String getAccountNumber(){
        return accNumber;
    }

    //getter for account balance
    public int getAccountBalance(){
        return currentBal;
    }

    public boolean equals(Object z){
        boolean result = false;
        if (z instanceof Account){
            Account z2 = (Account) z;
            if ((z2.fullName.equals(fullName)) && (z2.accNumber.equals(accNumber)) && (z2.currentBal == currentBal)){
			     result = true;
            }

        }
        return result;
    }

}