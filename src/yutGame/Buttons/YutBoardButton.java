package yutGame.Buttons;

import javax.swing.*;

import yutGame.YutBoardFrame;
import yutGame.drawTools.RoundedButton;

import java.awt.event.*;
public class YutBoardButton extends RoundedButton implements ActionListener{
	
	private int cell_number;
	private YutBoardFrame frame;
	
	public YutBoardButton(int n, int w, int h, int r, YutBoardFrame f) {
		super(w,h, r);
		cell_number = n;
		frame = f;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		frame.drawPiece(cell_number);
	}
}
