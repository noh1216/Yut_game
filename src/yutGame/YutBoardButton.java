package yutGame;

import javax.swing.*;

import yutGame.drawTools.RoundedButton;

public class YutBoardButton extends RoundedButton{
	
	private int cell_number;
	private YutBoardFrame frame;
	
	public YutBoardButton(int n, int w, int h, int r) {
		super(w,h, r);
		cell_number = n;
	}
}
