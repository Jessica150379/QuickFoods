import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Restaurant{
//Declaring/initializing class attributes
	static String restName;
	static String restLocation;
	static String restContactNo;
	static String orderNo;
	static ArrayList <String> meal;
	static ArrayList<Double> price;
	static ArrayList <Integer> amount;
	static String specialInstructions;
	

	public Restaurant(String restName,String restLocation,String restContactNo,String orderNo,ArrayList<String> meal, ArrayList<Double> price,ArrayList<Integer>amount,String specialInstructions) {
		this.orderNo = orderNo;
		this.meal = new ArrayList<>();
		this.price = new ArrayList<>();
		this.amount = new ArrayList<>();
		this.specialInstructions =specialInstructions;
		this.restName = restName;
		this.restContactNo = restContactNo;
		this.restLocation = restLocation;
	}
	
	
//This method creates the restaurant object	
	public void createNewRestaurant() {
		try {
			getRestaurantInput();
		}
		catch (Exception e) {
			getRestaurantInput();
		}
	}
	
	

//HELPER METHODS
	
//Method to get Restaurant input
	private void getRestaurantInput() {
		System.out.println("Enter the Restaurant name");
		Scanner sc = new Scanner(System.in);
		restName = sc.nextLine();
		System.out.println("Enter the Restaurant location");
		restLocation = sc.nextLine();
		System.out.println("Enter the Restaurant contact no");
		restContactNo = sc.nextLine();
		System.out.println("Enter the Order no");
		orderNo =sc.nextLine();

//loop to add meals ordered,price of each meal and amount of meals ordered, 0 stops the loop
		while(!sc.nextLine().equals("0")) {
			System.out.println("Enter the meal ordered,price of the meal and the amount.Eg \nPizza\n100.00\n2\nEnter any key to add another order or 0 when done");
			String temp = sc.nextLine();
			meal.add(temp);
//Cast strings to numbers			
			double temp2 = Double.parseDouble(sc.nextLine());
			price.add(temp2);
			int temp1 = Integer.parseInt(sc.nextLine());
			amount.add(temp1);
		}
			System.out.println("Are there any special Instructions");
			specialInstructions =sc.nextLine();
	}
	
//Getter methods	
	public static String getRestName() {
		return restName;
		}
	public static String getRestContactNo() {
		return restContactNo;
		}
	public static String getRestLocation() {
		return restLocation;
		}
	public static String getOrderNo() {
		return orderNo;
		}
	public static ArrayList<String> getMeals() {
		return meal;
		}
	public static ArrayList<Double> getPrice() {
		return price;
		}
	public static ArrayList<Integer> getAmount() {
		return amount;
		}
	public static String getSpecialInstructions() {
		return specialInstructions;
		}
	
// Method that outputs all constructor values		
	public String toString() {
		String output = "Restaurant Name: " + restName;
		output += "\nLocation: " + restLocation;
		output += "\nOrder No: " + orderNo;
		output += "\nContact No: " + restContactNo;
		output += "\nMeals Ordered: " + meal;
		output += "\nAmount of Meals Ordered: " + amount;
		output += "\nPrices of meals: " + price;
		output += "\nTotal due: " + Calculations.totalDue;
		output += "\nClosest Driver: " + Driver.driverOutput;
		output += "\nSpecial Instructions: " + specialInstructions;
	    
		return output;
	}
}
