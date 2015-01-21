
public class Drawer {

	public static int gridSize = 500;
	public static int  cellSize = 1;
	
	public static void main(String[] args) {
		
		Grid grid = new Grid(gridSize, cellSize, "The Game of Life");
		grid.setDelay(1);
		
		int alive = 1;
		int dead = 0;
		
		
		grid.initialize();
		
		grid.setPos( 250,  250,  alive);
		
		grid.update();
		
		int s = gridSize/2;
		
		for (int i = 0; i < s; i++){
			
			
			
			
			
			
			
		}
		

	}

}
