package yutGame.Buttons;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

import yutGame.YutBoardFrame;
import yutGame.drawTools.RoundedButton;

public class YutStateButton extends RoundedButton implements ActionListener{

	private YutBoardFrame frame;
	int yut_state_pos;
	
	public YutStateButton(YutBoardFrame f,int n ,int w, int h, int r, Color c) {
		super(w,h,r,c);
		frame = f;
		yut_state_pos = n;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.getText();
		if(this.getText().equals("도")) frame.onBoardCell(1, yut_state_pos);
		else if(this.getText().equals("개")) frame.onBoardCell(2,yut_state_pos);
		else if(this.getText().equals("걸")) frame.onBoardCell(3,yut_state_pos);
		else if(this.getText().equals("윷")) frame.onBoardCell(4,yut_state_pos);
		else if(this.getText().equals("모")) frame.onBoardCell(5,yut_state_pos);
		else if(this.getText().equals("뺵도")) frame.onBoardCell(-1, yut_state_pos);
		else;
	}
}
