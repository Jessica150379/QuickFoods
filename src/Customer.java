import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;

public class Customer{
//Declaring/initializing class attributes	
	static String address;
	static String emailAddress;
	static String custName;
	static String custLocation;
	static String custContactNo;
	
	
	public Customer(String custName,String custLocation,String custContactNo,String address,String emailAddress) {
		
		this.custName = custName;
		this.address = address;
		this.emailAddress = emailAddress;
		this.custLocation = custLocation;
		this.custContactNo = custContactNo;
	}
	
//Method that creates the customer object	
	public void createNewCustomer() {
		try {
			getCustomerInput();
		}
		catch (Exception e) {
			getCustomerInput();
		}
	}
	
	
//HELPER METHODS
	
//Method to get Customer Input
	private void getCustomerInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the customer name");
		custName = scan.nextLine();
		System.out.println("Enter the customer address");
		address = scan.nextLine();
		System.out.println("Enter the customer email address");
		emailAddress = scan.nextLine();
		System.out.println("Enter the customer contact no");
		custContactNo = scan.nextLine();
		System.out.println("Enter the customer location");
		custLocation = scan.nextLine();
	}
	
//Getter methods	
	public static String getCustName() {
		return custName;
		}
	public static String getCustAddress() {
		return address;
		}
	public static String getCustEmailAddress() {
		return emailAddress;
		}
	public static String getCustLocation() {
		return custLocation;
		}
	public static String getCustContactNo() {
		return custContactNo;
		}
	
// Method that outputs all constructor values		
	public  String toString() {
		String output = "Customer Name: " + custName;
		output += "\nAddress: " + address;
		output += "\nEmail Address: " + emailAddress;
	    output += "\nContact No: " + custContactNo;
	    output += "\nLocation: " + custLocation;
	    
	    return output;
	}
	
}
	


