package yutGame.Buttons;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

import yutGame.YutBoardFrame;
import yutGame.Controllers.*;
import yutGame.drawTools.RoundedButton;

public class RollButton extends RoundedButton implements ActionListener{
	
	private YutController yuts;
	private YutBoardFrame frame;
	
	public RollButton(YutController y, YutBoardFrame f, int w, int h, int r, Color c) {
		super(w,h,r,c);
		yuts = y;
		frame = f;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		yuts.rollYuts();
		yuts.calYutsState();
		frame.rolledYut(yuts.getYuts(), yuts.getStrState());
	}
}
