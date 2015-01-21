/*
     * [CSCI 1301].java
     * Author:  [Cole Downing]
     * Submission Date:  [2\01\13]
     *
     * Purpose: A brief paragraph description of the
     * program. What does it do? This program determines 
     * the payments for a credit card based on interest rate, 
     * principal and monthly payment values entered by user. 
     *
     * Statement of Academic Honesty:
     *
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with * the University of Georgia's Academic Honesty Policy and the * policies of this course. I recognize that my work is based * on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department * of Computer Science at the University of Georgia.
*/

import java.util.Scanner;

public class CreditCardPayOff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		
		
		
		double Overpayment;
		double TotalAmountPaid;
		double TotalInterestPaid;
		double MonthlyPayment;
		double MonthsNeededToPayOff;
		int Ceiling;

	System.out.println("Enter the Principal.");	
	double Principal = keyboard.nextDouble();
	
	System.out.println("Enter the Annual Interest Rate.");
	double AnnualInterestRate = keyboard.nextDouble();
	
	System.out.println("Enter Monthly Payment.");
	 MonthlyPayment = keyboard.nextDouble();
	
	 MonthsNeededToPayOff =( Math.log(MonthlyPayment) - (Math.log(MonthlyPayment - (AnnualInterestRate / 1200.0) * Principal))) / Math.log((AnnualInterestRate / 1200.0) + 1.0 );
	
	 Ceiling = (int) Math.ceil(MonthsNeededToPayOff);
	 
	 TotalAmountPaid = Ceiling * MonthlyPayment;
	 
	 TotalInterestPaid = TotalAmountPaid - Principal;
	 
	 Overpayment = (Ceiling * MonthlyPayment) - (MonthsNeededToPayOff * MonthlyPayment);
	
	 
	 
	
	System.out.printf("Principal:\t\t\t %7.2f ", Principal);
	System.out.printf("\nAnnual Interest Rate:\t\t %4.1f" , AnnualInterestRate);
	System.out.printf("\nMonthly Payment:\t\t %6.2f" , MonthlyPayment);
	
	System.out.printf("\n\nMonths Needed To Pay Off:\t"+ Ceiling);
	System.out.printf("\nTotal Amount Paid:\t\t $%7.2f" , TotalAmountPaid);
	System.out.printf("\nTotal Interest Paid:\t\t $%7.2f" , TotalInterestPaid);
	System.out.printf("\nOverpayment:\t\t\t $%4.2f" , Overpayment);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
		
		
		
		
		
		