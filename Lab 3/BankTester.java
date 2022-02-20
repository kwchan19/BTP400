import java.util.*;
public class BankTester {
    public static void main(String[] args) {
        String accountNames [] = { "John Doe", "Mary Ryan", "Peter Liu", "John Doe", "Peter Liu" };
        String accountNumbers [] = { "A1234", "B5678", "C9999", "A1234", "D8901" };
        int accountBalances [] = { 1000, 3000, 5000, 7000, 3000 };

        Account acc1, acc2, acc3, acc4, acc5;

        acc1 = new Account(accountNames[0],accountNumbers[0],accountBalances[0]); //John Doee
        acc2 = new Account(accountNames[1],accountNumbers[1],accountBalances[1]);
        acc3 = new Account(accountNames[2],accountNumbers[2],accountBalances[2]);
        acc4 = new Account(accountNames[3],accountNumbers[3],accountBalances[3]); //John Doe
        acc5 = new Account(accountNames[4],accountNumbers[4],accountBalances[4]);

        //2A

        Bank bank;
        bank = new Bank();

        System.out.println(bank);

        //2B

        Bank bank1;

        bank1 = new Bank(); 


        bank1.addAccount(acc1);
        bank1.addAccount(acc2);
        bank1.addAccount(acc3);
        bank1.addAccount(acc4);
        bank1.addAccount(acc5);

        System.out.println(bank1);

        //2C

        Bank bank2;

        bank2 = new Bank();

        bank2.addAccount(null);
        System.out.println("Null returns " + bank2.addAccount(null) + "\n");

        //2D

        System.out.println(bank1.searchByBalance(3000).size() + " accounts are found.");

        for(int i = 0; i < bank1.searchByBalance(3000).size(); i++){
            System.out.println(bank1.searchByBalance(3000).get(i));
        }

        //2E
        
        if(bank1.searchByBalance(-1111).size() == 0) {
            System.out.println("\n*** NO ACCOUNT FOUND ***\n");
        }
        else {
            System.out.println(bank1.searchByBalance(-1111));
        }

        //3

        //acc5,acc3,acc2,acc1
        
        Bank bank3, bank4, bank5, bank6;
        bank3 = new Bank();
        bank4 = new Bank();
        bank5 = new Bank();


        bank6 = new Bank();

        bank4.addAccount(acc1); // John Doe
        bank3.addAccount(acc4); // John Doe
        bank5.addAccount(acc2); // Mary Ryan

        bank6.addAccount(acc5);
        bank6.addAccount(acc3);
        bank6.addAccount(acc2);
        bank6.addAccount(acc1);
        bank6.addAccount(acc4);

        System.out.println("bank4 and bank4 equals: " + bank4.equals(bank4));
        System.out.println("bank5 and bank3 equals: " + bank5.equals(bank3));

        //System.out.println(bank6.equals)
    }

}
