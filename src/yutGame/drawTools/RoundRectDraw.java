package yutGame.drawTools;

import java.awt.*;

import javax.swing.*;

public class RoundRectDraw extends JPanel{
	
	private int width, height, radius;
	private Color bg_color;
	
	public RoundRectDraw(int w, int h, int r, Color bg) {
		width = w;
		height = h;
		radius = r;
		bg_color = bg;
		this.setPreferredSize(new Dimension(w, h));
	}
	public RoundRectDraw(int w, int h, int r, Color bg, LayoutManager m) {
		super(m);
		width = w;
		height = h;
		radius = r;
		bg_color = bg;
		this.setPreferredSize(new Dimension(w, h));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(bg_color);
		g.fillRoundRect(0, 0, width, height, radius, radius); 
    	
	}
}
