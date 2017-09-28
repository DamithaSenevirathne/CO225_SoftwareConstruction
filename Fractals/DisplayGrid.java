import java.awt.*; /* java abstract window toolkit */
import java.awt.event.*; 
import javax.swing.*;
import java.awt.geom.Line2D;
import java.math.BigDecimal;
import java.util.Random;

class DisplayGrid extends JPanel { // inherit JPanel 

	private int width, height; 
	ColorGrid grid;
	public DisplayGrid(int width, int height, ColorGrid grid) { 
		// set the panel size 
		this.width  = width; 
		this.height = height; 
		this.grid=grid;
		setPreferredSize(new Dimension(width, height)); 	
    }

    private static void printPoint(Graphics2D frame, Color c, int y,int x) {
		frame.setColor(c); 
		frame.draw(new Line2D.Double(x,y,x,y)); 
    }

    public void paintComponent(Graphics g) { 
		super.paintComponent(g); 
		for(int y=0;y<Driver.SCREEN_HEIGHT;y++){
			for(int x=0;x<Driver.SCREEN_WIDTH;x++){
				printPoint((Graphics2D)g,grid.get(y,x),y,x);
			}
		}
    }

    
}