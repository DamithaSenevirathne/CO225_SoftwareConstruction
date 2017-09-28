import java.awt.*; /* java abstract window toolkit */
import java.awt.event.*; 
import javax.swing.*;
import java.awt.geom.Line2D;
import java.math.BigDecimal;
import java.util.Random;

class Panel extends JPanel { // inherit JPanel 

	private int width, height; 
	
	public Panel(int width, int height) { 
		// set the panel size 
		this.width  = width; 
		this.height = height; 
		setPreferredSize(new Dimension(width, height)); 	
    }

    private static void printPoint(Graphics2D frame, Color c, Point p) {

		frame.setColor(c); 
		frame.draw(new Line2D.Double(p.getX(), p.getY(),p.getX(), p.getY())); 
    }
}