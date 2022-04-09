
public class QuickFoods {
	public static void main(String args[]) {
		
//Instantiating Objects	
		Customer customer = new Customer(null, null, null, null, null);
		Restaurant restaurant = new Restaurant(null, null, null, null, null, null, null, null);
		Driver driver = new Driver(null);
		Calculations calculations = new Calculations(0);
		
//Calling all methods		
		customer.createNewCustomer();
		restaurant.createNewRestaurant();
		driver.findDriver();
		calculations.findTotalDue();
		Invoice.writeInvoice();
		
//Not sure if this is still needed
		System.out.println(customer.toString());
		System.out.println(restaurant.toString());
	}
}