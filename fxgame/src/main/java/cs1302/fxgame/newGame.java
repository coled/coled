package cs1302.fxgame;



import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * @author Cole Downing 
 * 
 */
public class newGame extends Game {

	   public int spdx= 6;
	   public int spdy= 6;
	   public int padx= 10;
	   public int score = 0;
	   public int lives = 3;
	   public int level = 1;
	   public int levelcap = 24;
	   public int levelcount= 1;
	   public int padlength = 250;
	   public boolean gameover= false;
	   public boolean gamestart = false;
	   public boolean nextlevel = false;
	   public int pause = 0;
	   public int hit = 0;
	   public int padcount = 0;
	   public int x = 40;
	   public int y = 60;
	   public int c = 1;
	   public boolean pad = false;

	   	   
	   
    // rectangle for the background the background
    private Rectangle bg = new Rectangle(0, 0, 800, 600) {{ 
         setFill(Color.SILVER);
     
    }};

	
	 
	   
   
    // the paddle rectangle
    private Rectangle paddle = new Rectangle(0, 0, padlength, 30) {{
    	 setTranslateX(400);
         setTranslateY(582);
         setFill(Color.BLACK);
    }};
    
    // method used to change paddle length, optional
    public void setPaddle(int padlength){
    	paddle.setWidth(padlength);
    	paddle. setTranslateX(400);
        paddle.setTranslateY(582);
    }
    
    // makes a circle for the ball
    private Circle ball = new Circle() {{
       setTranslateX(400);
       setTranslateY(570);
       setRadius(9);
        setFill(Color.BLACK);
   }};
    
  
   
  
    // this array of blocks represents the bricks on screen 4X6
   public Rectangle [] [] blocks = new Rectangle[4][6];
  
   // this 2d array represents the hit values, or states of the bricks, hence the 4x6 size
   public int [] [] count = new int [4] [6];
   
   
   
   // sets the states for all bricks to 0 before each level
  public void setCount( int [] [] count){
	  for(int i = 0; i < 4; i++){
		   for(int j=0; j < 6; j++){
			   count [i] [j] = 0;
		   } // j
		   }// i
  }//setCount
		   
		   
  
   
   
   // creates the bricks, assigns the colors and adds them to the blocks array
   public void setBlocks( Rectangle [][] blocks){
	   
	   x=95;
	   y = 95;
	   Rectangle block = new Rectangle();
	   for(int i = 0; i < 4; i++){
		  c=level;
		   for(int j=0; j < 6; j++){
			   block = new Rectangle(x, y, 100, 35) {{
				   if(c %1== 0){
			         setFill(Color.RED);
				   } if(c %2==0){
					  setFill(Color.ORANGE);   
				   } if(c %3 ==0){
					   setFill(Color.YELLOW);
				   } if(c %4==0){
					   setFill(Color.LIMEGREEN);
				   }  if(c %5==0){
					   setFill(Color.DODGERBLUE);
				   }  if(c %6==0){
					   setFill(Color.VIOLET);
				   }  
			  
			    }};  
			    blocks [i] [j] = block;
			    x = x + 101;    
			    c++;
		   }// for j 
		   x=95;
		   y = y + 36;
		   c++;
	   } // for i 
	    x = 95;
	    y = 95;
	    c = 0;
   } // setBlocks
   
   
    
