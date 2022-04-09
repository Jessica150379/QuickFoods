import java.util.ArrayList;
import java.util.Formatter;

public class Invoice {
	
//This method will write an invoice to a text file	
	public static void writeInvoice() {
//Method that formats and outputs the final Order
		formatOutput();
		

//Create and write to file invoice.txt	
// Try/catch blocks handles the possibility of an error, if an error occurs it will print error		
		try {
			Formatter f = new Formatter("C:\\invoice.txt");
					
			f.format("%s", "Order number: " + Restaurant.getOrderNo() + "\r\n"
					+ "Customer: " + Customer.getCustName() +"\r\n"
					+ "Email: "+ Customer.getCustEmailAddress()+"\r\n"
					+ "Phone number: "+ Customer.getCustContactNo() + "\r\n"
					+ "Location: "+ Restaurant.getRestLocation() + "\r\n"
					+ "\r\n"
					+ "You have ordered the following from "+ Restaurant.getRestName() +" in "+ Restaurant.getRestLocation() + ":\r\n"
					+"\r\n"
					+ formatOutput()
					+ "\r\n"
					+ "Special instructions: "+ Restaurant.getSpecialInstructions()+"\r\n"
					+ "\r\n"
					+ "Total: "+ "R"+ String.format("%.2f",Calculations.getTotalDue())+"\r\n"
					+ "\r\n"
				    + Driver.getDriverOutput()+"\r\n"
					+ "\r\n"
					+ Customer.getCustAddress()+"\r\n"
					+ Customer.getCustLocation()+"\r\n"
					+ "\r\n"
					+ "If you need to contact the restaurant, their number is " + Restaurant.getRestContactNo()+ ".");
					
			System.out.println();
			f.close();
		}
			catch (Exception e) {
				System.out.println("Error");
			}
		}
	
//HELPER METHODS

	private static StringBuilder formatOutput() {
//Declaring and initializing variables
		ArrayList<String> order = new ArrayList<>();
		StringBuilder finalOrder = new StringBuilder();
		
//Looping through the amount to output the meals,prices and amounts correctly	
		for(int i = 0; i< Restaurant.getAmount().size();i++) {
			order.add(Restaurant.getAmount().get(i) + " x " + Restaurant.getMeals().get(i)+ " (R"+Restaurant.getPrice().get(i)+")"+ "\r\n");
		}
		
//Convert to String 		
		for (int j = 0; j<order.size();j++) {
	finalOrder.append(order.get(j));
			
		}
		return finalOrder;
	}
							
}
