package seneca.btp400.lab5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {
	public static void main(String[] args) {
		// read parameters
		int port;

		try {
			port = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("Invalid argument");
			return;
		}

		// create socket
		Socket clientSocket;

		try {
			clientSocket = new Socket(InetAddress.getByName("localhost"), port);
			DataInputStream disFromServer = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream dosToServer = new DataOutputStream(clientSocket.getOutputStream());
			Scanner keyboard = new Scanner(System.in);
			String input = "";
			
			while (!input.equals("0")) {
				try {
					System.out.print(disFromServer.readUTF());
					input = keyboard.nextLine();
					dosToServer.writeUTF(input);
					
				} catch (EOFException e) {
				    System.out.println("The server has terminated connection!");
				    
				} catch (IOException e) {
				    System.out.println("I/O errors in data exchange");
				    e.printStackTrace();
				}	
			}
			
			System.out.println("Thank You!");
			
			keyboard.close();
			dosToServer.close();
			disFromServer.close();
			clientSocket.close();
			
		} catch (IOException e) {
			System.out.println("I/O errors in socket connection");
			e.printStackTrace();
		}
	}
}
