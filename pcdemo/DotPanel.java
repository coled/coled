import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class DotPanel extends JPanel {

    private int x = 10, y = 10;

    public int getDotX() { return this.x; }
    public void setDotX(int x) { this.x = x; }

    public int getDotY() { return this.y; }
    public void setDotY(int y) { this.y = y; }

    public DotPanel() {

	JLabel l = new JLabel("Sup?");
	add(l);
	
	setBackground(Color.red);

	Dimension d = new Dimension(400, 100);
	setPreferredSize(d);
	setMinimumSize(d);

	requestFocus();

	// setup the keylistener
	addKeyListener(new KeyAdapter() {
		
		public void keyTyped(KeyEvent e) {

		    System.out.println("key typed" + e);

		} // keyTyped

		
		public void keyPressed(KeyEvent e) {

		    System.out.println("key pressed" + e);

		} // keyPressed

	    });

    } // DotPanel


    
    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	// stolen from http://stackoverflow.com/questions/2831206/java2d-jpanel-set-background-color-not-working
	g.setColor(Color.BLACK);
	g.fillRect(this.x, this.y, 20, 20);

    } // paintComponent

} // DotPanel