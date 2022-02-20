package seneca.btp400.lab5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import org.finance.accounts.Account;

import com.little.bank.Bank;

public class BankServer {
	
	public static void main(String[] args) {
		int port;
		
		try {
			port = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("Invalid argument");
			return;
		}
		
		Bank bank = loadBank("Ryan Vu's Bank");
		BankServer bankServer = new BankServer(bank, port);
		bankServer.start();
	}
	
	private Bank bank;
	private int port;
	
	public BankServer(Bank bank, int port) {
		this.bank = bank;
		this.port = port;
	}
	
	public void start() {
		System.out.println("BankServer instance is running! " + new Date());
		
		ServerSocket serverSocket;
		
		try {
			serverSocket = new ServerSocket(port);
			
			// listen for connections and create threads
			while (true) {
				Socket socketConnection = serverSocket.accept();
				Thread thread = new HandleClientThread(socketConnection, this);
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("BankServer instance is closing! " + new Date());
	}

	public String getName() {
		return bank.getName();
	}
	
	public String getAccounts() {
		Account accounts[] = bank.getAccounts().toArray(new Account[bank.getAccounts().size()]);
		return ListAccounts(accounts);
	}
	
	public String searchByBalance(String balance) {
		Account accounts[] = bank.searchByBalance(new BigDecimal(balance));
		return ListAccounts(accounts);
	}

	private static Bank loadBank(String bankName) {
		Bank bank = new Bank(bankName);
		
		Account accounts[] = {
			new Account("John Doe", "A1234", "5000"),
			new Account("John Doe", "B3424", "7000"),
			new Account("Mary Smith", "A3334", "5000"),
			new Account("Tom Cruise", "D9088", "3400"),
			new Account("Jane Swift", "U7834", "1300"),
			new Account("Ryan Vu", "N8934", "5000"),
		};

		for (Account account : accounts) {
			bank.addAccount(account);
		}
		
		return bank;
	}
	
	private static String ListAccounts(Account accounts[]) {
		StringBuffer stringBuffer = new StringBuffer("\n");
		
		for (int i = 0; i < accounts.length; i++) {
			stringBuffer.append(i + 1).append(".\n").append(accounts[i]);
		}
		
		return stringBuffer.toString();
	}
}

class HandleClientThread extends Thread {
	private Socket socketConnection;
	private DataInputStream disFromClient;
	private DataOutputStream dosToClient;
	private String user;
	private BankServer bankServer;
	
	public HandleClientThread(Socket socket, BankServer bankServer) {
		this.socketConnection = socket;
		this.bankServer = bankServer;
	}
	
	@Override
	public void run() {
		try {
			disFromClient = new DataInputStream(socketConnection.getInputStream());
			dosToClient = new DataOutputStream(socketConnection.getOutputStream());
			
			try {
				// greeting
				dosToClient.writeUTF("Welcome to the bank of "
						+ bankServer.getName() + "! " + new Date()
						+ "\n\nEnter your Name: ");
				
				// get identification
				user = disFromClient.readUTF();
				System.out.println("User connected: " + user);
				send("");
				
				// read commands repeatedly
				boolean listen = true;
				while (listen) {					
					switch (recv()) {
					case "1":
						send(bankServer.getAccounts());
						break;
						
					case "2":
						dosToClient.writeUTF("Please enter balance: ");
						send(bankServer.searchByBalance(recv()));
						break;
						
					case "0":
						listen = false;
						break;
						
					default:
						send("Invalid command");
					}
				}
			} catch (EOFException e) {
			    System.out.println("The client has terminated connection!");
			}
			
			dosToClient.close();
			disFromClient.close();
			socketConnection.close();
		    System.out.println("User disconnected: " + user);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Receive string from client and then log
	private String recv() throws IOException {
		String iFromClient = disFromClient.readUTF();
		System.out.println("From " + user + ": " + iFromClient);
		return iFromClient;
	}
	
	// Send string to client with menu
	private void send(String string) throws IOException {
		dosToClient.writeUTF(string + MENU);
	}
	
	private static String MENU = "\n>> Enter a command:\n"
			+ "1. Get all accounts\n"
			+ "2. Get accounts by balance\n"
			+ "0. Exit\n"
			+ "Command: ";
}
 