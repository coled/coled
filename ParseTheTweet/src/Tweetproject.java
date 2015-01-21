import java.util.Scanner;

public class Tweetproject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	

	
	Scanner theScanner = new Scanner(System.in);
		


String tweet = "";

	String type;
	String detail;
	String location;
	String latitudeString;
	String longitudeString;
	double latitude;
	double longitude;
	

	
	tweet = theScanner.nextLine();
	
	int start;
	int finish;
	
	start = tweet.indexOf("#typ" + 5);
	finish = tweet.indexOf(";");
	type = tweet.substring(start + finish);
	type = type.trim();
	tweet = tweet.substring(finish+1);
	
	start = tweet.indexOf("#det" + 5);
	finish = tweet.indexOf(";");
	detail = tweet.substring(start + finish);
	detail = detail.trim();
	tweet = tweet.substring(finish+1);
	
	start = tweet.indexOf("#loc" + 5);
	finish = tweet.indexOf(";");
	location = tweet.substring(start + finish);
	location = location.trim();
	tweet = tweet.substring(finish+1);
	
	start = tweet.indexOf("#lat" + 5);
	finish = tweet.indexOf(";");
	latitudeString = tweet.substring(start + finish);
	latitudeString = latitudeString.trim();
	tweet = tweet.substring(finish+1);
	
	start = tweet.indexOf("#lng" + 5);
	finish = tweet.indexOf(";");
	longitudeString= tweet.substring(start + finish);
	longitudeString = longitudeString.trim();
	tweet = tweet.substring(finish+1);
	
	theScanner = new Scanner(latitudeString);
	latitude = theScanner.nextDouble();
	
	theScanner = new Scanner(longitudeString);
	longitude = theScanner.nextDouble();
	
	type = tweet.toUpperCase();
	detail = tweet.replace(',','-');
	location = tweet.replace(',','-');
		
	System.out.println("type:" + type);
	System.out.println("Detail:" + detail);
	System.out.println("Location:" + location);
	System.out.println("Latitude:" + latitude);
	System.out.println("Longitude:" + longitude);
	
	}}

	
	
	

  
