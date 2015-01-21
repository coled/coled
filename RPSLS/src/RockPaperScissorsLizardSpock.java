/* * [RockPaperScissorsLizardSpock].java * Author: [Cole Downing] * Submission Date: [2-17-15] * * Purpose: A brief paragraph description of the * program. What does it do? A short rock paper scissors lizard spock game.  * * Statement of Academic Honesty: * * The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied * or modified code from any source other than the course webpage * or the course textbook. I recognize that any unauthorized * assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the * policies of this course. I recognize that my work is based * on an assignment created by the Department of Computer * Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly * prohibited unless you have written consent from the Department * of Computer Science at the University of Georgia. */


import java.util.Scanner;

public class RockPaperScissorsLizardSpock {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String gamestart;
		Scanner keyboard = new Scanner(System.in);
		
int error = 0;
int playerscore=0;
int computerscore=0;			
	
System.out.println("Would you like to play Rock Paper" +
		" Scissors Lizard Spock? (y/n)");

gamestart = keyboard.nextLine();
char start = gamestart.charAt(0);

if ((start == 'n') || (start =='N'))	
{
	System.out.println("Goodbye!");
	System.exit(0);
}

		if ((start == 'y') || (start =='Y'))	
		
			
		System.out.println("Round 1\n" + "Which gesture would you like to choose . . .\n" +
		"1)  rock\n" + "2)  paper\n" + "3)  scissors\n" + "4)  lizard\n" + "5)  spock\n" + "Please enter your choice (1-5):"); 

		String computerchoice = "";
		computerchoice =  RockPaperScissorsLizardSpockComputerPlayer.getChoice();
		
		int playerchoice = keyboard.nextInt();
	
		
		 if ((playerchoice > 5) || (playerchoice < 1))
			{
				System.out.println("The input you entered it invalid.");     // figure out how to fix this shit.
				System.out.println("Round 3\n" + "Which gesture would you like to choose . . .\n" +
						"1)  rock\n" + "2)  paper\n" + "3)  scissors\n" + "4)  lizard\n" + "5)  spock\n" + "Please enter your choice (1-5):"); 

			playerchoice = keyboard.nextInt();					}

			if ((playerchoice > 5) || (playerchoice < 1))
		  {
				System.out.println("You entered too many invalid inputs. \nGoodbye!");
				System.exit(0);
		  }
				
		 
		
// round 1 start
switch (playerchoice)
{
case 1:   // if Player chooses rock

	 if (computerchoice == "paper")
	 {
			System.out.println("The computer player chooses " + computerchoice + ". \nPaper covers rock.\nThe computer player wins a point.");
			computerscore++; 
	 }
	 if (computerchoice == "scissors")
	 {
			System.out.println("The computer player chooses " + computerchoice + ".\nRock crushes scissors. \nCongratuliations! You win a point.");
			playerscore++;
	 }
	 if (computerchoice == "lizard")
	 {
			System.out.println("The computer player chooses " + computerchoice + ". \nRock crushes lizard. \nCongratuliations! You win a point.");
			playerscore++;
	 }
	 if (computerchoice == "spock")
	 {
			System.out.println("The computer player chooses " + computerchoice + ".\nSpock vaporizes rock. \nThe computer player wins a point.");
			computerscore++;
	 }
		if  (computerchoice == "rock")
				System.out.println("The computer player chooses " + computerchoice + ".\nYou tied with the computer. No points awarded.");
	break; 
			
case 2: // player chooses paper
	if (computerchoice == "rock")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nPaper covers rock. \nCongratulations! You win a point.");
		 playerscore++;
	}

	if (computerchoice == "paper")	
		System.out.println("The computer player chooses " + computerchoice + ". \nYou tied the computer. No points awarded.");

	if (computerchoice == "scissors")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nScissors cuts paper. \nThe computer player wins a point.");
		computerscore++;
	}

	if (computerchoice == "lizard")
	{
		System.out.println("The computer player chooses " + computerchoice + ". \nLizard eats paper. \nThe computer player wins a point.");
		computerscore++;
	}

	if (computerchoice == "spock")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nPaper disproves spock. \nCongratulations! You win a point.");
		playerscore++;
	}

	break;
	
case 3:  // player chooses scissors

	if (computerchoice == "rock")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nRock crushes scissors. \nThe computer playes wins a point.");
		 computerscore++;
	}
	if ( computerchoice == "paper")
	{
		System.out.println("The computer player chooses " + computerchoice + ". \nScissors cuts paper. \nCongratulations! You win a point.");
		playerscore++;
	}
	if (computerchoice == "scissors")
		System.out.println("The computer player chooses " + computerchoice + ".\nYou tied the computer. No points awarded.");
	
	if (computerchoice == "lizard")
	{
		System.out.println("The computer player chooses " + computerchoice + ". \nSciccors decapitates lizard. \nCongratulations! You win a point.");
		playerscore++;
	}
	if ( computerchoice == "spock")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nSpock smashes scissors. \nThe computer player wins a point.");
		 computerscore++;
	}
	break;
	
