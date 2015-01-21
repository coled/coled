import java.util.Scanner;

/*
* [MultipleChoiceFlashCardsVersion2].java
* Author: [Cole Downing]
* Submission Date: [7-11-13]
*
* Purpose: A brief paragraph description of the * program. What does it do? How does it do it? *
* This is a multiple choice flash card game that allows the user to play on 4 different 
* levels of difficulty. It uses while loops to continuously re-prompt questions as long as 
* the user integers the correct input when prompted for next question. The program uses multiple 
* integer variable counters to keep up with incorrect answers, number of questions, score, and
* possible score. The program also uses boolean statements to determine when to end the game, and 
* when a new game has started. the rest of the variables are of the type string.
* The program mostly consists of nested if else statements and if statements, inside a few 
* large while loops. 
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
* on a programming project created by the Department of
* Computer Science at the University of Georgia. Any publishing
* of source code for this project is strictly prohibited without
* written consent from the Department of Computer Science. */

public class MultipleChoiceFlashCardsVersion2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String questionAndChoices;  // declaring all variables
		String choiceA;
		String choiceB;
		String choiceC;
		String choiceD;
		String answer;
		String userInput;
		String userAnswer;
		int score=0;
		int numberOfGames=0;
		int possibleScore=0;
		String gameStart="";
		String difficulty="";
		int incorrectAnswers=0;
		String difficultyLevel="";
		boolean gameOver=false;  // decision variable game over, controls game's while loops. 
		boolean newGame=false;  // decision variable for clearing score and point values

		Scanner keyboard = new Scanner(System.in);
		System.out.print("Want to play a game of CSCI Multiple Choice Flash Cards (y/n)? ");
		gameStart= keyboard.next();				// prompts user for starting game
		gameStart = gameStart.substring(0,1);


		while(!gameStart.equalsIgnoreCase("n") && !gameStart.equalsIgnoreCase("y"))
		{
			System.out.print("Want to play a game of CSCI Multiple Choice Flash Cards (y/n)? ");
			gameStart= keyboard.next();
			gameStart = gameStart.substring(0,1); //only takes index 0 of the user's input string
		}

		if(gameStart.equalsIgnoreCase("n"))  // if no, then
		{
			System.out.println("You played "+ numberOfGames + " game(s) \nGoodbye");
			System.exit(0);
		}
		else
			while(!newGame){        // if yes, then prompt for difficulty
				gameOver=false;
				System.out.println("");
				System.out.println("Enter the difficulty level or quit (1-5):");
				System.out.println("1. Easy (5 incorrect answers allowed)");
				System.out.println("2. Standard (3 incorrect answers allowed)");
				System.out.println("3. Difficult (2 incorrect answers allowed)");
				System.out.println("4. Elite (1 incorrect answer allowed)");
				System.out.println("5. Quit");
				System.out.print(">> ");

				difficulty = keyboard.next();  // taking only index 0 of user input
				difficulty = difficulty.substring(0,1);

				while(!difficulty.equalsIgnoreCase("1") && !difficulty.equalsIgnoreCase("2") && !difficulty.equalsIgnoreCase("3") 
						&& !difficulty.equalsIgnoreCase("4") && !difficulty.equalsIgnoreCase("5")) // input must be 1,2,3,4 or 5
					{	
					System.out.println("Enter the difficulty level or quit (1-5):");   // prompting for difficulty with while loop
					System.out.println("1. Easy (5 incorrect answers allowed)");
					System.out.println("2. Standard (3 incorrect answers allowed)");
					System.out.println("3. Difficult (2 incorrect answers allowed)");
					System.out.println("4. Elite (1 incorrect answer allowed)");
					System.out.println("5. Quit");
					System.out.print(">> ");
					difficulty = keyboard.next();
					}
		// nested if else statements used to set string difficultyLevel to user selected level
				if(difficulty.equalsIgnoreCase("1"))
				{
					incorrectAnswers = 5;  
					difficultyLevel ="easy";
				}	
					else if(difficulty.equalsIgnoreCase("2"))
					{
						incorrectAnswers = 3;
						difficultyLevel ="standard";
					}

						else if(difficulty.equalsIgnoreCase("3"))
						{
							incorrectAnswers = 2;
							difficultyLevel = "difficult";
						}

							else if(difficulty.equalsIgnoreCase("4"))
							{
								incorrectAnswers = 1;
								difficultyLevel = "elite";
							}

								else if(difficulty.equalsIgnoreCase("5"))
								{
									System.out.println("You played "+ numberOfGames + " game(s) \nGoodbye");
									System.exit(0);
								}
				
				numberOfGames++;  // counts number of new games, as while loop for game start is repeated.

				while(!newGame)  // while loop that repeats for next question, if user enters (y)
				{
					System.out.println(""); // getting strings for questions and answers
					questionAndChoices = MultipleChoiceFlashCardsZoeyGameEngine002.getQuestionAndChoices();
					choiceA = MultipleChoiceFlashCardsZoeyGameEngine002.getChoiceA();
					choiceB = MultipleChoiceFlashCardsZoeyGameEngine002.getChoiceB();
					choiceC = MultipleChoiceFlashCardsZoeyGameEngine002.getChoiceC();
					choiceD = MultipleChoiceFlashCardsZoeyGameEngine002.getChoiceD();
					answer = MultipleChoiceFlashCardsZoeyGameEngine002.getAnswer();

					possibleScore++; // counter for possible points, increases per new question

					System.out.print(questionAndChoices);
					System.out.print("Enter your answer (a-d): ");  // prints question, prompts for answer, and gets user input
					userInput = keyboard.next();
					userAnswer = userInput.substring(0,1);

					while(!userAnswer.equalsIgnoreCase("a") && !userAnswer.equalsIgnoreCase("b") &&
							!userAnswer.equalsIgnoreCase("c") && !userAnswer.equalsIgnoreCase("d"))
					{
						System.out.print(questionAndChoices);
						System.out.print("Enter your answer (a-d): ");
						userInput = keyboard.next();
						userAnswer = userInput.substring(0,1);
					}

					if (userAnswer.equalsIgnoreCase("a"))   //setting user answer equal to actual answers from question
					{
						userAnswer= choiceA;
					}

						else if(userAnswer.equalsIgnoreCase("b")) 
						{
							userAnswer= choiceB;
						}

							else if(userAnswer.equalsIgnoreCase("c"))
							{
								userAnswer= choiceC;
							}

								else if(userAnswer.equalsIgnoreCase("d"))
								{
									userAnswer = choiceD;
								}


					if(userAnswer.equalsIgnoreCase(answer)) // output for correct answer, increase score
					{
						score++;
						System.out.println("Correct Answer");
						System.out.println("Your score: " + score+ " out of "+ possibleScore +" point(s)\n");
					}
					else
					{
						incorrectAnswers--;	// output for incorrect answer, minus 1 to incorrect counter
						System.out.println("Incorrect Answer");
						System.out.println("Your score: " + score+ " out of "+ possibleScore +" point(s)\n");
					}

					if(incorrectAnswers==0) // checks to see if max incorrect answers was reached, if so end game
					{
						System.out.println("Your game played on the "+ difficultyLevel + " difficulty level has ended");
						System.out.println("Your final score: "+score+" out of "+ possibleScore +" point(s)");
						System.out.println("Game Over");
						possibleScore=0; // reset
						gameOver=true; // maybe add code here for new game??
					}
					else
					{
						System.out.print("Proceed to next question (y/n)? ");  
						gameStart= keyboard.next();
						gameStart = gameStart.substring(0,1);

						while(!gameStart.equalsIgnoreCase("n") && !gameStart.equalsIgnoreCase("y"))
							// while loop to catch invalid input
						{
							System.out.print("Proceed to next question (y/n)? ");
							gameStart= keyboard.next();
							gameStart = gameStart.substring(0,1);  // prompt and gets user input for next question
						}

						if(gameStart.equalsIgnoreCase("n")) // end of game output
						{
							System.out.println("Your game played on the "+ difficultyLevel + " difficulty level has ended");
							System.out.println("Your final score: "+score+" out of "+ possibleScore +" point(s)");
							System.out.println("Game Over\n");
							possibleScore=0; // sets counter variable posiibleScore back to zero 
							gameOver=true; // game over boolean, used for below if statement. 
						}
					} // end else statement
					// while loop end
					
					if(gameOver==true) // if game is over, then user is prompted to play a new game
					{
						System.out.print("\nWant to play another game of CSCI Multiple Choice Flash Cards (y/n)? ");
						gameStart= keyboard.next();
						gameStart = gameStart.substring(0,1);

						while(!gameStart.equalsIgnoreCase("n") && !gameStart.equalsIgnoreCase("y"))
						{ // while loop catches invalid input and re-prompts. 
							System.out.print("Want to play another game of CSCI Multiple Choice Flash Cards (y/n)? ");
							gameStart= keyboard.next();
							gameStart = gameStart.substring(0,1);
						}

							if(gameStart.equalsIgnoreCase("n")) // if user does not want to play again, exits system.
							{
								System.out.println("You played " + numberOfGames+ " game(s)");
								System.out.println("Goodbye");
								System.exit(0);
							}
							else
							{
								score=0;
								newGame=true;
							}
					} // end of if statement / while loop for new game prompt

				}	// while loop end / goes to next question

				if(newGame=true)
					{
						newGame=false;
					}


			}// end while loop starting at difficulty prompt, new game starts


	}}
