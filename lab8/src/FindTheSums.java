
/*
* [FindTheSums].java
* Author: [Cole Downing]
* Submission Date: [7-25-13]
*
* Purpose: A brief paragraph description of the 
* program. What does it do? How does it do it? 
* 
* This program has methods for the class FindTheSumsTester.
*  One method returns a 2d array as a neat string.
* Another sums the elements of the 2d array horizontally to find elements summing to sumToFind.
* And the last one does the same as the previous summing method, but counts the 2d array vertically. 
* 
* Statement of Academic Honesty:
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
* written consent from the Department of Computer Science. 
* */


public class FindTheSums {

	
	
	public static String arrayToString(int [] [] a){
		StringBuffer sb = new StringBuffer(); 
		
		for(int row = 0 ; row < a.length ; row++){
			
			if(row>0 && row < a.length){ // inserts new line 
				sb.append("\n");
			}
			for(int col = 0; col < a[0].length ; col++){ // adds values of "a" to stringbuffer 
				sb.append(a[row][col]);
				
				if(a.length == a[0].length){ // inserts space where needed " "
					if( col < a.length-1)
					{
					sb.append(" ");
					}	
				}
				else{
					if( col < a.length)
					{
					sb.append(" ");
					}	
				}
			}
			
		}
		
		return sb.toString(); // returns string buffer / "a" as string 
	}
	
	
	
	
	
	public static int [] [] horizontalSums(int [] [] a, int sumToFind){
		int [] [] outputArray = new int [a.length] [a[0].length]; // sets row and column length of outputArray = array "a"
		int sum=0;
		int column =0;
		int length = a[0].length;
		
		for(int i =0; i< a.length; i++)
		{   // these two for loops initialize the outputArray to all zeros "0"
			
			for(int j=0; j<a[i].length; j++)
			{
			outputArray [i] [j] =  0;
			}
		}	
		for(int row = 0; row < a.length; row++)
		{ // for loop for counting the rows of array
			
			for(int col =0; col < a[row].length; col++)  // for loop for counting the columns of array
			{ sum=0;
				
				for(int c=0; c< a[row].length-col; c++) // for loop for adding columns "c" to indexed column "col" until sum >= sumToFind
				
				{
				  if(sum < sumToFind && ((col + c) <= length)) // checks if sum is < sumToFind and that it continually adds, while not adding passed a.length
				  {
					sum = sum + a [row] [c+col]; // sums the numbers in columns "col" with the preceding columns "c"
				  }
				  if(sum == sumToFind) // if sum is found, this if statement adds the values of the elements summing to sumToFind in the outputArray. replacing the initialized "0"s to values from input array
				  	{
					  column = c + col;  // combines column index with the number of columns added to it. used to prevent over counting passed a.length-1
					  while(column >= col)
						{
						outputArray [row] [column] = a [row] [column]; // adds element values to outputArray from input array a.
						column--;   // counts down so that it replaces values back to the index of the column where counting started
						}
						sum=0;
						column=0;  // reset sum and column for next round of summing on next index "col"
				
					  
				  	}
				  if(sum > sumToFind || ((col + c) >= length))
				  {  // prevents over counting passed a.length-1, if true breaks to next round of summing
					  sum =0;
					  break;
				  }  
				} // close brace for the for loop counting "c"							
			} // close brace for column counting for loop						
		}	// close brace for row counting for loop		
		return outputArray; // returns new outputArray with 0s filled with elements summing to sumToFind
	} // close brace for method
	
	
	
	
	
	
	public static int [] [] verticalSums(int [] [] a, int sumToFind){
		
		int [] [] outputArray = new int [a.length] [a[0].length];  // sets array lengths equal to each other
		int sum=0;
		int rows =0;
		int length = a.length; // int for holding a.length value
		
		for(int i =0; i< a.length; i++)
		{  
			
			for(int j=0; j<a[i].length; j++)  // these for loops initialize oututArray to all zeros
			{
			outputArray [i] [j] =  0; 
			}
		}	
		
		for(int col =0; col < a.length; col++)  // counts columns
		
		{ 
			
			for(int row = 0; row < a[0].length; row++) // counts rows
			{ sum=0;
				
				for(int r=0; r< a.length-row; r++)  // counts rows to add
				
				{
				  if(sum < sumToFind && ((row + r) <= length))  // if statement that checks to add next row to sum
				  {
   					sum = sum + a [row + r] [col]; 
				  }
				  if(sum == sumToFind) 
				  	{
					  rows = r + row;  
					  while(rows >= row)
						{
						outputArray [rows] [col] = a [rows] [col];  // adds a's values that sum to sumToFind to outputArray
						rows--;   
						}
						
						rows=0;
						break;
				  	}
				  if(sum > sumToFind || ((row + r) >= length)) // breaks from row counting loop "r" if sum > sumToFind or incorrect index
				  {  
					  sum =0;
					  break;
				  }
				
				}							
			} 						
		}			
		return outputArray; 
	} // close brace for method
	
	
	
			
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

