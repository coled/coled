/*
     * [CircleTester].java
     * Author:  [Cole Downing]
     * Submission Date:  [7-12-13]
     *
     * Purpose: A brief paragraph description of the
     * program. What does it do?
     * This program does multiple calculations on two different circles such as
     * determining diameter, perimeter etc. as well as 
     *  compares the two in various ways such as the distance between the two,
     *   if concentric, and if equal.
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
//*******************************************************
// CircleTester.java
//
//
//  A client to test the functionality of objects
//  of the class Circle
// 
//*******************************************************
public class CircleTester{
	
	public static void main(String[] args) {
		
		Circle circle1= new Circle(0.0,0.0,2);
		Circle circle2= new Circle(2.0,1.0,1);
		
		System.out.println("circle1="+circle1);
		System.out.println("circle2="+circle2);
		
		// If the method setRadius is implemented correctly,
		// a call to setRadius with a negative number
		// will not change the value of the circle's radius.
		//
		circle1.setRadius(-2.0); 
		
		//
		// Reset the center of circle1 (-3.0,4.0)
		//
		circle1.setX(-3.0);
		circle1.setY(4.0);
		
		
		// print circle1 characteristics (center and radius), use a statement similar 
		// to the previous println statements. Note that is not necessary to call
		//the method toString, why?
		System.out.println("circle1="+circle1);
		
		
		// set the circle2 radius to 5.3
		circle2.setRadius(5.3);
		
		// print circle2 characteristics (center and radius), use a statement similar to the first and
		// second println statements
		System.out.println("circle2="+circle2);
		
		// print circle1 diameter, area and perimeter
		System.out.println("circle1=diameter: "+ circle1.diameter()+" perimeter: "+ circle1.perimeter() ); 
		
		// print circle2 diameter, area and perimeter
		System.out.println("circle2=diameter: "+ circle2.diameter()+" perimeter: "+ circle2.perimeter() ); 
		
		// display whether circle1 is a unit circle
		System.out.println("Is circle1 a unit circle: "+circle1.isUnitCircle());
		
		// display whether circle2 is a unit circle
		System.out.println("Is circle2 a unit circle: "+circle2.isUnitCircle());
		
		// your additional tests should be placed below here
				
		System.out.println("Is circle1 equal to circle2: "+ circle1.equals(circle2) );
		// 1.   returns boolean true  if circles are equal
		
		System.out.println("Do both circles share the same center: "+ circle1.isConcentric(circle2));
		// 2.   returns boolean true if circles share a center
		
		System.out.println("The distance between the two circles is: " + circle1.distance(circle2));
		//3. returns double value for the distance between the two circle's centers. 
		
		
	}
	
}