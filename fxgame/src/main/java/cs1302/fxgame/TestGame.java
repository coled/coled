package cs1302.fxgame;

/*
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import javafx.scene.layout.StackPane;

*/

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;


import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TestGame extends Game {

	   public int spdx= 3;
	   public int spdy= 3;
	   public int padx= 7;
	   public int pady= 7;
	   public int score = 0;
	   public int lives = 3;
	   public int level = 1;
	   public int levelcap = 24;
	   public int levelcount= 1;
	   public int padlength = 185;
	   public boolean gameover= false;
	   public boolean nextlevel = false;
	   public int pause = 0;

//	  Image img = new Image("src/main/UGA logo_4.jpg");
	//   ImageView image = new ImageView(img);
	   
	  
	   
	   
	   
	   
    // rectangle to hold the background
    private Rectangle bg = new Rectangle(0, 0, 640, 480) {{ 
         setFill(Color.SILVER);
     
    }};

	
	 
	   
   
    // paddle rectangle
    private Rectangle paddle = new Rectangle(0, 0, padlength, 12) {{
    	 setTranslateX(244);
         setTranslateY(465);
         setFill(Color.BLACK);
    }};
    
    public void setPaddle(int padlength){
    	paddle.setWidth(padlength);
    }

    private Circle ball = new Circle() {{
       setTranslateX(324);
       setTranslateY(450);
       setRadius(7);
        setFill(Color.BLACK);
   }};
    
  
   
  
    
   public Rectangle [] [] blocks = new Rectangle[4][6];
  
   public int [] [] count = new int [4] [6];
   
   
   
   
  public void setCount( int [] [] count){
	  for(int i = 0; i < 4; i++){
		   for(int j=0; j < 6; j++){
			   count [i] [j] = 0;
		   } // j
		   }// i
  }//setCount
		   
		   
  
   int x = 75;
   int y = 60;
   int c = 0;
   
   
   
   public void setBlocks( Rectangle [][] blocks){
	   
	   
	   Rectangle block = new Rectangle();
	   for(int i = 0; i < 4; i++){
		  
		   for(int j=0; j < 6; j++){
			   block = new Rectangle(x, y, 80, 30) {{
				   if(c == 0){
			         setFill(Color.MAROON);
				   } if(c ==1){
					  setFill(Color.FIREBRICK);   
				   } if(c ==2){
					   setFill(Color.CRIMSON);
				   } if(c ==3){
					   setFill(Color.RED);
				   }
				   
			    }};
			    
			    blocks [i] [j] = block;
			    x = x + 81;
			    
		   }// for j
		   x=75;
		  y = y + 31;
		   c++;
	   } // for i
	   
	    x = 75;
	   y = 60;
	    c = 0;
   } // setBlocks
   
   
   public void printBlocks(){
	   
	   for(int i = 0; i < 4; i++){   
		   for(int j=0; j < 6; j++){
			    getSceneNodes().getChildren().addAll(blocks[i][j]);    
		   }// for j
	   } // for i
	   
   }//print blocks
   
   public void checkBricks(){
	   
	   for(int i = 0; i < 4; i++){   
		   for(int j=0; j < 6; j++){
			   if(ball.getBoundsInParent().intersects(blocks[i][j].getBoundsInParent()))
			   {
				   
				   ball.setTranslateX(ball.getTranslateX() - spdx);
			       ball.setTranslateY(ball.getTranslateY() + spdy);
			       
				   spdy *=-1;
				   
				   ball.setTranslateX(ball.getTranslateX() + spdx);
			       ball.setTranslateY(ball.getTranslateY() - spdy);
			   
			        
				    if(ball.getBoundsInParent().intersects(blocks[i][j].getBoundsInParent()))
				   {
					   spdy *=-1;
					   spdx *=-1;
				   }
				   
				   count [i] [j]++;
				   int c = count [i] [j];
				  
				   hitBrick( c , blocks[i][j], i, j);
			   }
	   } // for j
   } // for i
   
   }// checkBricks
   
   
   
   
   public void hitBrick(int count, Rectangle block, int row, int col){
	   if(count == 1){
/*	   block.setFill(Color.WHITE);
	   }if(count == 2){
		   block.setFill(Color.BLACK);
	   }if(count == 3){
*/        getSceneNodes().getChildren().remove(block);
		   blocks [row] [col] = new Rectangle();
		   score++;
	   }
	   
	   if(score == levelcap){
		   nextlevel = true;
		   levelcap += 24;
	   }
   }
   
   
   
   
   public void checkSides(){
	   
	   if(ball.getTranslateX() + spdx >= 640){
		 spdx *= -1;
	   }
	   if(ball.getTranslateX() <= 0){
		   spdx *= -1;
	   }
	   if(ball.getTranslateY() <= 20){
		   spdy *= -1;
	   }
	   if(ball.getTranslateY() >= 470){
		   spdy *= -1;
		   lives--;
		   ball.setTranslateX(300);
	       ball.setTranslateY(410);
	   }
	   
   }//checkSides
   
   
   public void checkPaddle(){
	   if(ball.getBoundsInParent().intersects(paddle.getBoundsInParent()))
	   	{
		   ball.setTranslateX(ball.getTranslateX() - spdx);
	       ball.setTranslateY(ball.getTranslateY() + spdy);
	       
		   spdy *=-1;
		   
		   ball.setTranslateX(ball.getTranslateX() + spdx);
	       ball.setTranslateY(ball.getTranslateY() - spdy);
	   	}
	   
	   if(ball.getBoundsInParent().intersects(paddle.getBoundsInParent()))
	   		{
			   spdy *=-1;
			   spdx *=-1;
	   		}
	     }//checkPaddle
   
   public void paddleBounds(){
	   if(paddle.getTranslateX() >= 490){
		   paddle.setTranslateX(490);
	   }
	   else if(paddle.getTranslateX() <= 0){
		   paddle.setTranslateX(0);
	   }
   }
   
   public void gameOver(int lives){
	   if(lives < 0){
		   gameover = true;
		   
		   
	   }
   }
   
   private Text text = new Text() {{
       setTranslateX(5);
       setTranslateY(11);
       setFill(Color.BLACK);
     
  }};


  
  public void levelUp(){
	  levelcount ++;
	     lives++;
	     level++;
	    
		  spdx = 3;
		  spdy = 3;
	  	 spdx +=levelcount;
	     spdy +=levelcount;
	  	 padx +=2;
	  	 pady +=2;
	  	 
	  	 if(padlength >= 80)
	  	 {
	  	 padlength -= 5;
	  	 }
	  	 setPaddle(padlength);
	  setCount(count);
      setBlocks(blocks);
	  getSceneNodes().getChildren().removeAll(bg, paddle, ball, text);
	  getSceneNodes().getChildren().addAll(bg, paddle, ball, text);
  	  printBlocks();
  	  ball.setTranslateX(300);
      ball.setTranslateY(410);
     
  	
  }
  
   
    /**
     * Constructs a new test game.
     * @param stage the primary stage
     */
    public TestGame(Stage stage) {
        super(stage, "Breakout", 60, 640, 480);
        getSceneNodes().getChildren().addAll(bg, paddle, ball, text);
        setCount(count);
        setBlocks(blocks);
    	printBlocks();
    	
    	
    	
    } // TestGame

    @Override
    public void update(Game game, GameTime gameTime) {
       nextlevel = false;
    	  text.setText("SCORE: "+ score+ "                                                "
    	  		+ "    LEVEL: "+level+""
    	  		+ "                                                       LIVES: "+lives);
    	   
    	   
    	//text.setText("The time is " + gameTime.getTotalGameTime());
  
        paddleBounds();
    	  
        if (game.getKeyManager().isKeyPressed(KeyCode.LEFT)) paddle.setTranslateX(paddle.getTranslateX() - padx);
        if (game.getKeyManager().isKeyPressed(KeyCode.RIGHT)) paddle.setTranslateX(paddle.getTranslateX() + pady);
        
        
        
        
      checkSides();
      checkBricks();
      checkPaddle();
      
      gameOver(lives);
      
      if(gameover == true){
    	  game.stop();
    	  System.out.println("GAMEOVER");
		   Text end = new Text(){{
			   setTranslateX(100);
			   setTranslateY(250);
			   setFill(Color.CRIMSON);
		   }};
		   
		   end.setText("GAME OVER\n" + "SCORE: " + score);
		   end.setFont(Font.font ("Verdana", 75.0));
		   getSceneNodes().getChildren().addAll(end);
      }
      
      if(nextlevel == true){
    	  
    	  levelUp();
      }
      
      
        ball.setTranslateX(ball.getTranslateX() + spdx);
        
        ball.setTranslateY(ball.getTranslateY() - spdy);
      
        
        
        
    } // update

    
} // TestGame