   // adds the brick array blocks to the screen
   public void printBlocks(){
	   
	   for(int i = 0; i < 4; i++){   
		   for(int j=0; j < 6; j++){
			    getSceneNodes().getChildren().addAll(blocks[i][j]);    
		   }// for j
	   } // for i
	   
   }//print blocks
   
   
   // this method checks if the ball hits a brick if so calls the hit() method
   public void checkBricks(){
	   // the for loops iterate through all the bricks
	   for(int i = 0; i < 4; i++){   
		   for(int j=0; j < 6; j++){
			   if(ball.getBoundsInParent().intersects(blocks[i][j].getBoundsInParent()))
			   {
				   // this reverses the y coordinate, for top or bottom impact
				   ball.setTranslateX(ball.getTranslateX() - spdx);
			       ball.setTranslateY(ball.getTranslateY() + spdy);
			       
				   spdy *=-1;
				   
				   // this reverses the balls position by 1 iteration, with the reversed y to check for side impacts
				   ball.setTranslateX(ball.getTranslateX() + spdx);
			       ball.setTranslateY(ball.getTranslateY() - spdy);
			       
			        // checks for side impact
				    if(ball.getBoundsInParent().intersects(blocks[i][j].getBoundsInParent()))
				   {
				    	ball.setTranslateX(ball.getTranslateX() - spdx);
					       ball.setTranslateY(ball.getTranslateY() + spdy);
					   spdy *=-1;
					   spdx *=-1;
					 
				   }
				   // changes the bricks count of hits
				   count [i] [j]++;
				   int c = count [i] [j];
				  // calls hitBrick method
				   hitBrick( c , blocks[i][j], i, j);
			   }
	   } // for j
   } // for i
   
   }// checkBricks
   
   
   
   // this method changes a bricks state dependent on its hit count in the count 2d array
   public void hitBrick(int count, Rectangle block, int row, int col){
	   hit++;
	 if(count == 1){
	   block.setFill(Color.WHITE);
	   }
	 if(count == 2){
		   block.setFill(Color.BLACK);
	   }
	 if(count == 3){
		   // removes the brick from the game, and sets a new un-initialized rectangle in its place in the array
        getSceneNodes().getChildren().remove(block);
		   blocks [row] [col] = new Rectangle();
		   score = score + 1;
	   }
	   
	   if(score == levelcap){
		   nextlevel = true;
		   levelcap += 24;
	   }
   }
   
