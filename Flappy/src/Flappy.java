
public class Flappy {

	/**
	 * @param args
	 */
	
	static int rows;
	static int cols;
	static int [] [] grid = new int [15] [15];
	 
    public static void printGrid(){
    	
  	  StringBuffer startGrid = new StringBuffer();
  	  
  	  for(int i= 0; i < grid.length; i++)
  	  { // loop to print out top border
  		  
      		startGrid.append("------");
      	
  	  } //for i	

		
  	  
  	  
		for(int j= 0; j < grid.length+12; j++)
		{
			startGrid.append("\n");
			
		}
  	  
		
		
		
		 for(int i= 0; i < grid.length; i++)
	  	  { // loop to print out bottom border

	      		startGrid.append("------");

	  	  } //for i	
	  	  
  	  
  	  
  	  
  	  	System.out.println(startGrid.toString());
    } // printGrid
    
    
	
	public static void main(String[] args) {
	
		printGrid();
		
	}

}