case 4:  // player chooses lizard
	if (computerchoice == "rock")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nRock crushes lizard. \nThe computer player wins a point.");
		computerscore++;
	}
	if (computerchoice == "paper")	
	{
		System.out.println("The computer player chooses " + computerchoice + ". \nLizard eats paper. \nCongratulations! You win a point.");
		playerscore++;
	}
	if (computerchoice == "scissors")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nScissors decapitates lizard. \nThe computer player wins a point.");
		 computerscore++;
	}

	if (computerchoice == "lizard")

		System.out.println("The computer player chooses " + computerchoice + ". \nYou tied the computer. No points awarded.");


	if (computerchoice == "spock")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nLizard poisons spock. \nCongratulations! You win a point.");
		 playerscore++;
	}
	
	break;
case 5:  // player chooses spock
	
	if (computerchoice == "rock")
	{
			System.out.println("The computer player chooses " + computerchoice + ".\nSpock vaporizes rock. \nCongratulations! You win a point.");
			playerscore++;
	}
		if (computerchoice == "paper")	
		{
			System.out.println("The computer player chooses " + computerchoice + ". \nPaper disproves spock. \nThe computer player wins a point.");
			 computerscore++;
		}
		if (computerchoice == "scissors")
		{
			System.out.println("The computer player chooses " + computerchoice + ".\nSpock smashes scissors. \nCongratulations! You win a point.");
			 playerscore++;
		}

		if (computerchoice == "lizard")
		{
			System.out.println("The computer player chooses " + computerchoice + ". \nLizard poisons spock. \nThe computer player wins a point.");
			 computerscore++;
		}
		if (computerchoice == "spock")
	
			System.out.println("The computer player chooses " + computerchoice + ".\nYou tied the computer. No points awarded.");

	break;
	}
		

	// round 2
		System.out.println("\nRound 2\n" + "Which gesture would you like to choose . . .\n" +
				"1)  rock\n" + "2)  paper\n" + "3)  scissors\n" + "4)  lizard\n" + "5)  spock\n" + "Please enter your choice (1-5):"); 

		computerchoice =  RockPaperScissorsLizardSpockComputerPlayer.getChoice();
		 playerchoice = keyboard.nextInt();
		
		 if ((playerchoice > 5) || (playerchoice < 1))
			{
				System.out.println("The input you entered it invalid.");     // figure out how to fix this shit.
				System.out.println("Round 2\n" + "Which gesture would you like to choose . . .\n" +
						"1)  rock\n" + "2)  paper\n" + "3)  scissors\n" + "4)  lizard\n" + "5)  spock\n" + "Please enter your choice (1-5):"); 

			playerchoice = keyboard.nextInt();
			}

			if ((playerchoice > 5) || (playerchoice < 1))
		  {
				System.out.println("You entered too many invalid inputs. \nGoodbye!");
				System.exit(0);
		  }
					
			{

switch (playerchoice)  // round 2 start
{
case 1:   // Player chooses rock

	 if (computerchoice == "paper")
	 {
			System.out.println("The computer player chooses " + computerchoice + ". \nPaper covers rock.\nThe computer player wins a point.");
			computerscore++; 
	 }
	 if (computerchoice == "scissors")
	 {
			System.out.println("The computer player chooses " + computerchoice + ".\nRock crushes scissors. \nCongratuliations! You win a point.");
			playerscore++;
	 }
	 if (computerchoice == "lizard")
	 {
			System.out.println("The computer player chooses " + computerchoice + ". \nRock crushes lizard. \nCongratuliations! You win a point.");
			playerscore++;
	 }
	 if (computerchoice == "spock")
	 {
			System.out.println("The computer player chooses " + computerchoice + ".\nSpock vaporizes rock. \nThe computer player wins a point.");
			computerscore++;
	 }
		if  (computerchoice == "rock")
				System.out.println("The computer player chooses " + computerchoice + ".\nYou tied with the computer. No points awarded.");
	break; 
			
case 2: // player chooses paper
	if (computerchoice == "rock")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nPaper covers rock. \nCongratulations! You win a point.");
		 playerscore++;
	}

	if (computerchoice == "paper")	
		System.out.println("The computer player chooses " + computerchoice + ". \nYou tied the computer. No points awarded.");

	if (computerchoice == "scissors")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nScissors cuts paper. \nThe computer player wins a point.");
		computerscore++;
	}

	if (computerchoice == "lizard")
	{
		System.out.println("The computer player chooses " + computerchoice + ". \nLizard eats paper. \nThe computer player wins a point.");
		computerscore++;
	}

	if (computerchoice == "spock")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nPaper disproves spock. \nCongratulations! You win a point.");
		playerscore++;
	}

	break;
	
