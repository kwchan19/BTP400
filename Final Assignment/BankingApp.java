import java.util.Scanner;
import java.time.LocalDateTime;
import java.lang.String;

public class BankingApp {
    public static void main(String[] args) {
        Bank bank = new Bank("Kevin Chan");

        Scanner scanner = new Scanner (System.in);

        int menu = 6;
        boolean flag = true;

        while(flag == true){
            System.out.println("### Welcome to the Bank of Kevin Chan ###\n"+
                                "1. Open an account.\n"+
                                "2. Close an account.\n"+
                                "3. Update an account.\n"+
                                "4. Search.\n"+
                                "5. List all accounts.\n"+
                                "6. Exit.\n\n"+
                                "Please enter your choice: ");

            switch(menu){
                case 1: 
                    String line;
                    Account create;
                    System.out.println("Please enter information(e.g. account type (SAV,CHEQ,GIC), name, account number, balance, interest rate ) at one line:\n");
                    line = scanner.nextLine();
                    String[] data = line.split(",");
                    if(data.length == 5){
                        if(data[0].toLowerCase() == "sav"){
                            create = new Savings(data[1],data[2]  ,data[3]  , data[4] );
                        }
                        else if(data[0].toLowerCase() == "cheq"){
                            create = new Chequing(data[1]  ,data[2]  ,data[3]  , data[4]  );
                        }
                        else if(data[0].toLowerCase() == "gic"){
                            create = new GIC(data[1]  ,data[2]  ,data[3]  , data[4]  , data[5]  );
                        }

                        System.out.println("\n+ Account Opened:");
                        System.out.println(bank.addAccount(create));
                        
                    }
                    else {
                        System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***");
                    }

                break;

                case 2:
                    break;

                case 3: 
                    break;

                case 4: 
                    break;

                case 5: 
                    break;

                case 6: 
                    flag = false;
                    break;
            }
        }
    }
}