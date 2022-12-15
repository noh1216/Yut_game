package yutGame.Buttons;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

import yutGame.*;
import yutGame.Controllers.*;
import yutGame.drawTools.RoundedButton;

public class PlayerButton extends RoundedButton implements ActionListener{
	
	private YutBoardFrame frame;
	private int number;
	private int now_pos;
	private boolean done;
	
	public PlayerButton(YutBoardFrame f, PlayerController p, int n, int w, int h, int r, Color c) {
		super(w,h,r,c);
		frame = f;
		number = n;
		now_pos=1;
		addActionListener(this);
	}
	
	public int getPosition() {
		return now_pos;
	}
	public void setPosition(int n) {
		now_pos = n;
	}
	public void Done() {
		done = true;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(!done)
			frame.selectedPlayer(number);
	}
}
