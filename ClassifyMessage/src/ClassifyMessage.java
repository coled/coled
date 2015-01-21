
import java.util.Scanner;

/*
 * [ClassifyMessage].java
 * Author: [Cole Downing ] 
 * Submission Date: [6-20-13]
 *
 * Purpose: A brief paragraph description of the
 * program. What does it do? Uses if else statements to classify short 
 * messages like tweets from twitter.
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this project is strictly
 * prohibited unless you have written consent from the Department 
 * of Computer Science at the University of Georgia. 
 */





public class ClassifyMessage {

	enum MessageCategory {NEED, OFFER, ALERT, INFO, UNKNOWN}

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		String catString; //The raw text of the messae's category
		String payload;   // The primary content of the message
		double latitude; // the latitude indicated in the message
		double longitude; // The longitude indicated in the message
		boolean isInRange; // A "flag" indicating whether the latitude and longitude values are within bounds

		MessageCategory category; // the message's category

		double south = 39.882343; //southernmost latitude
		double north = 40.231315; // northernmost latitude
		double west = -105.743511; // westernmost longitude
		double east = -104.907864; // easternmost longitude

		System.out.println("Please enter a formatted message:");

	
		
		catString = keyboard.next();
		latitude = keyboard.nextDouble();
		longitude = keyboard.nextDouble();
		payload = keyboard.nextLine();
		payload = payload.trim();
		catString.trim();


		if (catString.equalsIgnoreCase("fire"))
			category = MessageCategory.ALERT;
		else if (catString.equalsIgnoreCase("smoke"))
			category = MessageCategory.ALERT;
		else if (catString.equalsIgnoreCase("need"))
			category = MessageCategory.NEED;
		else if (catString.equalsIgnoreCase("offer"))
			category = MessageCategory.OFFER;
		else if (catString.equalsIgnoreCase("structure"))
			category = MessageCategory.INFO;
		else if (catString.equalsIgnoreCase("road"))
			category = MessageCategory.INFO;
		else if (catString.equalsIgnoreCase("photo"))
			category = MessageCategory.INFO;
		else if (catString.equalsIgnoreCase("evac"))
			category = MessageCategory.INFO;
		else category = MessageCategory.UNKNOWN;


		if ((latitude >= south && latitude <= north) &&(longitude >= west && longitude <= east))
			isInRange = true;
		else
			isInRange = false;


			System.out.println("Category:\t" + category);
			System.out.println("Raw Cat: \t" + catString);
			System.out.println("Message:\t" + payload);
			System.out.println("Latitude:\t" + latitude);
			System.out.println("Longitude:\t" + longitude);
			System.out.println("In Range:\t" + isInRange);






	}

}