case 3:  // player chooses scissors

	if (computerchoice == "rock")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nRock crushes scissors. \nThe computer playes wins a point.");
		 computerscore++;
	}
	if ( computerchoice == "paper")
	{
		System.out.println("The computer player chooses " + computerchoice + ". \nScissors cuts paper. \nCongratulations! You win a point.");
		playerscore++;
	}
	if (computerchoice == "scissors")
		System.out.println("The computer player chooses " + computerchoice + ".\nYou tied the computer. No points awarded.");
	
	if (computerchoice == "lizard")
	{
		System.out.println("The computer player chooses " + computerchoice + ". \nSciccors decapitates lizard. \nCongratulations! You win a point.");
		playerscore++;
	}
	if ( computerchoice == "spock")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nSpock smashes scissors. \nThe computer player wins a point.");
		 computerscore++;
	}
	break;
	
case 4:  // player chooses lizard
	if (computerchoice == "rock")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nRock crushes lizard. \nThe computer player wins a point.");
		computerscore++;
	}
	if (computerchoice == "paper")	
	{
		System.out.println("The computer player chooses " + computerchoice + ". \nLizard eats paper. \nCongratulations! You win a point.");
		playerscore++;
	}
	if (computerchoice == "scissors")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nScissors decapitates lizard. \nThe computer player wins a point.");
		 computerscore++;
	}

	if (computerchoice == "lizard")

		System.out.println("The computer player chooses " + computerchoice + ". \nYou tied the computer. No points awarded.");


	if (computerchoice == "spock")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nLizard poisons spock. \nCongratulations! You win a point.");
		 playerscore++;
	}
	
	break;
case 5:  // player chooses spock
	
	if (computerchoice == "rock")
	{
			System.out.println("The computer player chooses " + computerchoice + ".\nSpock vaporizes rock. \nCongratulations! You win a point.");
			playerscore++;
	}
		if (computerchoice == "paper")	
		{
			System.out.println("The computer player chooses " + computerchoice + ". \nPaper disproves spock. \nThe computer player wins a point.");
			 computerscore++;
		}
		if (computerchoice == "scissors")
		{
			System.out.println("The computer player chooses " + computerchoice + ".\nSpock smashes scissors. \nCongratulations! You win a point.");
			 playerscore++;
		}

		if (computerchoice == "lizard")
		{
			System.out.println("The computer player chooses " + computerchoice + ". \nLizard poisons spock. \nThe computer player wins a point.");
			 computerscore++;
		}
		if (computerchoice == "spock")
	
			System.out.println("The computer player chooses " + computerchoice + ".\nYou tied the computer. No points awarded.");
		
	break;
	}
		

	// round 3
 
		 	System.out.println("\nRound 3\n" + "Which gesture would you like to choose . . .\n" +
						"1)  rock\n" + "2)  paper\n" + "3)  scissors\n" + "4)  lizard\n" + "5)  spock\n" + "Please enter your choice (1-5):"); 
			
				computerchoice =  RockPaperScissorsLizardSpockComputerPlayer.getChoice();
				 playerchoice = keyboard.nextInt();
				
				 if ((playerchoice > 5) || (playerchoice < 1))
					{
						System.out.println("The input you entered it invalid.");     // figure out how to fix this shit.
						System.out.println("Round 3\n" + "Which gesture would you like to choose . . .\n" +
								"1)  rock\n" + "2)  paper\n" + "3)  scissors\n" + "4)  lizard\n" + "5)  spock\n" + "Please enter your choice (1-5):"); 

					playerchoice = keyboard.nextInt();					}

					if ((playerchoice > 5) || (playerchoice < 1))
				  {
						System.out.println("You entered too many invalid inputs. \nGoodbye!");
						System.exit(0);
				  }
							
					