   // this method makes the Enter text blink every time the ball bounces
   // the int hit counts the balls impact with sides and bricks
   public void enter(int hit){
	   if(hit == 0 ){
		   enter.setFill(Color.WHITE);
		 //  end.setFill(Color.LIME);
	   }if(hit == 1 ){
		   enter.setFill(Color.ORANGERED);
		 //  end.setFill(Color.LIME);
	   }if(hit == 3 ){
		   enter.setFill(Color.MEDIUMBLUE);
		 //  end.setFill(Color.LIME);
	   }if(hit == 4 ){
		   enter.setFill(Color.CRIMSON);
		 //  end.setFill(Color.LIME);
	   }if(hit == 5 ){
		   enter.setFill(Color.LIME);
		 //  end.setFill(Color.LIME);
	   }if(hit %1 == 0 ){
		   enter.setFill(Color.RED);
		 //  end.setFill(Color.LIME);
	   } if(hit %2 == 0 ){
		   enter.setFill(Color.ORANGE);
		  // end.setFill(Color.YELLOW);
	   } if(hit %3 == 0 ){
		   enter.setFill(Color.YELLOW);
		  // end.setFill(Color.RED);
	   } if(hit %4 == 0 ){
		   enter.setFill(Color.LIMEGREEN);
		  // end.setFill(Color.BLUE);
	   } if(hit %5 == 0 ){
		   enter.setFill(Color.DODGERBLUE);
		  // end.setFill(Color.BLUE);
	   }if(hit %6== 0 ){
		   enter.setFill(Color.VIOLET);
		  // end.setFill(Color.VIOLET);
		   
	   } 
   }
   
   
   // this checks if the ball makes contact with the boundaries of the game, 
   // if so it bounces the ball by flipping the appropriate x or y
   public void checkSides(){
	   
	   if(ball.getTranslateX() + spdx >= 795){
		 spdx *= -1;
		 hit++;
	  
	   }
	   if(ball.getTranslateX() + spdx <= 5){
		   spdx *= -1;
		   hit++;
	   }
	   if(ball.getTranslateY() - spdy <= 15){
	    		   spdy *=-1;
	    	          hit++;	   
	   }
	   if(ball.getTranslateY() - spdy  >= 599){
		   if(hit %3 ==0){
			   spdy *= -1;
			   spdx *=-1;
		   }else
			   spdy *=-1;
		   lives--;
		   ball.setTranslateX(400);
	       ball.setTranslateY(570);
	   }if(ball.getTranslateY() <= 0){
		   spdy *=-1;
	   	}
	   
	   
   }//checkSides
   
   
  // checks for the ball hitting the paddle, if so bounces it by flipping the y value
   public void checkPaddle(){
	   if(ball.getBoundsInParent().intersects(paddle.getBoundsInParent()))
	   	{
		   hit++;
		   padcount++;
		   ball.setTranslateX(ball.getTranslateX() - spdx);
	       ball.setTranslateY(ball.getTranslateY() + spdy);	       
	       if(hit + padcount %17 ==0) 
	       {
	    	   spdy *=-1; spdx*=-1;
	       } else spdy *=-1;
	       
	   	}//if
	     }//checkPaddle
   
   
   // checks if paddle is moved to the games x boundaries.
   // if so it is re-translated to its max left or right position
   public void paddleBounds(){
	   if(paddle.getTranslateX() >= 555){
		   paddle.setTranslateX(560);
	   }
	   else if(paddle.getTranslateX() <= 1){
		   paddle.setTranslateX(0);
	   }
   }
   
   
   // this method checks for lives to be < 0. if so it makes the boolean gameover = true.
   public void gameOver(int lives){
	   if(lives < 0){
		   gameover = true;
	   }
   }//gameOver
   
   
   // this is the text for the score , level, and lives
   private Text text = new Text() {{
       setTranslateX(5);
       setTranslateY(11);
       setFill(Color.BLACK);
     
  }};

  
  // this method is used to enter the first level from the intro/demo 
public void firstLevel(){
	
	  levelcount = 1;
	  levelcap = 24;
	     lives = 3;
	     level = 1;
	     score = 0;
		  spdx = 6;
		  spdy = 6;
	  	  
	  //	 setPaddle(padlength);
	     setCount(count);
	     setBlocks(blocks);
	     getSceneNodes().getChildren().removeAll(bg, paddle, ball, text);
	     
	  getSceneNodes().getChildren().addAll(bg, paddle, ball, text); 
	  printBlocks();
	  ball.setTranslateX(400);
      ball.setTranslateY(570);
      paddle.setTranslateX(400);
      paddle.setTranslateY(582);
}
 

// this method is called to create the next levels value, grants lives, increases ball speed etc. 
  public void levelUp(){
	  levelcount ++;
	     lives++;
	     level++;
	    
		  spdx = 6;
		  spdy = 6;
	  	 spdx +=level;
	     spdy +=level;
	  	 padx +=3;
	  	
	  	 
	  	 setPaddle(padlength);
	  setCount(count);
      setBlocks(blocks);
	  getSceneNodes().getChildren().removeAll(bg, paddle, ball, text, end, name, enter);
	  
	  // this is for the demo, allows for increasing levels during the intro/demo
	  if(gamestart==false){
	  getSceneNodes().getChildren().addAll(bg, paddle, ball, text, end, name, enter);
	  } else{
		  getSceneNodes().getChildren().addAll(bg, paddle, ball, text);
	  }
  	  printBlocks();
  	  ball.setTranslateX(400);
      ball.setTranslateY(570);
      nextlevel= false;
  	
  }//levelUp
  
  
  // This is the BRICKBREAKER text for the intro
  Text end = new Text(){{
	   setTranslateX(35);
	   setTranslateY(340);
	   setFill(Color.BLACK);
  }};
  
  // this is the text for my name, cole downing
 Text name = new Text(){{
	setTranslateX(240);
	setTranslateY(390);
	setFill(Color.BLACK);
 }};
  
 //this is the text for PRESS ENTER
 Text enter = new Text(){{
		setTranslateX(145);
		setTranslateY(510);
		setFill(Color.WHITE);
	 }};
	  
	 // this is the text for the instructions
	 Text instr = new Text(){{
		   setTranslateX(30);
		   setTranslateY(270);
		   setFill(Color.BLACK);
	  }};

