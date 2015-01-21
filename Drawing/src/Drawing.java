
import java.util.Scanner;


/*
* [Drawing].java
* Author: [Cole Downing] 
* Submission Date: [6-27-13]
*
* Purpose: A brief paragraph description of the
* program. What does it do? It draws repeating patterns of right triangles 
* based of user input.
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


public class Drawing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);

		System.out.print("How many times do you want to repeat the figure? ");

		int t = keyboard.nextInt();

		if (t <= 1) 
		{
			System.out.println("Invalid input.");
			System.exit(0);
		}

		System.out.print("Indicate the number of stars (>1): ");

		int s = keyboard.nextInt();

		if (s <= 1) 
		{
			System.out.println("Invalid input.");
			System.exit(0);
		}

		else
			System.out.println("");
			for (int count = 1 ; count<=t ; count++)
			{
				for (int i = 1; i <= s; i++)
				{
					for (int j = s; j >= i; j--) 
				{
					System.out.print("*");
				}
				System.out.println("");
				}
			
				for (int i = 1; i <= s; i++) {
					for (int j = 1; j <= i; j++)
					{
						System.out.print("*");
					}
						System.out.println("");
					}
			}
	}

}
