package cs1302.p2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import cs1302.effects.Artsy;

public class MyArtsy implements Artsy {

	
    @Override
    public BufferedImage doCheckers(BufferedImage src1, BufferedImage src2, int size) {
    	
         int w = Math.max(src1.getWidth(), src2.getWidth());
         
         int h = Math.max(src1.getHeight(), src2.getHeight());
         
         int check = size;

         BufferedImage checked = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
         
         Graphics2D g = (Graphics2D) checked.getGraphics();
         
         for (int rows = 0; rows <= h / check; rows++)
         {
             for (int cols = 0; cols <= w / check; cols++)
             {
                 BufferedImage result = src1;
                 
                 if ((rows+cols) % 2 == 0) {
                     result = src2;
                 }
                 
                 int dX = cols * check;
                 int dY = rows * check;
                 int dX1 = dX + check;
                 int dY1 = dY + check;
                 int sX = cols * check;
                 int sY = rows * check;
                 int sX1 = dX + check;
                 int sY1 = dY + check;
                 
                 g.drawImage(result, dX, dY, dX1, dY1, sX, sY, sX1, sY1, null);
                 
             }//for
         }//for
    	
         return checked;
         
    } // doCheckers

    @Override
    public BufferedImage doHorizontalStripes(BufferedImage src1, BufferedImage src2, int height) {
    	
        int w = Math.max(src1.getWidth(), src2.getWidth());
        
        int h = Math.max(src1.getHeight(), src2.getHeight());
        

        BufferedImage horiz = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        
        Graphics2D g = (Graphics2D) horiz.getGraphics();
        
        
            for (int i = 0; i <= w / height; i++)
            {
                BufferedImage result = src1;
                
                if (i % 2 == 0) {
                    result = src2;
                }
                
                int dX = 0;
                int dY = i * height;
                int dX1 = w;
                int dY1 = dY + height;
                int sX = 0;
                int sY = i * height;
                int sX1 = w;
                int sY1 = dY + height;
                
                g.drawImage(result, dX, dY, dX1, dY1, sX, sY, sX1, sY1, null);
                
            }//for
       
   	
	return horiz;
    } // doHorizontalStripes

    @Override
    public BufferedImage doRotate(BufferedImage src, double degrees) {
    	
    	degrees =Math.toRadians(degrees);
    	
    	ImageIcon i = new ImageIcon(src);
    	
    	BufferedImage blank = new BufferedImage(i.getIconWidth(), i.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
    	Graphics2D g2 = (Graphics2D) blank.getGraphics();
    	
    	AffineTransform rt = new AffineTransform();
    	g2.rotate(degrees, i.getIconWidth() / 2, i.getIconHeight()/2);
    	rt.rotate(degrees, i.getIconWidth()/2, i.getIconHeight()/2 );
       
        g2.drawImage(src,  0,  0,  null);
       
    	
	return blank;
    } // doRotate

    
    
    @Override
    public BufferedImage doVerticalStripes(BufferedImage src1, BufferedImage src2, int width) {
    	
    	   int w = Math.max(src1.getWidth(), src2.getWidth());
           
           int h = Math.max(src1.getHeight(), src2.getHeight());
           

           BufferedImage vert = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
           
           Graphics2D g = (Graphics2D) vert.getGraphics();
           
           
               for (int i = 0; i <= w / width; i++)
               {
                   BufferedImage result = src1;
                   
                   if (i % 2 == 0) {
                       result = src2;
                   }
                   
                   int dX = i * width;
                   int dY = 0;
                   int dX1 = dX + width;
                   int dY1 = h;
                   int sX = i * width;
                   int sY = 0;
                   int sX1 = dX + width;
                   int sY1 =  h;
                   
                   g.drawImage(result, dX, dY, dX1, dY1, sX, sY, sX1, sY1, null);
                   
               }//for
          
	return vert;
    } // doVerticalStripes

    
    
    @Override
    public Dimension getMinDimension(BufferedImage src1, BufferedImage src2) {
	return null;
    } // getMinDimension

} // MyArtsy

