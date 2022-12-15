package yutGame.Buttons;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

import yutGame.*;
import yutGame.Controllers.*;
import yutGame.drawTools.RoundedButton;

public class PlayerButton extends RoundedButton implements ActionListener{
	
	private YutBoardFrame frame;
	private int number; // 현재 말의 번호 마킹 
	private int now_pos; // 현재 말의 위치 
	private boolean done; // 말이 한 바큌를 다 돌았는가 알려주는 변수 
	
	public PlayerButton(YutBoardFrame f, PlayerController p, int n, int w, int h, int r, Color c) {
		super(w,h,r,c);
		frame = f;
		number = n;
		addActionListener(this);
	}
	// 플레이어 버튼의 현재위치를 설정하고 불러오는 함수 
	public int getPosition() {
		return now_pos;
	}
	public void setPosition(int n) {
		now_pos = n;
	}
	// 해당 말이 다시 출발지점으로 골인 했는가 
	public void Done() {
		done = true;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(!done)
			frame.selectedPlayer(number);
		
	}
}
