package yutGame.Buttons;

import java.awt.event.*;
import javax.swing.*;

import yutGame.YutBoardFrame;
import yutGame.Controllers.*;

public class RollButton extends JButton implements ActionListener{
	
	private YutController yuts;
	private Player player1, player2;
	private YutBoardFrame frame;
	
	public RollButton(YutController y, Player p1, Player p2, YutBoardFrame f) {
		yuts = y;
		player1 = p1; player2 = p2;
		frame = f;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		int yutStateCount;
		int[] yutsStates;
		if(player1.player1Turn()) {
			yuts.rollYuts();
			yuts.calYutsState();
			yutStateCount = yuts.getYutsCount();
			yutsStates = yuts.getYutStates();
			if(yutStateCount >= 3) {
				player1.changeTurn();
			}
			if(yutsStates[yutStateCount] != '4' || yutsStates[yutStateCount] != '5')
				player1.changeTurn();
			frame.yutContainerUpdate(yuts.getYuts(), yutsStates);
		}
		else {
			yuts.rollYuts();
			yuts.calYutsState();
			yutStateCount = yuts.getYutsCount();
			yutsStates = yuts.getYutStates();
			if(yutStateCount >= 3) {
				player2.changeTurn();
			}
			if(yutsStates[yutStateCount] != '4' || yutsStates[yutStateCount] != '5')
				player2.changeTurn();
			frame.yutContainerUpdate(yuts.getYuts(), yutsStates);
		}
	}
}
