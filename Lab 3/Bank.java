import java.util.*;

public class Bank {
    //Account accArray[];
    private String nameofBank;
    private ArrayList<Account> accArray; 

    public Bank(){
        nameofBank = "Seneca@York";
        accArray = new ArrayList<Account>();
    }

    public Bank(String s){
        nameofBank = s;
        accArray = new ArrayList<Account>();
    }

    public boolean addAccount(Account newAccount){
        if(newAccount != null){
            String num = newAccount.getAccountNumber();
            for(int i = 0; i < accArray.size(); i++){
                if(accArray.get(i).getAccountNumber().contains(num)) {
                    return false;
                }
            }
            accArray.add(newAccount);
            if(accArray.contains(newAccount)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public ArrayList searchByBalance(int bal){
        ArrayList<Account> tempArray = new ArrayList<Account>();

        int[] index = new int[5];
        int count = 0;

        for(int i = 0; i < accArray.size(); i++) {
            if(accArray.get(i).getAccountBalance() == bal){
                index[count] = i;
                count++; 
            }
        }

        for(int j = 0; j < count; j++) {
            tempArray.add(accArray.get(index[j]));
        }

        return tempArray;

    }

    public String toString(){
        String s;
        s =  "*** Welcome to the Bank of Kevin Chan ***\n" +
             "It has " + accArray.size() + " accounts.\n";
        for(int i = 0; i < accArray.size(); i++){
            s += ( (i+1) + " " + accArray.get(i) + '\n');
        }
        return s;
    }

    public boolean equals(Object z){
        boolean flag = false;
        if(z instanceof Bank) {
            Bank z2 = (Bank)z;
			
			if(nameofBank != null && accArray != null){
				if(nameofBank.equals(z2.nameofBank) && accArray.equals(z2.accArray)){
                    flag = true;
                }
            }
       
        }
        return flag;

    }
    

}