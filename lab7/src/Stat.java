/*
* [Stat].java
* Author: [Cole Downing]
* Submission Date: [7-21-13]
*
* Purpose: A brief paragraph description of the * program. What does it do? How does it do it? *
* Statement of Academic Honesty:
* This program tells gives data such as mean, mode, min, and max for arrays.
* Each Stat object has an array called data that holds double values. 
* The methods determine the calculations for min, max, mode, and mean.
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

public class Stat {

	
	
	private double [] data;
	
	
    Stat(){
		this.data = new double [1];
	    data [0] = 0.0;
	}
	
	
	Stat(double [] d){
		double [] dClone= new double [d.length];
		for(int i = 0 ; i < d.length ; i++){
			dClone[i]= d[i];
		}
		data = dClone;
	}
	
	
	public double[] getData(){
		double [] newArray= new double [data.length];
		for(int i = 0 ; i < data.length ; i++){
			newArray[i]= data[i];
		}
		return newArray;
	}
	
	
	public void setData(double [] d){
		double [] newArray= new double [d.length];
		for(int i = 0 ; i < d.length ; i++){
			newArray[i]= d[i];
		}
		data = newArray;
	}
	
	
	boolean equals(Stat s){
		boolean equals = false;
		for(int i = 0; i< data.length ; i++){
			if(this.data [i]== s.data[i])
			{
				equals = true;
			}
			
			
			else {
				equals = false;
				break;
			}
		}
		return equals;
	}
	
	
	// 
	public String toString(){
		StringBuffer sb= new StringBuffer();
		
		for(int i = 0 ; i < data.length ; i++){
		if(i==0){
			sb.append("[");
		}
		sb.append(data[i]);
		
			if(i != data.length-1){
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
		
		}
	
		
		
	 double min(){
		double min= data[0];
		for (int i=0 ; i < data.length ; i++){
			if (data[i] < min)
				min = data[i];
		}
		return min;
	}
	
	
	 double max(){
		double max = data[0];
		for (int i=0 ; i < data.length ; i++){
			if (data[i] > max)
				max = data[i];
		}
		return max;
	}
	
	
	 double average(){
		double sum=0;
		for (int i=0 ; i < data.length ; i++){
			sum = sum + data[i];
		}
		double average = sum / data.length;
		return average;
	}
	

	 double mode(){
		 double mode=0.123;
		 double modeCount=2;
		 
		for(int i=0; i< data.length; i++){
			int count =0;
			
			for(int j=0; j<data.length; j++){
				if(data[j]==data[i])
					count++;

			if (count > modeCount)
			{
				modeCount = count;
				mode = data[i];
			}
			
		} 
		}	
			if(mode == 0.123){
			mode = Double.NaN;
		}
			return mode;
	 }
	 
}	// end Stat class

	

