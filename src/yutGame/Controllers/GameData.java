package yutGame.Controllers;

import javax.swing.JLabel;
import javax.swing.JPanel;

import yutGame.Buttons.*;
import yutGame.drawTools.*;

public class GameData {
	
	public YutBoardButton[] yut_board; // 윷 보드 버튼
	public JPanel yuts[]; // 각각의 윷 가락 배열
	public RoundRectDraw[] player1_piece_board; // 보드 안에있는 플레이어 1의 피스 (기본적으로 보이지 않음)
	public RoundRectDraw[] player2_piece_board; // 보드 안에있는 플레이어 1의 피스 (기본적으로 보이지 않음)
	
	public YutStateButton[] yut_states; // 나온 윷의 상태 배열
	public int yut_state_cnt; // 나온 윷의 갯수 (최대 3개) 
	
	public PlayerController player; // 플레이어  
	public String name1, name2; // 플레이어 1,2의 이
	public JLabel nametag1, nametag2; // 플레이어 1,2 의 이름 태그 
	public RoundRectDraw player1_nametag, player2_nametag; // 플레이어 1,2 의 이름 태그 
	
	public GameData() { 
	}
	
}
