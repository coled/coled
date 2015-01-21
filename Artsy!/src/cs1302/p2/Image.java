package cs1302.p2;

import cs1302.effects.Artsy;
import cs1302.p2.MainPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Image extends JPanel {

	JButton rotate;
	JButton reset;
	JLabel label;
	
	 JPanel panel2;
	JPanel container;
	File defaultImageFile;
	URL defaultImageURL;
	

	BufferedImage image;
	BufferedImage tempimage;
	URL imageURL;
	JLabel imageLabel;
	JLabel picLabel;
	JLabel imageicon;
	ImageIcon icon;
	Artsy artsy;
	MainPanel panel;
	double deg;
	
	public Image(String imageLabel, String imageName, Artsy artsy) {

	this.artsy = artsy;
	
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			setSize(400, 500);
		
		panel2 = new JPanel();
		
		
		
		
		rotate = new JButton("Rotate");
		rotate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("rotate");
				rotatebox();
				
			}
		});
		reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("reset");
				reset();
			}
		});
			
		try {
			String path = "resources/default.png";
			File imageFile = new File(path);
			imageURL = imageFile.toURI().toURL();
			image = ImageIO.read(imageURL);
			tempimage = image;
			this.imageLabel = new JLabel(imageLabel + imageName);
			} catch (IOException e) {
				System.out.println("error loading image");
				System.exit(0);
			}
		
		this.imageLabel.setSize(300, 300);
		
		add(this.imageLabel);
		add(Box.createRigidArea(new Dimension(0,350)));
		
		panel2.add(rotate);
		panel2.add(reset);
		add(panel2);
	
		
		setVisible(true);
		

	}//image
	
	
	

	
	public Image(String imagelabel, Artsy artsy) {

		this.artsy = artsy;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setSize(400, 500);
		
		panel2 = new JPanel();
		
		rotate = new JButton("Rotate");
		
		rotate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("rotate");
				rotatebox();
			
			}
			
		});
		reset = new JButton("Reset");
		
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("reset");
				reset();
			}
		});
		
		
		
		
		try{
			String path= "resources/default.png";
			File imagefile = new File(path);
			imageURL = imagefile.toURI().toURL();
			image = ImageIO.read(imageURL);
			tempimage = image;
		} catch (IOException e) {
			System.out.println("error");
		}	
		
		
		this.imageLabel = new JLabel(imagelabel);
		
	    this.imageLabel.setSize(300, 300);
		add(this.imageLabel);
		
		add(Box.createRigidArea(new Dimension(0,350)));
		panel2.add(rotate);
		panel2.add(reset);
		add(panel2);
		
		setVisible(true);
		
	} // image

	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D  g2 = (Graphics2D) g;
		g2.drawImage(image, null, 0, 20);
		
	}
	
	
	public BufferedImage getImage(){
		
		return image;
	}
	
	
	public void setImage(File newimage, String imageLabel) {

		this.imageLabel.setText(imageLabel + ": " + newimage.getName());
		
		try{
			imageURL = newimage. toURI().toURL();
			image = ImageIO.read(imageURL);
		}catch (IOException e) {}		
		tempimage = image;
		
		revalidate();
		repaint();
	}

	
	public void setImage(BufferedImage img){
		
		image = img;
		
		revalidate();
		repaint();
	}
	
	public void rotatebox(){
	
	try{
		String input = JOptionPane.showInputDialog(null, "Please enter your angle, in degrees.");
		double deg = Double.parseDouble(input);
		
		if(deg < 0)
		{
			deg = deg + 360;
		} 
	
		setImage(artsy.doRotate(image , deg));
		revalidate();
		repaint();
		
	}catch(NullPointerException e){
		System.out.println("error");
	}
		
	}//rotate
	

	public void reset(){
		
		setDeg(360 - getDeg());
		setImage(tempimage);
		setDeg(0);
		revalidate();
		repaint();
	}
	
	
	public void setDeg(double deg){
		this.deg = deg;
	}
	
	
	public double getDeg(){
		return deg;
	}
	
	
}// image