	  // this is the text for the Press the Spacebar
	  Text help = new Text(){{
		   setTranslateX(220);
		   setTranslateY(45);
		   setFill(Color.BLACK);
	  }};
  
   
    /**
     * Constructs a new test game.
     * @param stage the primary stage
     */
    public newGame(Stage stage) {
        super(stage, "Breakout", 60, 800, 600);
        getSceneNodes().getChildren().addAll(bg, paddle, ball, text);
        setCount(count);
        setBlocks(blocks);
        
        
        end.setText("BREAKOUT" );
        end.setFont(Font.font ("Verdana", FontWeight.BOLD, 120.0));
       
        name.setText("By: Cole Downing");
        name.setFont(Font.font("Verdana", 30.0));
        
        enter.setText("Press Enter!");
        enter.setFont(Font.font("Verdana", FontWeight.BOLD, 80.0));
        
        help.setText("Press Space Bar for Instructions!");
        help.setFont(Font.font("Verdana", 20.0));
        
        getSceneNodes().getChildren().addAll(end, name, enter, help);
        
        instr.setText("How To Play:\n\n" + "- The object of the game is to bounce the ball off the paddle in order to break the bricks.\n"
        			+ "- Move the paddle to the left and right using the left and right arrow keys.\n"
        			+ "- Hit a brick 3 times with the ball to break it. \n"
        			+"- If the ball misses the paddle you will lose 1 life.\n"
        			+"- The game starts with 3 lives.\n"
        			+"- If all bricks are broken, you will progress to the next level.\n"
        			+"- In each new level you are granted an additional life and the ball speed will be increased.");
        
    	printBlocks();
    	
    } // TestGame

    
    
    
    // this is where the magic happens. The engine. gamestart boolean turns off the intro/demo
    @Override
    public void update(Game game, GameTime gameTime) {
       
      
    	  text.setText("SCORE: "+ score+ "    \t \t  \t                                         "
    	  		+ "    LEVEL: "+level+""
    	  		+ "                           \t \t \t\t                          LIVES: "+lives);
    	  
  
        paddleBounds();
    	  
        
        if(gamestart == false)
     {
     
        if (game.getKeyManager().isKeyPressed(KeyCode.ENTER)){
        //	System.out.println("wooooo");
        	 getSceneNodes().getChildren().removeAll(end, name, enter);
        	 firstLevel();
        	 nextlevel = false;
        	gamestart = true;
        	   
        }
        
        
        if (game.getKeyManager().isKeyPressed(KeyCode.SPACE)){
        	 getSceneNodes().getChildren().removeAll(end, name);
        	 getSceneNodes().getChildren().addAll(instr);
        	 
        }
        
        
      checkSides();
      checkBricks();
      enter(hit);
    //  gameOver(lives);
      
     
      if(nextlevel == true){
    	  levelUp();
      }
      
      
        ball.setTranslateX(ball.getTranslateX() + spdx);
        ball.setTranslateY(ball.getTranslateY() - spdy);
        paddle.setTranslateX(ball.getTranslateX() - 90);
    
        checkPaddle();
        
        }//gamestart = false
        
        
        
        
        
        
        if(gamestart ==true)
        {

        	 
        	
           
        	  
            if (game.getKeyManager().isKeyPressed(KeyCode.LEFT)) paddle.setTranslateX(paddle.getTranslateX() - padx);
            if (game.getKeyManager().isKeyPressed(KeyCode.RIGHT)) paddle.setTranslateX(paddle.getTranslateX() + padx);
           
            paddleBounds();
            checkPaddle();
           
           
          if(nextlevel == true){        	  
        	  levelUp();
          }
          
          
          
          gameOver(lives);
          
          if(gameover == true){
        	  game.stop();
    		   Text end = new Text(){{
    			   setTranslateX(30);
    			   setTranslateY(350);
    			   setFill(Color.RED);
    			   setFont(Font.font ("Verdana", FontWeight.BOLD, 110.0));
    		   }};
    		   
    		   end.setText("GAME OVER\n" + "SCORE: " + score);
    		   getSceneNodes().getChildren().addAll(end);
          }
          
        
            ball.setTranslateX(ball.getTranslateX() + spdx);  
            ball.setTranslateY(ball.getTranslateY() - spdy);
            
            checkBricks();
            checkPaddle();
            checkSides();
            
            
        }//if gamestart = true
        
        
        
    } // update

    
} // TestGame

