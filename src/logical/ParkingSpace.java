package logical;
import java.io.*;
import java.util.*;
public class ParkingSpace {
	private int spacen;
	private String email;
	private UUID bid;
	public ParkingSpace(String email, int spacen) {
		this.bid = UUID.randomUUID();
		this.email = email;
		this.spacen = spacen;
		
	}
	
	public static boolean bookSpace(int number) throws IOException {
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
			strc[number - 1] = '1';
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
		
		return flag;// returns true if spot booked, false if otherwise
	}
	
	public static boolean freeSpace(int number) throws IOException{
		boolean flag = false;
		FileInputStream input = new FileInputStream("ParkingSpots.txt");
		Scanner scanner = new Scanner(input);
		String spots = "";
		while(scanner.hasNextLine()) {
			spots = spots + scanner.nextLine();
		}
		char[] strc = spots.toCharArray();
		
		if(strc[number - 1] == '1') {
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
		
		return flag;// returns true if freed, false if otherwise
	}
	
	public static boolean checkSpace(int i) throws IOException {
		FileInputStream input = new FileInputStream("ParkingSpots.txt");
		Scanner scanner = new Scanner(input);
		String str = "";
		while(scanner.hasNextLine()) {
			str = str + scanner.nextLine();
		}
		char[] strc = str.toCharArray();
		scanner.close();
		input.close();
		return strc[i - 1] == '0' ? true : false;
	}
	
//	public boolean addRelation(String email, int spacen, UUID bid) throws IOException {
//		
//		FileOutputStream output = new FileOutputStream("Bookings.txt");
//		PrintWriter printer = new PrintWriter(output);
//		
//		printer.println(email + ";" + spacen + ";" + bid +";");
//		
//		printer.close();
//		output.close();
//		return true;
//	}
//	
//	public boolean removeRelation() {
//		
//		
//		
//		return false;
//	}
}
