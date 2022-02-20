package seneca.btp400.w18;

import java.util.Scanner;

import org.finance.accounts.Account;
import org.finance.accounts.Chequing;
import org.finance.accounts.GIC;
import org.finance.accounts.Savings;

import com.little.bank.Bank;

import java.lang.String;
import java.util.Date;
import java.math.*;



public class BankingApp {
    public static void main(String[] args) {
        Bank bank = new Bank("Kevin Chan");
        Account acc = null;

        Scanner scanner = new Scanner (System.in);

        boolean flag = true;
        String menu = "";
        
        loadBank(bank);

        while(flag == true){
        	
        	displayMenu(bank.bankName());
            
            menu = scanner.next();

            switch(menu){
                case "1": 
                    String line;
                    System.out.println("Please enter account type (SAV,CHEQ,GIC)");
                    line = scanner.next();
                    scanner.nextLine();
                    
                    if(line.toLowerCase().trim().equals("sav")){
                    	System.out.println("Please enter name, account number, balance, and interest rate at one line:");
                    	String sav  = scanner.nextLine();
                
                        String[] data = sav.split(",");
                        for (String p : data) { p = p.trim(); }
                    	
	                   	acc = new Savings(data[0].trim() ,data[1].trim() ,data[2],(data[3]));
	                   	if(bank.addAccount(acc)) {
                    		System.out.println(acc);
                    	}
	                   	else {
	                   		System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***\n");
                    	}
                    }
                    else if(line.toLowerCase().trim().equals("cheq")) {
                    	System.out.println("Please enter name, account number, balance, and service charge at one line:");
              
                    	String cheq = scanner.nextLine();
                    	
                    	String[] data = cheq.split(",");
                    	for (String p : data) { p = p.trim(); }
                    	
                    	
                    	acc = new Chequing(data[0].trim() ,data[1].trim() , data[2] , (data[3]));
                    	if(bank.addAccount(acc)) {
                    		System.out.println(acc);
                    	}
                    	else {
                    		System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***\n");
                    	}
	                 	
                    	
                    }
                    else if(line.toLowerCase().trim().equals("gic")) {
                    	System.out.println("Please enter name, account number, balance, investment period, and annual interest rate at one line:");
                    	String gic = scanner.nextLine();
                   
                    	String[] data = gic.split(",");
                    	for (String p : data) { p = p.trim(); }
                    	
                    	acc = new GIC(data[0].trim() ,data[1].trim() ,data[2],Integer.parseInt(data[3]),(data[4]));
                    	if(bank.addAccount(acc)) {
                    		System.out.println(acc);
                    	}
                    	else {
                    		System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***\n");
                    	}
                   }
                    
                   else {
                	   System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***\n");
                   }

                break;

                case "2":
                	System.out.println("Enter the account number of the account you want to close: ");
                	String userInput = scanner.next();
                	if(bank.searchByAccountNumber(userInput)!=null) {
                		acc = bank.removeAccount(userInput);
                		System.out.println("\n+ Account Deleted\n");
                	}
                	else {
                		System.out.println("*** FAILED: ACCOUNT CANNOT BE CLOSED! ***");
                	}
                	
                break;

                case "3": 
                	System.out.print("Please enter account number: ");
                	scanner.nextLine();
                	String x = scanner.nextLine();
                	acc = bank.searchByAccountNumber(x);
                	
                	
    				if(acc == null) {
    					System.out.println("*** FAILED: ACCOUNT NOT FOUND ***");
    				}
    				else {
    					System.out.println("a. Deposit Money.\n" + "b. Withdraw Money.");
    					System.out.println("Enter option: ");
    					x = scanner.nextLine();
    					
    					if(x.toLowerCase().equals("a")) {
    						System.out.println("Deposit amount: ");
    						String deposit;
    						deposit = scanner.nextLine().trim();
    						BigDecimal bals = new BigDecimal(deposit);
    						
    						if(acc.deposit(bals)) {
    							System.out.println("$"+ deposit + " added to account.\n");
    						}
    						else {
    							System.out.println("Unable to deposit to account.\n");
    						}
    					}
    					else if(x.toLowerCase().equals("b")) {
    						System.out.println("Withdraw amount: ");
    						BigDecimal withdraw = new BigDecimal(scanner.nextLine());
    						if(acc.withdraw(withdraw)) {
    							System.out.println("$"+ withdraw + " withdrawed from account.\n");
    						}
    						else {
    							System.out.println("Unable to withdraw from account.\n");
    						}
    					}
    				}
    				
    				
                    break;

                case "4": 
                	System.out.println("a. Search by account balance.\n" + "b. Search by account name.\n" + "c. Search by account number");
                	scanner.nextLine();
                	String search = scanner.nextLine();
                	if(search.toLowerCase().equals("a")){
                		System.out.println("Please enter the balance on the account:");
          
                		String bal = scanner.nextLine();
    					Account[] found = bank.searchByBalance(bal);
    					for(Account a : found){
    						displayAccount(a);
    					}
    					
    				}
                	else if(search.toLowerCase().equals("b")) {
                		System.out.println("Please enter the name on the account :");
                		String name = scanner.nextLine();
                		listAccounts(bank.searchByAccountName(name));
                	}
                	else if(search.toLowerCase().equals("c")) {
                		System.out.print("Please enter account number: ");
                		String num = scanner.nextLine();
    					displayAccount(bank.searchByAccountNumber(num));
                	}
                	
                break;

                case "5": 
                	Account[] accs = bank.getAllAccounts();
					for(Account temp: accs){
						displayAccount(temp);
					}
    			break;

                case "6": 
                	System.out.println("Thank you!");
                    flag = false;
                    break;
            }
        }
        scanner.close();
    }
    
    public static void displayMenu(String bankName) {
    	 System.out.println("### Welcome to the Bank of " + bankName + " ###\n"+(new Date()) +
                 "\n\n1. Open an account.\n"+
                 "2. Close an account.\n"+
                 "3. Update an account.\n"+
                 "4. Search.\n"+
                 "5. List all accounts.\n"+
                 "6. Exit.\n\n"+
                 "Please enter your choice: ");
    }
    
    public static void displayAccount(Account account) {
    	System.out.println(account + "\n");
    	System.out.println("-------------------------------------\n");
    	
	}
    
    public static void listAccounts(Account[] accounts) {
		System.out.println();
		for (Account acc : accounts) { displayAccount(acc); }
	}
    
    public static void loadBank(Bank bank) {
		bank.addAccount(new GIC("John Doe", "D1234", "6000", 2, "1.5"));
		bank.addAccount(new Chequing("John Doe", "E5678", "15000", "0.75"));
		bank.addAccount(new Savings("John Doe", "F9801", "8000", "0.15"));
		
		bank.addAccount(new GIC("Mary Ryan", "A1234", "15000", 4, "2.5"));
		bank.addAccount(new Chequing("Mary Ryan", "B5678", "15000", "0.75"));
		bank.addAccount(new Savings("Mary Ryan", "C9012", "8000", "0.15"));
	}
}