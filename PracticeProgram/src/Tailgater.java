/*
 * The purpose of this class is to
 * model a Tailgater as an object.
 * 
 * author Sal LaMarca
 * CSCI 1301
 */
public class Tailgater {

	/* The number of drinks in the water bottle cooler */
	private static int drinksInCooler = 12;
	/* The number of Tailgater objects created */
	private static int numberOfTailgaters = 0;

	/* This Tailgater's name */
	private String name = "";
	/* True if this Tailgater is a UGA fan; false otherwise */
	private boolean isUgaFan = true;
	/* This Tailgater's number of drinks of water bottles */
	private int drinks = 0;

	/*
	 * Construct a Tailgater object with the given name
	 * and isUgaFan.  If isUgaFan is set to false,
	 * then this constructor will teach you a lesson.
	 * 
	 *  param name - This Tailgater's name
	 *  param isUgaFan - true if this Tailgater is a UGA fan; false otherwise
	 */
	public Tailgater(String name, boolean isUgaFan){
		if(!isUgaFan){
			while(true){
				System.out.println("Go Dawgs!!!!!");
			}
		}
		this.isUgaFan = isUgaFan;
		this.name = name;
		numberOfTailgaters++;
	}

	/*
	 * Return this Tailgater's name.
	 */
	public String getName(){
		return name;
	}

	/*
	 * Return true if this Tailgater is a fan of UGA;
	 * false otherwise.
	 */
	public boolean isUgaFan(){
		return isUgaFan;
	}

	/*
	 * Remove a drink from the water cooler if the
	 * cooler isn't empty, and print a message
	 * about the state of the cooler.  If  the 
	 * cooler is empty, then this method does
	 * nothing.
	 */
	public void getDrinkFromCooler(){
		if(!isCoolerEmpty()){
			this.drinks++;
			drinksInCooler--;
			System.out.println(this.name + " gets a drink from the cooler.");
			System.out.println("Drinks In Cooler:  " + Tailgater.drinksInCooler + "\n");
		}
	}

	/*
	 * Return true if the water cooler is empty; false otherwise.
	 */
	public static boolean isCoolerEmpty(){
		return drinksInCooler <= 0;
	}

	/*
	 * Add drinks to water cooler, and print a message about
	 * the state of the cooler.
	 * 
	 * param drinks - the number of drinks to add to the cooler
	 * Precondition:  drinks >= 0
	 */
	public static void addDrinksToCooler(int drinks){
		drinksInCooler += drinks;
		System.out.println(drinks + " drinks added to the cooler.");
		System.out.println("Drinks In Cooler:  " + Tailgater.drinksInCooler + "\n");
	}

	/*
	 * Return a string representation of the fields in this Tailgater.
	 */
	public String toString(){
		String tailgaterStr = "Name:  " + this.name + "\n";
		tailgaterStr += "UGA fan:  ";
		if(isUgaFan){
			tailgaterStr += "Yes\n";
		}
		else{
			tailgaterStr += "No\n";
		}
		tailgaterStr += "Drinks:  " + drinks + "\n";
		tailgaterStr += "Drinks In Cooler:  " + drinksInCooler + "\n";
		tailgaterStr += "Number of Tailgaters:  " + numberOfTailgaters + "\n";
		return tailgaterStr;
	}

	/*
	 * Simulate a Tailgating party scenario by creating some Tailgaters
	 * and calling their methods.
	 * 
	 */
	public static void main(String[] args){

		Tailgater daenerys = new Tailgater("Daenerys Targaryen", true);
		System.out.println(daenerys);

		Tailgater tyrion = new Tailgater("Tyrion Lannister", true);
		System.out.println(tyrion);

		Tailgater arya = new Tailgater("Arya Stark", true);
		System.out.println(arya);

		Tailgater cloud = new Tailgater("Cloud", true);
		System.out.println(cloud);

		Tailgater cloudClone = new Tailgater(cloud.getName() + " Clone", cloud.isUgaFan);
		System.out.println(cloudClone);
		
		tyrion.getDrinkFromCooler();
		daenerys.getDrinkFromCooler();
		cloud.getDrinkFromCooler();
		cloudClone.getDrinkFromCooler();
		arya.getDrinkFromCooler();

		for(int i = 1; i <= 3; i++){
			cloud.getDrinkFromCooler();
			cloudClone.getDrinkFromCooler();
		}

		System.out.println(cloud);
		System.out.println(cloudClone);
		Tailgater.addDrinksToCooler(24);
		
	}

}