import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
   
  /**                                                                                                                   
   * This class represents a Minesweeper game.                                                                          
   *                                                                                                                    
   * @author Cole Downing <coled@uga.edu>                                                                               
   */
 public class Minesweepertest {
 
     /**                                                                                                               
      * Constructs an object instance of the {@link Minesweeper} class using the                                       
      * information provided in <code>seedFile</code>. Documentation about the                                         
      * format of seed files can be found in the project's <code>README.md</code>                                      
      * file.                                                                                                          
      *                                                                                                                
      * @param seedFile the seed file used to construct the game                                                       
      * @see            <a href="https://github.com/mepcotterell-cs1302/cs1302-minesweeper-alpha/blob/master/README.md\
   #seed-files">README.md#seed-files</a>                                                                                 
      */
	 private static int rows=10;
	 private static int cols=10;
	 private static int mines;
	 private static int rounds=0;
	 private static char [][] grid;
	 private static boolean [][] mineGrid;
	 private static Scanner player = new Scanner(System.in);
	 private static String command;
	 private static String tokens;
	 private static int row = 0;
	 private static int column = 0;
	// private static int extraValue=-1;
	 private static boolean nofog= false;
	 private static boolean gameWon=false;
	 private static int score;
	 private static boolean error=false;
	 private static boolean fog=true;
	 
	 
	 public static void revealGrid(int row, int col){
		 int mineCount = 0;
		 char count;
		 if(mineGrid[row][col]==false){

			 if((col-1 > 0) && (mineGrid[row][col-1]==true)){  // checks to left 
    			 mineCount++;
    		 }
    		 else if((col+1 < cols) && (mineGrid[row][col+1]== true)){ // checks to right
    			 mineCount++;
    		 }
    		 else if((row-1 > 0) && (mineGrid[row-1][col]==true)){ 
    			 mineCount++;
    		 }
    		 else if((row-1 > 0) && (col-1 > 0) && (mineGrid[row-1][col-1]==true)){
    			 mineCount++;
    		 }
    		 else if((row-1 > 0) && (col+1 < cols) && (mineGrid[row-1][col+1]==true)){
    			 mineCount++;
    		 }
    		 else if((row+1 < rows) && (mineGrid[row+1][col]==true)){ 
    			 mineCount++;
    		 }
    		 else if((row+1 < rows) && (col-1 > 0) &&(mineGrid[row+1][col-1]==true)){
    			 mineCount++;
    		 }
    		 else if((row+1 < rows) && (col+1 < cols) &&mineGrid[row+1][col+1]==true){
    			 mineCount++;
    		 }
    		 else if(mineGrid[row][col]==true){
    			 System.out.println("GAME OVER");
    		 }
    	 
			 count = (char) ('0' + mineCount); // c is now '5'
    	 	 grid[row][col] = count;
    	 
		 }//if 
		 else if(mineGrid[row][col]==true)
		 	{      	  
			 System.out.println("\n Oh no... You revealed a mine!");
			 System.out.println("  __ _  __ _ _ __ ___   ___    _____   _____ _ __ ");	
			 System.out.println(" / _` |/ _` | '_ ` _ \\ / _ \\  / _ \\ \\ / / _ \\ '__|");
			 System.out.println("| (_| | (_| | | | | | |  __/ | (_) \\ V /  __/ | ");
			 System.out.println(" \\__, |\\__,_|_| |_| |_|\\___|  \\___/ \\_/ \\___|_|");
			 System.out.println(" |___/ ");	
			 System.exit(0);
		 	}
	 }//revealGrid
	 
              
	 
	 
	 
	 
	 
	 public static void  markGrid(int row, int col){
		 if(grid[row][col]== 'F')
		 {
		 grid[row][col]= ' ';
		 }
		 	else
		 	{
		 		grid[row][col]= 'F';
		 	}
	 }
	 
	 
	 public static void guessGrid(int row , int col){
		 if( grid[row][col]== '?')
		 {
		 grid[row][col]= ' ';
		 }
		 	else
		 	{
			 grid[row][col]= '?';
		 	}
		
	 }
	 
	
	 public static void nofog(){
	
		 StringBuffer startGrid = new StringBuffer();
	
   	  for(int i= 0; i < grid.length; i++)
   	  { // loop to print out game grid, newGrid from char grid 
   	  
   		  
   		nofog=false;
       	startGrid.append("\n");
       	startGrid.append(" ");
   		startGrid.append(i);
   		startGrid.append(" ");
   		startGrid.append("|");
       		
       		for(int j= 0; j < rows; j++)
       		{
       			nofog=false;
       			
       			if(mineGrid[i][j]==true)
       			{
       				nofog=true;
       				startGrid.append("<");
       				
       				if(grid[i][j]!='\u0000')
       				{
       				startGrid.append(grid[i][j]);
       				}//if
       					else
       					{
       					startGrid.append(" ");
       					}//else
       				
       				startGrid.append(">");
       			}// if
       			
       				else
       				{
       				startGrid.append(" ");
       				
       					if(grid[i][j]!='\u0000')
       						{
       						startGrid.append(grid[i][j]);
       						}//if
       					
       							else
       								{
       								startGrid.append(" ");	
       								}//else
       				}// else
       			
       			if(nofog==false)
       			{
       			startGrid.append(" ");
       			}
       			
       			startGrid.append("|");
       			
       		} // for j		
   	  }	// for i
   	  
   	// loop for column numbers
   	  
   	  startGrid.append("\n     ");
   	  int n= cols;
   	  
   	  for( n=0; n< grid.length; n++)
   	  {   
   		startGrid.append(n);
        startGrid.append("   ");
   	  }//for
   	  
   	  	startGrid.append("\n");
   	 System.out.println("\n Rounds Completed: "+ ++rounds);
   	  	System.out.println(startGrid.toString());
   	  	fog=false;
	 }//nofog
	 
	 
	 //
      
      
      
      public static void printGrid(){
    	  StringBuffer startGrid = new StringBuffer();
    	  for(int i= 0; i < grid.length; i++)
    	  { // loop to print out game grid, newGrid from char grid 
        		startGrid.append("\n");
        		startGrid.append(" ");
        		startGrid.append(i);
        		for(int j= 0; j < rows; j++)
        		{
        			startGrid.append(" ");
        			startGrid.append("|"+" ");
        			if(grid[i][j]!='\u0000')
        			{
        				startGrid.append(grid[i][j]);
        			}//if
        				else
        				{
        				startGrid.append(" ");
        				}//else
        		} // for j
        		startGrid.append(" ");
        		startGrid.append("|");
    	  } //for i	
    	  
    	// loop for column numbers
    	  
    	  startGrid.append("\n     ");
    	  int n= cols;
    	  for( n=0; n< grid.length; n++)
    	  {   
        		 startGrid.append(n);
        		 startGrid.append("   ");
    	  }//for
    	  	startGrid.append("\n");
    	  	System.out.println(startGrid.toString());
      } // printGrid
      
      
      
      
      
      
      
 
      
      
      
      
          /**                                                                                                               
           * The entry point into the program. This main method does implement some                                         
           * logic for handling command line arguments. If two integers are provided                                        
           * as arguments, then a Minesweeper game is created and started with a                                            
           * grid size corresponding to the integers provided and with 10% (rounded                                         
           * up) of the squares containing mines, placed randomly. If a single word                                         
           * string is provided as an argument then it is treated as a seed file and                                        
           * a Minesweeper game is created and started using the information contained                                      
           * in the seed file. If none of the above applies, then a usage statement                                         
           * is displayed and the program exits gracefully.                                                                 
           *                                                                                                                
           * @param args the shell arguments provided to the program                                                        
           */
          public static void main(String[] args) {
      
              /*                                                                                                            
                The following switch statement has been designed in such a way that if                                      
                errors occur within the first two cases, the default case still gets                                        
                executed. This was accomplished by special placement of the break                                           
                statements.                                                                                                 
              */
        	  
        	
        	  
        	  
        	  
        	  
        	  
        	  
        	  
        	  
				

              System.out.println("         _");
              System.out.println("   /\\/\\ (_)_ __   ___  _____      _____  ___ _ __   ___ _ __");
              System.out.println("  /    \\| | '_ \\ / _ \\/ __\\ \\ /\\ / / _ \\/ _ \\ '_ \\ / _ \\ '__|");
              System.out.println(" / /\\/\\ \\ | | | |  __/\\__ \\\\ V  V /  __/  __/ |_) |  __/ |");
              System.out.println(" \\/    \\/_|_| |_|\\___||___/ \\_/\\_/ \\___|\\___| .__/ \\___|_|");
              System.out.println(" \t\t\t\t      ALPHA |_| EDITION");
      
            
              
         	 if(((rows < 1) || (rows >10)) || ((cols < 1) || (cols >10))) {
        		 System.out.println("ಠ_ಠ says,\" \"Cannot create a mine field with that many rows and/or columns!\"");
        	 System.exit(0);
        	 } // if
        	 
        	 grid = new char [cols] [rows];  // initializes grid size
        	 mineGrid = new boolean [cols] [rows]; // initializes mine grid, boolean
        	 
        	 mines = ((rows * cols) / 10) + 1;   // determines # of mines
        	
        	 																
        	 for (int i=0 ; i < mines ; i++){  // sets up mine locations as true
        		 Random randomnumber = new Random(); // random # for mine locations
        		 int randomrow = randomnumber.nextInt(rows);
        		 int randomcol = randomnumber.nextInt(cols);
        		 if(mineGrid[randomrow][randomcol]== true)
        		 {
        			  randomrow = randomnumber.nextInt(rows);
            		  randomcol = randomnumber.nextInt(cols);
        		 }
        		 mineGrid [randomrow][randomcol] = true;  // using true to indicate mine
        		
        	 }
        	  
        	 
        	 System.out.println("\n Rounds Completed: "+ rounds);
        		
        	 printGrid();	
        	 

           	 // game loop
        	 while(gameWon==false)
    {
        	 error = false;
        	 fog=true;
        	 System.out.print("minesweeper-alpha$ ");
        	
        	 
        	 command = player.next(); //["reveal"/"r"]-[(int)]-[(int)]
        	 command.trim();
        	

       	  if(command.equals("help"))
				{		 		
				System.out.println("\n Commands Available...\n" + " - Reveal: r/reveal row col\n" +
	  				 " -   Mark: m/mark   row col\n" + " -  Guess: g/guess  row col\n"+ 
					 " -   Help: h/help\n"+ " -   Quit: q/quit\n");
					error=true;
				} 	
				else if(command.equals("h"))
					{
						System.out.println("\n Commands Available...\n" + " - Reveal: r/reveal row col\n" +
						" -   Mark: m/mark   row col\n" + " -  Guess: g/guess  row col\n"+ 			
						" -   Help: h/help\n"+ " -   Quit: q/quit\n");
						error=true;
					} 
						else if(command.equals("quit"))
						{
							System.out.println("\nლ(ಠ_ಠლ)");
							System.out.println("Y U NO PLAY MORE?\nBye!");
							System.exit(0);
						}  
							else if(command.equals("q"))
							{
								System.out.println("\nლ(ಠ_ಠლ)");
								System.out.println("Y U NO PLAY MORE?\nBye!");
								System.exit(0);
							} 
								else if(command.equals("nofog"))
								{
									nofog();
									error=true;
							
								}
								else if ((!command.equals("h") && (!command.equals("help") && (!command.equals("q") && (!command.equals("quit") && (!command.equals("nofog") && (!command.equals("r") && (!command.equals("reveal")&& (!command.equals("m")&& (!command.equals("mark")&& (!command.equals("guess")&& (!command.equals("g") )))))))))))){
									 System.out.println("\nಠ_ಠ says, \"Command not recognized!\"");
				        			 error=true;
								}
        	 
        	 
        	 
        	 tokens = player.nextLine();
        	 
        	 tokens = tokens.trim();
        	 
        	 for(int t=0; t<tokens.length(); t++)
        	 {
        		 
        		 {
        			 if(!tokens.contains(" "))
        			 {
        			 System.out.println("\nಠ_ಠ says, \"Command not recognized!\"");
        			 error=true;
        			 t=tokens.length();
        			 }
        		 }	 
        	 }
        	 
        	 if(error!=true)
        	 {
        	 tokens = tokens.replaceAll("\\s","");
        	 }
        	 
        	
        	 
        
        	{
        		if((tokens.length() > 2))
        		{
        		 System.out.println("\nಠ_ಠ says, \"Command not recognized!\"");
        		 error = true;
        		}
        	}
        	
         if(error!=true) // command taken if no error
         {
        	 row = Integer.parseInt(tokens.substring(0,1));
        	 column = Integer.parseInt(tokens.substring(1,2));
        	 
        	 
        	  if(command.equals("help"))
				{		 		
				System.out.println("\n Commands Available...\n" + " - Reveal: r/reveal row col\n" +
	  				 " -   Mark: m/mark   row col\n" + " -  Guess: g/guess  row col\n"+ 
					 " -   Help: h/help\n"+ " -   Quit: q/quit\n");

				} 	
				
								else if(command.equals("reveal"))
								{
								
								revealGrid(row , column);
								} 
				        	   		else if(command.equals("r"))
				        	   		{
				        	   		revealGrid(row , column);
				        	   		} 
				        	   			else if(command.equals("mark"))
				        	   			{
				        		 		 markGrid(row , column);
				        	   			}  
				        	   				else if(command.equals("m"))
				        	   				{
				        	   				markGrid(row , column);
				        	   				}  
				        	   					else if(command.equals("guess"))
				        	   					{
				        	   					guessGrid(row , column);
				        	   					}  
				        	   						else if(command.equals("g"))
				        	   						{
				        	   			        	 guessGrid(row , column);
				        	   						}  
				        	   							
				        	   								else
				        	   								{
				        	   									System.out.println("\nಠ_ಠ says, \"Command not recognized!\"");
				        	   								}
							
        	  int mineCount=mines;
        	  int flagCount=0;
        	  
        	  for(int a=0; a<rows; a++){
        		  for(int b=0; b<rows; b++){
            		  
        			  if((mineGrid[a][b]==true) && (grid[a][b]=='F'))
        			  {
        				  mineCount--;
        			  }
        			  		if((mineGrid[a][b]==false) && (grid[a][b]=='?'))
        			  		{
        			  			flagCount++;
        			  		}
        			  
        			  			if(mineCount==0 && flagCount==0){
        			  				// GAME WON
        			  				gameWon=true;
        			  				rounds++;
        			  				score = (rows * cols) - mines - rounds;
        			  				
        			  				System.out.println(" ░░░░░░░░░▄░░░░░░░░░░░░░░▄░░░░ "+"\"So Doge\"");
        			  				System.out.println(" ░░░░░░░░▌▒█░░░░░░░░░░░▄▀▒▌░░░");
        			  				System.out.println(" ░░░░░░░░▌▒▒█░░░░░░░░▄▀▒▒▒▐░░░ "+ "\"Such Score\"");
        			  				System.out.println(" ░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐░░░");
        			  				System.out.println(" ░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐░░░ "+"\"Much Minesweeping\"");
        			  				System.out.println(" ░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌░░░");
        			  				System.out.println(" ░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒▌░░ " +"\"Wow\"");
        			  				System.out.println(" ░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐░░");
        			  				System.out.println(" ░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄▌░");
        			  				System.out.println(" ░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▌░");
        			  				System.out.println(" ▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒▐░");
        			  				System.out.println(" ▐▒▒▐▀▐▀▒░▄▄▒▄▒▒▒▒▒▒░▒░▒░▒▒▒▒▌");
        			  				System.out.println(" ▐▒▒▒▀▀▄▄▒▒▒▄▒▒▒▒▒▒▒▒░▒░▒░▒▒▐░");
        			  				System.out.println(" ░▌▒▒▒▒▒▒▀▀▀▒▒▒▒▒▒░▒░▒░▒░▒▒▒▌░");
        			  				System.out.println(" ░▐▒▒▒▒▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▒▄▒▒▐░░");
        			  				System.out.println(" ░░▀▄▒▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▄▒▒▒▒▌░░");
        			  				System.out.println(" ░░░░▀▄▒▒▒▒▒▒▒▒▒▒▄▄▄▀▒▒▒▒▄▀░░░" +"CONGRATULATIONS!");
        			  				System.out.println(" ░░░░░░▀▄▄▄▄▄▄▀▀▀▒▒▒▒▒▄▄▀░░░░░ "+"YOU HAVE WON!");
        			  				System.out.println(" ░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▀▀░░░░░░░░ "+"SCORE: "+score);
        			  				
        			  				
        			  				
        			  				
        			  				
        			  				
        			  				
        			  				
        			  				System.exit(0);
        			  			}// if game won
            	  } // for b
        	  }// for a
        	  
         }  // if error statement
        	  
         if(fog!=false)
         {
        	 rounds++;
        	 System.out.println("\n Rounds Completed: "+ rounds);
        	 printGrid();
         } 
        	 }// game for loop
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
          }// main
        	 
        	 	} // end    
        	
              
          
            	  
              
              
              
      
        	  
        	  
        	  
        	  
        	  
        	  
        	  
        	  
        	  
        	  
        	  
        	  
        	  
        	  
        	  
        	 
           // Minesweeper 
 
     