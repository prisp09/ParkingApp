package logical;

import java.io.*;
import java.util.Scanner;

public class ParkingEnforcer extends User {
	
	public ParkingEnforcer(String email, String firstname, String lastname) {
		super(email, firstname, lastname);
	}

	static int generateUid() throws IOException {
		FileInputStream inputFile = new FileInputStream("puid.txt");
		Scanner scanner = new Scanner(inputFile);
		int currentUid = Integer.parseInt(scanner.next());
		scanner.close();
		inputFile.close();
		
		FileOutputStream outputFile = new FileOutputStream("puid.txt");
		PrintWriter printer = new PrintWriter(outputFile);
		
		printer.println(currentUid + 1);
		printer.close();
		outputFile.close();
		
		return currentUid;
	}
	
	public static boolean parkELogin(String email, String password) throws IOException {
		
		boolean flag = false;
		
		FileInputStream input = new FileInputStream("ParkingEnforcers.txt");
		Scanner scanner = new Scanner(input);
		while(scanner.hasNextLine()) {
			String str = scanner.nextLine();
			char[] strc =  str.toCharArray();
			
			int ccount = 0;
			String passfound = "";
			boolean flagl = false;
			for(int i = 0; (i < strc.length) && (ccount < 2); i++) {
				if(strc[i] == ';' || (ccount > 0 && ccount < 2)) {
					flagl = true;
					
					if(strc[i] == ';')
						ccount++;
				}
				if(flagl == true) {
					passfound = passfound + strc[i];
				}
				flagl = false;
			}
			passfound = passfound.substring(1, passfound.length() - 1);
			
			String efound = "";
			flagl = false;
			for(int i = 0; (i < strc.length); i++) {
				if(strc[i] == ';') {
					break;
				}
				efound = efound + strc[i];
			}
			
//			System.out.println(efound + passfound);
			
			if(efound.equals(email) && passfound.equals(password)) {
				flag = true;
			}
		}
		
		scanner.close();
		input.close();
		
		return flag;
	}
	
	public static boolean addSpace(int number) throws IOException {
		
		boolean flag = false;
		FileInputStream input = new FileInputStream("ParkingSpots.txt");
		Scanner scanner = new Scanner(input);
		String spots = "";
		while(scanner.hasNextLine()) {
			spots = spots + scanner.nextLine();
		}
		char[] strc = spots.toCharArray();
		
		if(strc[number - 1] == '2') {
			flag = true;
			strc[number - 1] = '0';
		}
		
		scanner.close();
		input.close();
		
		File ninput = new File("ParkingSpots.txt");
		
		File tempFile = new File("myTempFile.txt");
		
		FileOutputStream output = new FileOutputStream("myTempFile.txt", true);
		PrintWriter printer = new PrintWriter(output);
		
		for(int i = 0; i < 50; i++) {
			printer.println(strc[i]);
		}
		
		printer.close();
		output.close();
		
		ninput.delete();
		tempFile.renameTo(ninput);
		
		return flag;// returns true if spot opened, false if otherwise
	}
	public static boolean removeSpace(int number) throws IOException {
		
		boolean flag = false;
		FileInputStream input = new FileInputStream("ParkingSpots.txt");
		Scanner scanner = new Scanner(input);
		String spots = "";
		while(scanner.hasNextLine()) {
			spots = spots + scanner.nextLine();
		}
		char[] strc = spots.toCharArray();
		
		if(strc[number - 1] == '0') {
			flag = true;
			strc[number - 1] = '2';
		}
		
		scanner.close();
		input.close();
		
		File ninput = new File("ParkingSpots.txt");
		
		File tempFile = new File("myTempFile.txt");
		
		FileOutputStream output = new FileOutputStream("myTempFile.txt", true);
		PrintWriter printer = new PrintWriter(output);
		
		for(int i = 0; i < 50; i++) {
			printer.println(strc[i]);
		}
		
		printer.close();
		output.close();
		
		ninput.delete();
		tempFile.renameTo(ninput);
		
		return flag;// returns true if spot opened, false if otherwise
	}
}

