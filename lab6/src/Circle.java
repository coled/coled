/*
     * [Circle].java
     * Author:  [Cole Downing]
     * Submission Date:  [7-12-13]
     *
     * Purpose: A brief paragraph description of the
     * program. What does it do?
     * This class has methods defined to set and get values of 2 circles
     * as well as methods that calculate various circle formulas. It returns these
     * values for use in the CircleTester class. 
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
// Circle.java
//
// 
//******************************************************
public class Circle {
	

	private double radius;      // declare the private double instance  radius
	private double x;       // declare the private double instance  x
	private double y;    // declare the private double instance  y
	
	//----------------------------------------------
	// Class Constructor: set the initial values of
	//                    the instance variables
	//                    for this circle
	//----------------------------------------------	
	public Circle(double x, double y,double  radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;  	   	
	}
	
	
	//----------------------------------------------
	// getX - returns the value of x
	//----------------------------------------------
	public double getX() {
		
		return x;
	}
	

	//----------------------------------------------
	// getY - returns the value of y
	//----------------------------------------------
	public double getY() {
		
		return y;
	}
	
	//----------------------------------------------
	// getRadius - returns the value of radius
	//----------------------------------------------
	public double getRadius() {
		
		return radius;
	}

	//----------------------------------------------
	// setX - assigns a new value to x
	//----------------------------------------------
	public void setX(double x) {
		this.x = x;
			
	}
	

	//----------------------------------------------
	// setY - assigns a new value to y
	//----------------------------------------------
	public void setY(double y) {
		this.y = y;
				
	}	
	
	
	//----------------------------------------------
	// setRadius - assigns a new value to radius
	//----------------------------------------------
	public void setRadius(double radius) {
		if(radius>=0)
		{
			this.radius=radius;
		}
		
	}
	
	//--------------------------------------------------------
	// diameter - calculates the diameter of the circle
	//--------------------------------------------------------
	public double diameter() {
		double diameter = radius * 2;
			return diameter;
	}
	

	//--------------------------------------------------------
	// area - returns the area of the circle
	//--------------------------------------------------------
	public double area() {
		double area = Math.PI * (radius * radius);
			return area;
	}

	//--------------------------------------------------------
	// perimeter - returns the perimeter of the circle
	//--------------------------------------------------------
	public double perimeter() {
		double perimeter = 2 * Math.PI * radius;
		return perimeter;	
	}
	
	//--------------------------------------------------------
	// isUnitCircle - return true if the radius of this circle
	//                is 1 and its center is (0,0) and false
	//      	      otherwise.
	//--------------------------------------------------------
	public boolean isUnitCircle() {
		boolean isUnitCircle;
			if(radius==1 && x==0 && x==0)
				isUnitCircle = true;
			
			else
				isUnitCircle = false;
		
			return isUnitCircle;	
	}
	
	
	//--------------------------------------------------------
	// toString - return a String representation of
	//            this circle in the following format:
	//            center:(x,y)
	//            radius: r
	//--------------------------------------------------------
	public String toString() {
		String toString =("center: "+ "("+ x + "," + y + ")\n"
							+ "radius: " + radius);
		return toString;
	}

	
	public boolean equals(Circle anotherCircle) {
		boolean equals;
		
		if(this.radius==anotherCircle.radius && this.x==anotherCircle.x && this.y==anotherCircle.y)
		{
			equals=true;
		}
		else
			equals=false;
		return equals;
	}
	
	public boolean isConcentric(Circle anotherCircle){
		boolean isConcentric;
		if(this.x==anotherCircle.x && this.y==anotherCircle.y)
		{
			isConcentric=true;
		}
		else 
			isConcentric=false;
		return isConcentric;
	}
	
	
	public double distance(Circle anotherCircle){
		double resultX= Math.pow((this.x - anotherCircle.x) , 2);
		double resultY= Math.pow((this.y - anotherCircle.y ), 2);
		double resultXPlusY= resultX + resultY;
		double distance= Math.sqrt(resultXPlusY);
		return distance;
	}
	
	
	public boolean intersects(Circle anotherCircle){
		boolean intersects;
		double distance = distance(anotherCircle);
		if(distance < (this.radius + anotherCircle.radius))
		{
			intersects=true;
		}
		else
			intersects=false;
		return intersects;
	}
	
	
	
	
	
	
	
	
}
