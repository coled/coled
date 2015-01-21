package cs1302.p2;

import cs1302.effects.Artsy;
import cs1302.p2.Driver;
import cs1302.p2.Image;

import javax.imageio.ImageIO;


import javax.swing.JButton;
import javax.swing.JFileChooser;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;



import java.io.File;

import java.io.IOException;

import java.net.URL;





public  class MainPanel extends JPanel {

	JButton rotate;
	JButton reset;
	JLabel  label;
	
	
	JPanel panel;
	JPanel container;
	BufferedImage defaultImage;
	BufferedImage newImage;
	JLabel image;
	File defaultImageFile;
	URL defaultImageURL;
	
	Image image1;
	Image image2;
	Image image3;
	JPanel imgPanel;
	JPanel topcontainer;
	
	JFileChooser fc;
	Artsy artsy;
	
	public  MainPanel(Artsy artsy)  {
		
		
		
	    // create menu bar
		this.artsy = artsy;
		

		    JButton checkers = new JButton("Checkers");
		    checkers.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent c){
		    		System.out.println("checkers");
		    		
		    		checkers();
		    	}
		    });
		    
		    JButton horiz = new JButton("Horizontal Stripes");
		    horiz.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent h){
		    		System.out.println("horiz");
		    		horiz();
		    		 	}
		    });
		    JButton vert = new JButton("Vertical Stripes");
		    vert.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent v){
		    		System.out.println("ver");
		    		vert();
		    	}
		    });
		    
		  topcontainer = new JPanel();
		   topcontainer.add(checkers);
		   topcontainer.add(horiz);
		   topcontainer.add(vert);
		   topcontainer.setSize( 900, 900);
		  

	
		   // call image
		   
		   
		  image1 = new Image("Image 1: ", "default.png", artsy);
		  image2 = new Image("Image 2: ", "default.png", artsy);
		  image3 = new Image("Result: ", artsy);
		   
		  imgPanel = new JPanel();
		   
		   imgPanel.add(image1).setPreferredSize(new Dimension(330, 400));
		   imgPanel.add(image2).setPreferredSize(new Dimension(330, 400));
		   imgPanel.add(image3).setPreferredSize(new Dimension(330, 400));
		   
	
		   setLayout(new BorderLayout());
		   add(topcontainer, BorderLayout.NORTH);
		   add(imgPanel, BorderLayout.WEST);
		   setPreferredSize(new Dimension(980, 500));
		   
	} // MainPanel
	
	
	
	public JMenuBar setMenu(){
		
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		menuBar.add(file);
		JMenu open = new JMenu("Open");
			
		JMenuItem open1 = new JMenuItem("Open Image 1");
		open1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e){
	    		
	    		filechooser(image1, "Image 1");
	    		
	    	}
	    });
		
	    JMenuItem open2 = new JMenuItem("Open Image 2");
	    open2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e){
	    		
	    		filechooser(image2, "Image 2");
	    		
	    	}
	    });
	    
		JMenuItem save = new JMenuItem("Save Result As");
		save.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e){
	    		
	    		filesaver(image3.getImage());
	    		
	    	}
	    });
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e){
	    	  System.exit(0);
	    	}
	    });
		
		
		 open.add(open1);
		 open.add(open2);
		 file.add(open);
		file.add(save);
		file.add(exit);
		menuBar.add(file);
	
		return menuBar;
	}
 
	
	 public void rotate(BufferedImage img, double deg){
		 artsy.doRotate(img, deg);
		 image1.setImage(img);
	 }
	
	
    public  void  filechooser(Image img, String txt ){
		
    	 fc = new JFileChooser();
    	fc.setDialogTitle("Choose a file");
    	fc.showOpenDialog(MainPanel.this);
    	fc.setVisible(true);
    	
    	File file = fc.getSelectedFile();
    	
    	img.setImage(file, txt);
    	}
    
    
    public void filesaver(BufferedImage img){
    	
    	String format = "png";
    	
    	fc = new JFileChooser();
    	fc.setVisible(true);
    	fc.showSaveDialog(MainPanel.this);
    	File save = fc.getSelectedFile();
    	
    	try {
			String name = save.getCanonicalPath();
			save = new File(name+".png");
			
			ImageIO.write(img,  format,  save);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    
    }
    
    
    
    
    
    
	public void  checkers(){
		
		try{
			
		String input = JOptionPane.showInputDialog(null, "Please enter desired checker width, in pixels.");
		
		
		int check = Integer.parseInt(input);
		
		image3.setImage(artsy.doCheckers(image1.getImage(), image2.getImage(), check));
		revalidate();
		repaint();
		
	}catch(NullPointerException ce){
		System.out.println("error");
	}
	}


	
	public void  horiz(){
		
		try{
			
			String input = JOptionPane.showInputDialog(null, "Please enter desired stripe height, in pixels.");
	    	
		
		int height = Integer.parseInt(input);
		
		image3.setImage(artsy.doHorizontalStripes(image1.getImage(), image2.getImage(), height));
		revalidate();
		repaint();
		
	}catch(NullPointerException ce){
		System.out.println("error");
	}
	}

	
	
public void  vert(){
		
		try{
			
			String input = JOptionPane.showInputDialog(null, "Please enter desired stripe width, in pixels.");
			 
		
		int width = Integer.parseInt(input);
		
		image3.setImage(artsy.doVerticalStripes(image1.getImage(), image2.getImage(), width));
		revalidate();
		repaint();
		
	}catch(NullPointerException ce){
		System.out.println("error");
	}
	}

}//MainPanel