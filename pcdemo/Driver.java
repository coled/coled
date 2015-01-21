import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;

public class Driver {

    public static void createAndShowGUI() {

	JFrame frame = new JFrame("Push Counter");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JPanel panel = new DotPanel();
	frame.add(panel);

	frame.pack();
	frame.setVisible(true);

    } // createAndShowGUI

    public static void main(String[] args) {

	SwingUtilities.invokeLater(
	    new Runnable() {
		public void run() {
		    Driver.createAndShowGUI();
		} // run
	    } // Runnable
	);

    } // main

} // Driver