
/**                                                                                                                                                                                  
 * Homework Assignment 1 - GoDawgs                                                                                                                                                   
 * @author Cole Downing  (273)                                                                                                                                                       
 */
public class GoDawgs {

    /**                                                                                                                                                                              
     * The main entry point into the program.                                                                                                                                        
     * @param args                                                                                                                                                                   
     */
    public static void main(String[] args) {

        /*                                                                                                                                                                           
           In the space below, write a program that prints the numbers from 1 to                                                                                                     
           100 (both inclusive), but                                                                                                                                                 
            - for multiples of 3 print "Go" instead of the number,                                                                                                                   
            - for multiples of 5 print "Dawgs" instead of the number, and                                                                                                            
            - for multiples of both 3 and 5 print "GoDawgs" instead of the                                                                                                           
              number.                                                                                                                                                                
        */
    	int count = 1; // variable that is modded in order to determine multiples of 3 & 5

        for ( int i =1 ; i <= 100 ; i++)    // for loop counting to 100
        {
            
        	if((count%3 == 0) && (count%5 == 0)){	// checks for multiples of 3 & 5
                System.out.println("GoDawgs");   // prints GoDawgs
            }
        	
            else if(count%5 == 0){   // checks for multiples of 5
                System.out.println("Dawgs");  // prints Dawgs
            }

            else if( count %3 == 0){    // checks for multiples of 5 
                System.out.println("Go");  // prints Go
            }
        	
            else{
            System.out.println( count );  // if no multiples, prints number
            }
            
            count++;
            
        }// for                                                                                                                                                                      
} // main
    
} // GoDawgs