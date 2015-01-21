
	import java.util.Random;


	/*
	* [Life].java
	* Author: [Cole Downing] 
	* Submission Date: [7-3-13]
	*
	* Purpose: A brief paragraph description of the
	* program. What does it do? It simulates life in a grid system
	* based off conditions and random starting values. 
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




public class Life {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int gridSize = 600;
		int cellSize = 1;
		Grid grid = new Grid(gridSize, cellSize, "The Game of Life");
		grid.setDelay(1);
		
		int aliveColor = 1;
		int deadColor = 0;
		Random r = new Random ();
		int getPos;
		int matchingNeighbors=0;
		
		int gen=0;
		
		while(gen==0){
	for(int c=0 ; c<gridSize-1 ; c++)
		{
		for(int i=0 ; i<gridSize-1 ; i++)
		{	
			if(r.nextInt(100) > 49)
			{
				grid.setPos(   c, i,  aliveColor);
				
			}
		
			else
			{
				grid.setPos( c ,  i, deadColor);
			}
		//	grid.update();
		}}
		grid.update();
		grid.initialize();
		gen++;
		}
		
	
	while(gen>0){
		
		for(int c=0 ; c<gridSize-1 ; c++)
		{
			for(int i=0 ; i<gridSize-1 ; i++)
		{
			getPos = grid.getPos(c , i);
			matchingNeighbors = grid.matchingNeighbors(c , i ,1);
			
			if(getPos==1){
				if(matchingNeighbors > 1 && matchingNeighbors <= 3)
				{
					grid.setPos( c, i,  aliveColor);
				}
				else 
				{
					grid.setPos(c , i, deadColor);
				}
			}
			else if(getPos==0){
				if(matchingNeighbors ==3)
				{
					grid.setPos(c,i, aliveColor);
				}
				else
					grid.setPos(c,i,deadColor);
			}
		
			
		}	
	}  
		grid.update();
		gen++;
		}}}