switch (playerchoice)  // round 3 starts
{
case 1:   // Player chooses rock

	 if (computerchoice == "paper")
	 {
			System.out.println("The computer player chooses " + computerchoice + ". \nPaper covers rock.\nThe computer player wins a point.");
			computerscore++; 
	 }
	 if (computerchoice == "scissors")
	 {
			System.out.println("The computer player chooses " + computerchoice + ".\nRock crushes scissors. \nCongratuliations! You win a point.");
			playerscore++;
	 }
	 if (computerchoice == "lizard")
	 {
			System.out.println("The computer player chooses " + computerchoice + ". \nRock crushes lizard. \nCongratuliations! You win a point.");
			playerscore++;
	 }
	 if (computerchoice == "spock")
	 {
			System.out.println("The computer player chooses " + computerchoice + ".\nSpock vaporizes rock. \nThe computer player wins a point.");
			computerscore++;
	 }
		if  (computerchoice == "rock")
				System.out.println("The computer player chooses " + computerchoice + ".\nYou tied with the computer. No points awarded.");
	break; 
			
case 2: // player chooses paper
	if (computerchoice == "rock")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nPaper covers rock. \nCongratulations! You win a point.");
		 playerscore++;
	}

	if (computerchoice == "paper")	
		System.out.println("The computer player chooses " + computerchoice + ". \nYou tied the computer. No points awarded.");

	if (computerchoice == "scissors")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nScissors cuts paper. \nThe computer player wins a point.");
		computerscore++;
	}

	if (computerchoice == "lizard")
	{
		System.out.println("The computer player chooses " + computerchoice + ". \nLizard eats paper. \nThe computer player wins a point.");
		computerscore++;
	}

	if (computerchoice == "spock")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nPaper disproves spock. \nCongratulations! You win a point.");
		playerscore++;
	}

	break;
	
case 3:  // player chooses scissors

	if (computerchoice == "rock")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nRock crushes scissors. \nThe computer playes wins a point.");
		 computerscore++;
	}
	if ( computerchoice == "paper")
	{
		System.out.println("The computer player chooses " + computerchoice + ". \nScissors cuts paper. \nCongratulations! You win a point.");
		playerscore++;
	}
	if (computerchoice == "scissors")
		System.out.println("The computer player chooses " + computerchoice + ".\nYou tied the computer. No points awarded.");
	
	if (computerchoice == "lizard")
	{
		System.out.println("The computer player chooses " + computerchoice + ". \nSciccors decapitates lizard. \nCongratulations! You win a point.");
		playerscore++;
	}
	if ( computerchoice == "spock")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nSpock smashes scissors. \nThe computer player wins a point.");
		 computerscore++;
	}
	break;
	
case 4:  // player chooses lizard
	if (computerchoice == "rock")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nRock crushes lizard. \nThe computer player wins a point.");
		computerscore++;
	}
	if (computerchoice == "paper")	
	{
		System.out.println("The computer player chooses " + computerchoice + ". \nLizard eats paper. \nCongratulations! You win a point.");
		playerscore++;
	}
	if (computerchoice == "scissors")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nScissors decapitates lizard. \nThe computer player wins a point.");
		 computerscore++;
	}

	if (computerchoice == "lizard")

		System.out.println("The computer player chooses " + computerchoice + ". \nYou tied the computer. No points awarded.");


	if (computerchoice == "spock")
	{
		System.out.println("The computer player chooses " + computerchoice + ".\nLizard poisons spock. \nCongratulations! You win a point.");
		 playerscore++;
	}
	
	break;
case 5:  // player chooses spock
	
	if (computerchoice == "rock")
	{
			System.out.println("The computer player chooses " + computerchoice + ".\nSpock vaporizes rock. \nCongratulations! You win a point.");
			playerscore++;
	}
		if (computerchoice == "paper")	
		{
			System.out.println("The computer player chooses " + computerchoice + ". \nPaper disproves spock. \nThe computer player wins a point.");
			 computerscore++;
		}
		if (computerchoice == "scissors")
		{
			System.out.println("The computer player chooses " + computerchoice + ".\nSpock smashes scissors. \nCongratulations! You win a point.");
			 playerscore++;
		}

		if (computerchoice == "lizard")
		{
			System.out.println("The computer player chooses " + computerchoice + ". \nLizard poisons spock. \nThe computer player wins a point.");
			 computerscore++;
		}
		if (computerchoice == "spock")
	
			System.out.println("The computer player chooses " + computerchoice + ".\nYou tied the computer. No points awarded.");
		
	break;
	}
		
				 
// end of game 

 
			System.out.println("\nGame Over\nYour final score is " + playerscore + ". ");
			System.out.println("The computer player's final score is " + computerscore + ". ");
			
			if (playerscore > computerscore)
				System.out.println("Congratulations! You won against the computer player.");
			if (playerscore < computerscore)
				System.out.println("You lost against the computer player.");
			if (playerscore == computerscore)
				System.out.println("You tied with the computer.");
			
			System.out.println("Goodbye!");
	}

	// catch invalid input from gamestart
if (start != 'y')
{
System.out.println("The input you entered is invalid.");
gamestart = keyboard.nextLine();


if (start != 'y')	
{
	System.out.println("You entered too many invalid inputs.\nGoodbye!");
	System.exit(0);
}}}}
			
			



	





	
	
	
	
	
		
		
	


