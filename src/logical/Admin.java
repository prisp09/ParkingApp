package logical;

import java.io.*;
import java.util.Scanner;

public class Admin extends User {

	public Admin(String email, String firstname, String lastname) {
		super(email, firstname, lastname);
	}

	public static boolean addParkE(String email, String password, String firstname, String lastname) throws IOException {
		boolean flag = false;
		FileInputStream inputFile = new FileInputStream("ParkingEnforcers.txt");
		Scanner scanner = new Scanner(inputFile);
		
		while(scanner.hasNextLine()) {
			if((scanner.nextLine()).substring(0, email.length()).equals(email)) {
				flag = true;
				scanner.close();
				inputFile.close();
				return !flag; //returns false if officer added
			}
		}
		
		scanner.close();
		inputFile.close();
		
		FileOutputStream outputFile = new FileOutputStream("ParkingEnforcers.txt", true);
		PrintWriter printer = new PrintWriter(outputFile);
		
		printer.println(email + ";" + password + ";" + firstname + ";" + lastname + ";" + 2 + ";" + ParkingEnforcer.generateUid() + ";");
		printer.close();
		outputFile.close();
		return !flag; //returns true if officer added
	}
	
	public static boolean removeParkE(String email) throws IOException{
		boolean flag = false;
		// THIS CODE IS A MODIFIED VERSION OF A CODE FROM
		// https://www.quora.com/How-can-I-delete-a-line-from-a-file-using-Java
		File inputFile = new File("ParkingEnforcers.txt"); 
		File tempFile = new File("myTempFile.txt"); 
		 
		BufferedReader reader = new BufferedReader(new FileReader(inputFile)); 
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile)); 
		  
		String currentLine; 
		 
		while((currentLine = reader.readLine()) != null) { 
		    
		    if(currentLine.substring(0, email.length()).equals(email)) continue; 
		 
		    writer.write(currentLine + System.getProperty("line.separator")); 
		} 
		 
		writer.close();  
		reader.close();  
		
		if(inputFile.equals(tempFile))
			flag = true;
		
		inputFile.delete();
		tempFile.renameTo(inputFile); 
		
		return !flag; //returns true if officer removed and false if not removed
	}
	
//	static boolean adminLogin(String email, String password) throws IOException {
//		
//		boolean flag = false;
//		
//		FileInputStream input = new FileInputStream("Admins.txt");
//		Scanner scanner = new Scanner(input);
//		while(scanner.hasNextLine()) {
//			String str = scanner.nextLine();
//			char[] strc =  str.toCharArray();
//			
//			int ccount = 0;
//			String passfound = "";
//			boolean flagl = false;
//			for(int i = 0; (i < strc.length) && (ccount < 2); i++) {
//				if(strc[i] == ';' || (ccount > 0 && ccount < 2)) {
//					flagl = true;
//					
//					if(strc[i] == ';')
//						ccount++;
//				}
//				if(flagl == true) {
//					passfound = passfound + strc[i];
//				}
//				flagl = false;
//			}
//			passfound = passfound.substring(1, passfound.length() - 1);
//			
//			String efound = "";
//			flagl = false;
//			for(int i = 0; (i < strc.length); i++) {
//				if(strc[i] == ';') {
//					break;
//				}
//				efound = efound + strc[i];
//			}
//			
//			System.out.println(efound + passfound);
//			
//			if(efound.equals(email) && passfound.equals(password)) {
//				flag = true;
//			}
//		}
//		
//		scanner.close();
//		input.close();
//		
//		return flag;
//	}
	
}
