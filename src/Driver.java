import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Driver {
//Declaring/initializing class attributes	
	static String driverOutput;
	
	public Driver(String driverOutput) {
		this.driverOutput = driverOutput;
	}
	
//Declaring and initializes variables
	ArrayList<String> driversList = new ArrayList<>();
	ArrayList<String>indexValues = new ArrayList<>();
	String stringNos;
	int lowestNumber = 0;
	ArrayList<Integer>numberList = new ArrayList<>();
	String lowestNumberString;
	String driverLine = null;
	ArrayList<Integer>indexes = new ArrayList<>();
	
//Method that finds the driver based on location and lightest load	
	public void findDriver() {
		try {
			File drivers = new File("C:\\driver-info.txt");
			Scanner scan = new Scanner(drivers);
			while (scan.hasNextLine()) {
//Save contents and add to List
				driversList.add(scan.nextLine()+ "\n");
			}
			//scan.close();
		}
		catch (FileNotFoundException e) {
		}
		
//Loop through driversList and method that finds the index of the line if it contains the restaurant location 
		for(int i = 0; i<driversList.size();i++) {
			findMatchingIndexes(i);
		}
		
//Loop through the indexes and saves the values at those indexes
		for(int x = 0; x<indexes.size();x++){
			indexValues.add(driversList.get(indexes.get(x)));	
		}
		
//Loop through the values and extract the String numbers from them			
		for (int k = 0; k< indexValues.size();k++) {
			stringNos=indexValues.get(k).replaceAll("[^0-9]","");
			
//Loop through the extracted String numbers and method that checks if the string is not empty then parse to a number
//And save to a numbersList
			for(int g =0; g<stringNos.length();g++) {
				checksStringNos(g);
			}
		}
		
		int[] nosArray = new int[numberList.size()];
//Loop through the numbersList and convert to an array created above				
		for(int l = 0; l< numberList.size();l++) {
			nosArray[l]= numberList.get(l);
		}
		
//Sort Array to get the lowest number		
		Arrays.sort(nosArray);
		
//If nosArray.length is not equal to 0 (if the restaurant location was found in the list)
//Then save the index 0 as this would be the lowest number after being sorted
		if (nosArray.length != 0) {
			lowestNumber = nosArray[0];
		}
		
//Convert the number back to a string			
		lowestNumberString = Integer.toString(lowestNumber);
		
//Loop through indexValues and method that matches the lowestNoString and gets the value of that index	
		for(int m = 0; m< indexValues.size();m++) {
			findDriverLine(m);
		}
		
//Method that extracts the Drivers name and Surname and sets the driverOutput if there are values
//in DriverLine
		extractDriver(nosArray);
		
//If restaurant location was not found  and driver is not in same area as customer then set the driverOutput to this message	
		if (nosArray.length == 0 || !driverLine.contains(Customer.getCustLocation())) {
			driverOutput();
		}
	}
	
	
	
	
//HELPER METHODS	
	
//Method that finds the index of the line if it contains the restaurant location
//And saves the indexes
	private ArrayList<Integer> findMatchingIndexes(int i) {
		int temp6 = 0;
		if (driversList.get(i).contains(Restaurant.restLocation)){
			temp6 = driversList.indexOf(driversList.get(i));
		}
		indexes.add(temp6);
		return indexes;
	}
	
		
//Method that checks the String numbers and if its not empty it parses it to an integer.
//And saves to a numbersList
	private ArrayList<Integer> checksStringNos(int g) {
		int numbers; 
		if (stringNos.charAt(g)!=(' ')) {
			numbers = Integer.parseInt(stringNos);
			numberList.add(numbers);
		}
		return numberList;
	}


//Method that matches the lowestNoString and gets the value of that index
	private String findDriverLine(int m) {
		String pattern = "\\b" + lowestNumberString+ "\\b";
		Pattern p =Pattern.compile(pattern);
		Matcher match =p.matcher(indexValues.get(m));
		if(match.find()) {
			driverLine = indexValues.get(m);
	}
	return driverLine;
}
	
	
	private String extractDriver(int[] nosArray) {
		ArrayList<String>temp10 = new ArrayList<>();
		StringBuilder driversName = new StringBuilder();
		String[] driverLine1;
		String driver;
		String 	driver1;
//if there are values in driverLine then split the values and only save the name and surname 
//of the driver and remove the comma		
		if (driverLine != null) {
			driverLine1 = driverLine.split(" ");
			for (int p =0;p< driverLine1.length;p++) {
				temp10.add(driverLine1[0]);
				temp10.add(driverLine1[1]);
				temp10.remove((","));
			}
//Convert drivers name and surname to string and remove comma			
			for (int u = 0; u<2;u++) {
				driversName.append(temp10.get(u)+ " ");
			}
			driver1 = driversName.toString();
			driver= driver1.replaceAll(","," ");
//if restaurant location was found then set the driverOutput with the driver name and surname 
//And message			
			if (nosArray.length != 0) {
				driverOutput = driver + "is nearest to the restaurant and so he will be delivering your \r\n"
				+ "order to you at:";
			} 
		}
		return driverOutput;
	}
	
	
//Method that outputs this message if the driver is not in the same area as customer
	private void driverOutput() {
		driverOutput ="Sorry! Our\r\n"
				+ "drivers are too far away from you to be able to\r\n"
				+ "deliver to your location.";
	}
	
	public static String getDriverOutput() {
		return driverOutput;
		}
}
