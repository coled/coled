  import java.io.File;
  import java.util.Scanner;
  import java.util.Random;
 
  /**                                                                                                                   
   * This class represents a Minesweeper game.                                                                          
   *                                                                                                                    
   * @author Cole Downing <coled@uga.edu>                                                                               
   */
 public class Minesweeper {
 
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
	 
	 int rows;
	 int cols;
	 double mines;
	 int rounds;
	 int grid [] [];
	 
     public Minesweeper(File seedFile) {
         // TODO implement                                                                                             
 
    	 seedFile = new File("seed1.txt");
    	 
    	try (Scanner file = new Scanner(seedFile)) {
    	
    	// first line for game board size
    	 rows = file.nextInt();
    	 cols = file.nextInt();
    	 
    	 // second line for mines
    	 mines = file.nextInt();
    	 
    	 // mine locations
    	 for (int i = 1; i <= mines; i+=1) {
    		 int minerow = file.nextInt();
    		 int minecol = file.nextInt();
    	 } // for
    		 
    	} catch (Exception e) {
    		 
    	} // try
    	 
     } // Minesweeper                                                                                                  
 
 
     /**                                                                                                               
      * Constructs an object instance of the {@link Minesweeper} class using the                                       
      * <code>rows</code> and <code>cols</code> values as the game grid's number                                       
      * of rows and columns respectively. Additionally, One quarter (rounded up)                                       
      * of the squares in the grid will will be assigned mines, randomly.                                              
      *                                                                                                                
      * @param rows the number of rows in the game grid                                                                
      * @param cols the number of cols in the game grid                                                                
      */
     public Minesweeper(int rows, int cols) {
 
         // TODO implement     
    	 
    	 
    	 if(((rows < 1) || (rows >10)) || ((cols < 1) || (cols >10))) {
    		 System.out.println("ಠ_ಠ says,\" \"Cannot create a mine field with that many rows and/or columns!\"");
    	 System.exit(0);
    	 } // if
    	 
    	 int [][] grid = new int [cols] [rows];  // initializes grid size
    	 
    	 for(int i= 0; i < cols; i++){  // loop to initialize values to default 
    		 grid[i][0] = 0;
    		 grid[0][i] = 0;
    	 }
    	 
    	 mines = ((rows * cols) * .1) + 1;   // determines # of mines
    	 Random randomnumber = new Random(); // random # for mine locations
    	 
    	 for (int i=0 ; i <= mines ; i++){
    		 int randomrow = randomnumber.nextInt(10);
    		 int randomcol = randomnumber.nextInt(10);
    		 grid [randomrow][randomcol] = 9;  // using 9 to mark mines because of int array
    		 
    		 
    	 } // for
    	 
    	 
     } // Minesweeper    
     
     /**                                                                                                               
           * Starts the game and execute the game loop.                                                                     
           */
          public void run() {
      
              // TODO implement                                                                                             
      
              System.out.println("\t_");
              System.out.println("  /\\/\\ (_)_ __   ___  _____      _____  ___ _ __   ___ _ __");
              System.out.println(" /    \\| | '_ \\ / _ \\/ __\\ \\ /\\ / / _ \\/ _ \\ '_ \\ / _ \\ '__|");
              System.out.println("/ /\\/\\ \\ | | | |  __/\\__ \\\\ V  V /  __/  __/ |_) |  __/ |");
              System.out.println("\\/    \\/_|_| |_|\\___||___/ \\_/\\_/ \\___|\\___| .__/ \\___|_|");
              System.out.println("\t\t\t\t     ALPHA |_| EDITION");
      
              System.out.println("\n Rounds Completed: "+ rounds);
      
              for(int i = 0; i <= grid[cols].length ; i++){
            	  System.out.println(" "+i+" ");
            	  System.out.println("");
            	  
            	  
              }
              
              
      
      
          } // run                                                                                                          
      
      
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

        	  Minesweeper game = null;
        	   
        	            switch (args.length) {
        	   
        	            // random game                                                                                               
        	            case 1:
        	   
        	                int rows  = 10;
        	                int cols = 10;
        	                
        	                // try to parse the arguments and create a game                                                          
        	        //        try {
        	          //          rows = Integer.parseInt(args[0]);
        	            //      cols = Integer.parseInt(args[1]);
        	                   game = new Minesweeper(rows , cols);
        	                   break;
        	             //  } catch (NumberFormatException nfe) {
        	                   // line intentionally left blank                                                                     
        	             //  } // try                                                                                                 
        	   
        	           // seed file game                                                                                            
        	           case 2:
        	   
        	               String filename = args[0];
        	               File file = new File(filename);
        	  
        	               if (file.isFile()) {
        	                   game = new Minesweeper(file);
        	                   break;
        	               } // if                                                                                                  
        	   
        	          // display usage statement                                                                                   
        	           default:
        	   
        	               System.out.println("Usage: java Minesweeper [FILE]");
        	               System.out.println("Usage: java Minesweeper [ROWS] [COLS]");
        	               System.exit(0);
        	   
        	           } // switch                                                                                                  
        	  
        	           // if all is good, then run the game                                                                         
        	           game.run();
        	  
        	      } // main                      
     
 } // Minesweeper 
     
     