
/* * [Palindrome].java * Author: [Cole Downing] * Submission Date: [2-22-15] * * Purpose: A brief paragraph description of the * program. What does it do? It determines if an integer is a palindrome or not. If so it does a summation of the integer.  * * Statement of Academic Honesty: * * The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied * or modified code from any source other than the course webpage * or the course textbook. I recognize that any unauthorized * assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the * policies of this course. I recognize that my work is based * on an assignment created by the Department of Computer * Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly * prohibited unless you have written consent from the Department * of Computer Science at the University of Georgia. */

import java.util.Scanner;
public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("Please enter an integer > 0:");
		
		Scanner keyboard = new Scanner(System.in);
	
		int input = keyboard.nextInt();
		int originalinput = input;
		int reverse = 0;
		int last;
		int count = 0;
		int sum = 0;
		
		if (input<=0){
			System.out.println("Sorry, you must eneter an integergreater than zero.");
			System.exit(0);}
		
		while (input>0) 
			
		{
		last = input %10;
		reverse = reverse*10 + last;
		input = input / 10;
		}
		
		if (originalinput == reverse)
		{
			System.out.println("The integer " + originalinput + " is a palindrome.");
		while(count <= originalinput)
		{
			sum += count++;
			}
		System.out.println("The sum of the numbers from 1 to "+ originalinput+" is "+ sum);
}
		else
			System.out.println("The integer " + originalinput + " is not a palindrome.");
		
	
		}
		
	}
		
		
		
		
		
	


