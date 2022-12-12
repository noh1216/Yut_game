package yutGame.drawTools;

import java.awt.*;

import javax.swing.*;

public class DrawLine extends JPanel {
	
	private int x1,y1, x2,y2;
	
	public DrawLine(int xx, int yy, int xxx, int yyy) {
		x1 =xx;
		y1=yy;
		x2=xxx;
		y2=yyy;
		this.setPreferredSize(new Dimension(x2-x1,y2-y1));
	}
	
    public void paintComponent(Graphics g) {
    	super.printComponent(g);
    	g.setColor(Color.BLACK);
    	g.drawLine(x1, y1, x2, y2);
    }
}
