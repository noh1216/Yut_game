package yutGame.Buttons;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

import yutGame.YutBoardFrame;
import yutGame.drawTools.RoundedButton;

public class YutStateButton extends RoundedButton implements ActionListener{

	private String this_state;
	private YutBoardFrame frame;
	private PlayerButton player_btn;
	
	public YutStateButton(YutBoardFrame f ,String n, int w, int h, int r, Color c) {
		super(w,h,r,c);
		frame = f;
		this_state = n;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(this_state.equals("도")) frame.onBoardCell( , 1);
		else if(this_state.equals("개")) frame.onBoardCell( , 2);
		else if(this_state.equals("걸")) frame.onBoardCell( , 3);
		else if(this_state.equals("윷")) frame.onBoardCell( , 4);
		else if(this_state.equals("모")) frame.onBoardCell( , 5);
		else;
	}
}
