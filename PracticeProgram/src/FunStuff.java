import java.util.Scanner;

public class FunStuff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name;
		String choice;
		String answer;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Welcome to Haunted Mansion!");
		System.out.println("To start, enter your name.");
		
		name = keyboard.nextLine();
		
		System.out.println("Congratulations " + name); 
		System.out.println("You've been kiddnapped and taken to the abandondd mansion outside of town." +
				" \n Rumours are that it's haunted. Good luck finding a way out!");
		System.out.println("You are tied to a chair and blindfolded. Will you wait for rescue or chew" +
				" \n the rope apart?: Enter (wait) or (chew)");
		
	choice = keyboard.nextLine();
	
	if(choice.equals("wait"));
	{
	 // System.out.println("You starved to death, too bad.");}
	 if(choice.equals("chew"));
	{// System.out.println("You were able to chew through the rope binding your hands.");}
	System.out.println("You have removed your blindfold and notice a door straight ahead \n and a ladder behind you." +
			"\n To go through the door enter (door) " +
			"\n To go up the ladder type (ladder).");
	}
		
	choice = keyboard.nextLine();
	
	{if(choice.equals("door"));
	 {//System.out.println("You turn the handle of the rusty metal door. \n" The handle squeaks as you open it slowly. You enter a hallway.");
	 System.out.println("You see mirror at the end of the hallway \n as well as a staircase leading upstairs.");
		System.out.println("Enter (mirror) or (stairs)");}
	 
	 choice = keyboard.nextLine();
	 
	 {if(choice.equals("mirror"));
	 System.out.println("You see a hazy reflection in the mirror. \n A voice whispers the riddle,'Why is a raven like a writing desk?'");
	 
	 choice = keyboard.nextLine();
	 {if(choice.equals("poe wrote on both"));
	 System.out.println("The mirror slides up and reveals a secret elevator.");
	 {if(!choice.equals("poe wrote on both"));
	 System.out.println("A trap door opens beneath you and you fall into a dark musty pit");
	 
	 }
	 if(choice.equals("stairs"));
	 System.out.println("You walk up the flight of stairs.\n You reach the top, and see two doors. \n " +
	 		"One on the left and one on the right. \n You also notice a picture on the wall with something written on it.");
	 System.out.println("Enter (left), (right), or (picture).");
	 choice = keyboard.nextLine();
	 
	 
	 }
	 
	 
	 {if(choice.equals("ladder"));
	 System.out.println("You climb up the rotten wood ladder and come up on the floor of a dusty wine cellar.");
	 
	 System.out.println("You hear someone, or something climbing up the ladder to the cellar. \n" +
	 		" Will you (wait) or (hide)?");

	}}}}}	
}
		
	

