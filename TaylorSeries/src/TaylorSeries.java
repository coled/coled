import java.util.Scanner;

/*
 * [TaylorSeries].java
 * Author:  [Cole Downing]
 * Submission Date:  [6-27-13]
 *
 * Purpose: A brief paragraph description of the
 * program. What does it do? This program approximates the 
 * value of e^x, with the user input for variables x and t.
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
* * of Computer Science at the University of Georgia.
*/


public class TaylorSeries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		double x = 0;
		int t = 0;
		double e = 0;
		double sum =1;
		double num=1;
		double den=1;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter a double value for x (-50 <= x <= 50): ");
		
		x = keyboard.nextDouble();
		// may need nested loop statements
		
		if(x >= -50 && x<= 50);
		
		else{
			do{	
				System.out.println("Invalid input for x.");
				System.out.print("Enter a double value for x (-50 <= x <= 50): ");
				x = keyboard.nextDouble();
			}
				while (x < -50 || x > 50);
			}

		System.out.print("Enter t (1 <= t < 64), the number of terms for the Taylor Series: ");
		
		t = keyboard.nextInt();
		
		if (t >= 1 && t < 64);
		
		else{
			do{
				System.out.println("Invalid input for t.");
				System.out.print("Enter t (1 <= t < 64), the number of terms for the Taylor Series: ");
				t = keyboard.nextInt();
			}
				while (t < 1 || t > 64);
			}
	
		
		for ( int i=1 ; i < t ; i++)
		{
			num = num * x;
			den = den * i;
				
			sum = (num /den) + sum;
		}
		System.out.println("Taylor series approximation of exp(" + x+ ") with " + t+ " terms is "+sum);
		}
	
	

	}
	
	
		
		
		
		
		
	
		
		
		
	


