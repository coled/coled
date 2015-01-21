
/**                                                                                                                            
 * Homework Assignment 1 - DistConverter                                                                                       
 * @author YOUR NAME HERE (LAST 3 DIGITS OF 810 NUMBER HERE)                                                                   
 */

import java.util.Scanner;

public class DistConverter {
	

    /**                                                                                                                        
     * The main entry point into the program.                                                                                  
     * @param args                                                                                                             
     */
    public static void main(String[] args) {

        /*                                                                                                                     
            In space below, write a program that converts miles to                                                             
            kilometers. One mile equals 1.60935 kilometers. Read                                                               
            the miles value from the user as a floating point value                                                            
            with double precision.                                                                                             
        */
        // You may assume non-erroneous input.                                                                                 

    	 Scanner scan = new Scanner(System.in);
    	 
    	 System.out.print("Enter distance in miles: ");
    	 
     	double miles = scan.nextFloat();
     	
     	double kilometers = miles * 1.60935;
     	
     	System.out.print("The distance in kilometers is " + kilometers);

    	System.exit(0);    	
    } // main                                                                                                                  

} // DistConverter                                                                                                             


