import java.util.Scanner;

/*
 * [MultipleChoiceFlashCards].java
 * Author:  [Cole Downing]
 * Submission Date:  [6-27-13]
 *
 * Purpose: A brief paragraph description of the
 * program. What does it do?
 * This program randomly generates 3 multiple choice study questions
 * for CSCI 1301 review.It also keeps score. 
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
* prohibited unless you have written consent from the Department * of Computer Science at the University of Georgia.
*/


public class MultipleChoiceFlashCards {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
// declaring all variables
		String questionAndChoices;
		String choiceA;
		String choiceB;
		String choiceC;
		String choiceD;
		String answer;
		String userInput;
		String userAnswer;
		int score=0;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Welcome to CSCI 1301 Multiple Choice Flash Cards!\n");
		{
		{
		//question 1 start
		questionAndChoices = MultipleChoiceFlashCardsZoeyGameEngine001.getQuestionAndChoices(); 
		choiceA = MultipleChoiceFlashCardsZoeyGameEngine001.getChoiceA();
		choiceB = MultipleChoiceFlashCardsZoeyGameEngine001.getChoiceB();
		choiceC = MultipleChoiceFlashCardsZoeyGameEngine001.getChoiceC();
		choiceD = MultipleChoiceFlashCardsZoeyGameEngine001.getChoiceD(); 
		answer = MultipleChoiceFlashCardsZoeyGameEngine001.getAnswer();
		
		System.out.print(questionAndChoices);
		
		System.out.print("Enter your answer (a-d): ");
		
		userInput = keyboard.next();      //getting user input from keyboard
		
		userAnswer = userInput.substring(0,1); // taking the first index of the string, disregarding the rest of the string
		
		{
		if(userAnswer.equalsIgnoreCase("a") || userAnswer.equalsIgnoreCase("b")||userAnswer.equalsIgnoreCase("c")||userAnswer.equalsIgnoreCase("d"))
			//making sure input is valid
		{	
		if (userAnswer.equalsIgnoreCase("a"))   //setting user answer equal to actual answers from question
				{
			userAnswer= choiceA;
				}
				
		if(userAnswer.equalsIgnoreCase("b")) 
				{
			userAnswer= choiceB;
				}
				
		if(userAnswer.equalsIgnoreCase("c"))
				{
			userAnswer= choiceC;
				}
			
		if(userAnswer.equalsIgnoreCase("d"))
				{
			userAnswer = choiceD;
				}}
		
		else{
			System.out.println("Invalid answer.\nAn answer must begin with a, A, b, B, c, C, D, or d. \nGame over!");
			System.exit(0);
					}
	
		if(userAnswer.equalsIgnoreCase(answer)) // output for answer, correct or not
		{
			score++;
			System.out.println("Correct Answer!");
			System.out.println("Your score: " + score+ " out of 1 point(s)\n");
		}
		else
		{
			System.out.println("Incorrect Answer!");
			System.out.println("Your score: " + score+ " out of 1 point(s)\n");
		}
		}
		// question 1 end
		}
		
		{
		// question 2 start
		
		questionAndChoices = MultipleChoiceFlashCardsZoeyGameEngine001.getQuestionAndChoices(); 
		choiceA = MultipleChoiceFlashCardsZoeyGameEngine001.getChoiceA();
		choiceB = MultipleChoiceFlashCardsZoeyGameEngine001.getChoiceB();
		choiceC = MultipleChoiceFlashCardsZoeyGameEngine001.getChoiceC();
		choiceD = MultipleChoiceFlashCardsZoeyGameEngine001.getChoiceD(); 
		answer = MultipleChoiceFlashCardsZoeyGameEngine001.getAnswer();
		
		System.out.print(questionAndChoices);
		
		System.out.print("Enter your answer (a-d): ");
		
		userInput = keyboard.next();
		
		userAnswer = userInput.substring(0,1);
		
		{
		if(userAnswer.equalsIgnoreCase("a") || userAnswer.equalsIgnoreCase("b")||userAnswer.equalsIgnoreCase("c")||userAnswer.equalsIgnoreCase("d"))
			
		{	
		if (userAnswer.equalsIgnoreCase("a"))
				{
			userAnswer= choiceA;
				}
				
		if(userAnswer.equalsIgnoreCase("b")) 
				{
			userAnswer= choiceB;
				}
				
		if(userAnswer.equalsIgnoreCase("c"))
				{
			userAnswer= choiceC;
				}
			
		if(userAnswer.equalsIgnoreCase("d"))
				{
			userAnswer = choiceD;
				}}
		
		else{
			System.out.println("Invalid answer.\nAn answer must begin with a, A, b, B, c, C, D, or d. \nGame over!");
			System.exit(0);
					}
	
		if(userAnswer.equalsIgnoreCase(answer))
		{
			score++;
			System.out.println("Correct Answer!");
			System.out.println("Your score: " + score+ " out of 2 point(s)\n");
		}
		else
		{
			System.out.println("Incorrect Answer!");
			System.out.println("Your score: " + score+ " out of 2 point(s)\n");
		}
		}
		// question 2 end
		}
		// question 3 start
		{

			questionAndChoices = MultipleChoiceFlashCardsZoeyGameEngine001.getQuestionAndChoices(); 
			choiceA = MultipleChoiceFlashCardsZoeyGameEngine001.getChoiceA();
			choiceB = MultipleChoiceFlashCardsZoeyGameEngine001.getChoiceB();
			choiceC = MultipleChoiceFlashCardsZoeyGameEngine001.getChoiceC();
			choiceD = MultipleChoiceFlashCardsZoeyGameEngine001.getChoiceD(); 
			answer = MultipleChoiceFlashCardsZoeyGameEngine001.getAnswer();
			
			System.out.print(questionAndChoices);
			
			System.out.print("Enter your answer (a-d): ");
			
			userInput = keyboard.next();
			
			userAnswer = userInput.substring(0,1);
			{
			if(userAnswer.equalsIgnoreCase("a") || userAnswer.equalsIgnoreCase("b")||userAnswer.equalsIgnoreCase("c")||userAnswer.equalsIgnoreCase("d"))
				
			{	
			if (userAnswer.equalsIgnoreCase("a"))
					{
				userAnswer= choiceA;
					}
					
			if(userAnswer.equalsIgnoreCase("b")) 
					{
				userAnswer= choiceB;
					}
					
			if(userAnswer.equalsIgnoreCase("c"))
					{
				userAnswer= choiceC;
					}
				
			if(userAnswer.equalsIgnoreCase("d"))
					{
				userAnswer = choiceD;
					}}
			
			else{
				System.out.println("Invalid answer.\nAn answer must begin with a, A, b, B, c, C, D, or d. \nGame over!");
				System.exit(0);
						}
		
			if(userAnswer.equalsIgnoreCase(answer))
			{
				score++;
				System.out.println("Correct Answer!");
				System.out.println("Your score: " + score+ " out of 3 point(s)\n");
			}
			else
			{
				System.out.println("Incorrect Answer!");
				System.out.println("Your score: " + score+ " out of 3 point(s)\n");
			}
			}
		}
		// question 3 end
		
		System.out.println("Your final score: "+score+" out of 3 point(s)");
	}	
		if(score==0){
			System.out.println("Your computer science wit needs sharpening.");
		}
		else if(score==1)
		System.out.println("Your computer science wit needs sharpening.");

		
		else if(score==2)
			System.out.println("Your computer science wit is sharp.");
		
		
		else if(score==3)
			System.out.println("Your computer science wit is as sharp as Occam's razor.");
		
		
		System.out.println("Game over!");
		
	
		
	}

}
