import java.util.Random;
/*
 *  This class contains a computer player for
 *  RockPaperScissorsLizardSpock game.
 *  @author Sal LaMarca
 *  CSCI 1301
 */
public class RockPaperScissorsLizardSpockComputerPlayer {

	//A pseudorandom number generator used by the computer player
	private static Random randomNumberGenerator = new Random();
	
	//The number of calls to getChoice()
	private static int callsToGetChoice = 0;
	
	/*
	 * Return a pseudorandom String choice of "rock", "paper", "scissors",
	 * "lizard", or "spock" from a computer player.
	 * Note:  This method will return an error and exit if it is called
	 * more than three times by your program.
	 */
	public static String getChoice(){
		//Keep track of how many times this method is called
		callsToGetChoice++;
		if(callsToGetChoice > 3){
			System.out.println("Error:  Your programmed called getChoice() more than three times.");
			System.exit(0);			
		}
		
		//Return a pseudorandom gesture of rock, paper, scissors, lizard, or spock. 
		int randomNumber = randomNumberGenerator.nextInt(5);
		if(randomNumber == 0){ 
			return "rock";
		}
		if(randomNumber == 1){
			return "paper";
		}
		if(randomNumber == 2){ 
			return "scissors";
		}
		if(randomNumber == 3){ 
			return "lizard";
		}
		return "spock";
	}
	
}
