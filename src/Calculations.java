import java.util.ArrayList;

public class Calculations {
//Declaring/initializing class attributes	
	static double totalDue;
	
	public Calculations(double totalDue) {
		this.totalDue = totalDue;
	}
	
	
//Method that calculates total due	
	public double findTotalDue() {
		ArrayList<Double> calc = new ArrayList<>();
	
//Loop through the prices and add to numbers arrayList	
		for (int i = 0;i< Restaurant.getPrice().size();i++) {
			calc.add(Restaurant.getPrice().get(i)*Restaurant.getAmount().get(i));
		}
//Loop through the numbers ArrayList and add them together	
		for (Double element : calc) {
			double sum = 0;
			sum += element;
				
			totalDue = sum;
		}
		return totalDue;
	}
	
	
//Getter method	
	public static double getTotalDue() {
		return totalDue;
		}

}
