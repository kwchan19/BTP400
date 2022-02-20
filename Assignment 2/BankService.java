
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

import org.finance.accounts.*;

import com.little.bank.Bank;

public class BankService {
    public static void main(String[] args) {
        //Scanner s = new Scanner(System.in);

        int port;
		
		try {
			port = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("Invalid argument");
			return;
        }
        String bankName;

		//System.out.println("Enter the bank name: ");
		//bankName = s.next();
		
		Bank bank = new Bank("Kevin and Ryan's Bank");

		//get the name of the bank
		System.out.println(bank.getName());

		//open an account
		loadBank(bank);
	}
	
	public static void loadBank(Bank bank) {
		bank.addAccount(new GIC("John Doe", "D1234", "6000", "1.5", 2));
		bank.addAccount(new Chequing("John Doe", "E5678", "15000", "0.75"));
		bank.addAccount(new Savings("John Doe", "F9801", "8000", "0.15"));
		
		bank.addAccount(new GIC("Mary Ryan", "A1234", "15000", "2.5", 4));
		bank.addAccount(new Chequing("Mary Ryan", "B5678", "15000", "0.75"));
		bank.addAccount(new Savings("Mary Ryan", "C9012", "8000", "0.15"));
	}
}