package logical;

import java.io.*;
import java.util.Scanner;

public class Customer {

	private int spaces;
	private String email, password, firstname, lastname;
	
//	public Customer(String email, String firstname, String lastname, int spaces) {
//		super(email, firstname, lastname);
//		this.spaces = spaces;
//		
//	}
	
	public Customer(String email) throws IOException {
		this.email = email;
		FileInputStream input = new FileInputStream("Customers.txt");
		Scanner scanner = new Scanner(input);
		
		while(scanner.hasNextLine()) {
			String str = scanner.nextLine();
			String[] strc = str.split(";");
			String efound = strc[0];
			
			if(efound.equals(email)) {
				this.email = email;
				this.password = strc[1];
				this.firstname = strc[2];
				this.lastname = strc[3];
				this.spaces = Integer.parseInt(strc[4]);
			}
		}
		scanner.close();
		input.close();
	}

	public static boolean addCustomer(String email, String password, String firstname, String lastname) throws IOException {
		boolean flag = false;
		FileInputStream inputFile = new FileInputStream("Customers.txt");
		Scanner scanner = new Scanner(inputFile);
		
		while(scanner.hasNextLine()) {
			if((scanner.nextLine()).substring(0, email.length()).equals(email)) {
				flag = true;
				scanner.close();
				inputFile.close();
				return !flag; //returns false if customer added
			}
		}
		
		scanner.close();
		inputFile.close();
		
		FileOutputStream outputFile = new FileOutputStream("Customers.txt", true);
		PrintWriter printer = new PrintWriter(outputFile);
		
		printer.println(email + ";" + password + ";" + firstname + ";" + lastname + ";" + 0 + ";");
		printer.close();
		outputFile.close();
		return !flag; //returns true if customer added
	}
	
	public static boolean customerLogin(String email, String password) throws IOException {
		
		boolean flag = false;
		
		FileInputStream input = new FileInputStream("Customers.txt");
		Scanner scanner = new Scanner(input);
		while(scanner.hasNextLine()) {
			String str = scanner.nextLine();
			String[] strc = str.split(";");
			String passfound = strc[1];
			String efound = strc[0];			
			if(efound.equals(email) && passfound.equals(password)) {
				flag = true;
			}
		}
		
		scanner.close();
		input.close();
		
		return flag;
	}
	
	public boolean addSpace(int spacen) throws IOException {
		if(this.spaces < 3) {
			//this.spaces++;
			ParkingSpace.bookSpace(spacen);
			return true;
		}
		else
			return false;
	}
	
	public boolean removeSpace(int spacen) throws IOException {
			//this.spaces--;
			ParkingSpace.freeSpace(spacen);
			return true;
	}
	public String getEmail() {
		
		return this.email;
	}
	public String getFirst() {
		
		return this.firstname;
	}
	public String getLast() {
		
		return this.lastname;
	}
	public int getSpots() {
		
		return this.spaces;
	}
	public void setSpots(int i) {
		this.spaces = i;
	}
}

