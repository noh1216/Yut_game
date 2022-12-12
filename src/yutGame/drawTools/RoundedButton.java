package yutGame.drawTools;

import java.awt.*;

import javax.swing.*;

public class RoundedButton extends JButton {
	
	private int width, height, radius;
	private Color bg_color;
	
    public RoundedButton() { super(); decorate(); } 
    public RoundedButton(int w, int h,int r) { width = w; height=h; radius =r; decorate();}
    public RoundedButton(int w, int h,int r, Color c) { width = w; height=h; radius =r; bg_color = c; decorate();}
    public RoundedButton(String text) { super(text); decorate(); } 
    public RoundedButton(Action action) { super(action); decorate(); } 
    public RoundedButton(Icon icon) { super(icon); decorate(); } 
    public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
    protected void decorate() { setBorderPainted(false); setOpaque(false); }
    @Override 
    protected void paintComponent(Graphics g) {
    	Color c = bg_color; //배경색 결정
    	if(c == null) {
    		c = Color.gray;
    	}
    	Color o= Color.WHITE; //글자색 결정
    	Graphics2D graphics = (Graphics2D) g; 
    	graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
    	if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
    	else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
    	else { graphics.setColor(c); } 
    	graphics.fillRoundRect(0, 0, width, height, radius, radius); 
    	FontMetrics fontMetrics = graphics.getFontMetrics(); 
    	Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
    	int textX = (width - stringBounds.width) / 2; 
    	int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
    	graphics.setColor(o); 
    	graphics.setFont(getFont()); 
    	graphics.drawString(getText(), textX, textY); 
    	graphics.dispose(); 
    	super.paintComponent(g); 
    }
    	
    public int getCellWidth() {
    	return width;
    }
    public int getCellHeight() {
    	return height;
    }
    
}