package yutGame.Buttons;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

import yutGame.*;
import yutGame.Controllers.*;
import yutGame.drawTools.RoundedButton;

public class PlayerButton extends RoundedButton implements ActionListener{
	
	private Player player;
	private YutBoardFrame frame ;
	private int number;
	private int now_pos;
	
	public PlayerButton(YutBoardFrame f, Player p, int n, int w, int h, int r, Color c) {
		super(w,h,r,c);
		frame = f;
		player = p;
		number = n;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		frame.selectedPlayer(number);
	}
}
