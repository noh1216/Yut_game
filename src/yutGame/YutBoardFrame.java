package yutGame;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import yutGame.Buttons.PlayerButton;
import yutGame.Buttons.YutBoardButton;
import yutGame.Buttons.YutStateButton;
import yutGame.Controllers.Player;
import yutGame.drawTools.RoundRectDraw;
import yutGame.drawTools.RoundedButton;

public class YutBoardFrame extends JFrame{
	int selected_btn_num;
	YutBoardButton[] yut_board; // 윷 보드 버튼
	JPanel yuts[]; // 각각의 윷 가락 배열 
	YutStateButton[] yut_states; // 나온 윷의 상태 배열 
	PlayerButton[] player1_btns; // 플레이어 1의 말 
	PlayerButton[] player2_btns; // 플레이어 2의 말 
	Player player1, player2;
	
	public YutBoardFrame() {
		
		// 메인 보드 gui구성
		Container mainBoard_container = getContentPane();
		mainBoard_container.setLayout(new BorderLayout());
		
		// 타이틀 설정 
		JLabel title_label = new JLabel("전통윷놀이");
		title_label.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
		Font font_gungseo = new Font("GungSeo",Font.BOLD, 24);
		title_label.setFont(font_gungseo);
		JPanel title_panel = new JPanel(new FlowLayout());
		title_panel.add(title_label);
		
		// 보드 설정
		CreateGUI gui = new CreateGUI();
		yut_board = gui.createYutBoard();
		JPanel board = gui.createBoard(440, 400,yut_board);
        
		// 하단 구성(윷놀이 판, 유저 정보)
		JPanel bottom_panel = new JPanel(new GridLayout(2,1));
		
		// 윷정보 패널 구성
		yuts = gui.createYuts();
		yut_states = gui.createYutStateButton(this);
		JPanel yut_info_panel =  gui.createYutPanel(yuts, yut_states);
		
		// 유저정보 패널 구성
		player1 = new Player();
		player2 = new Player();
		player1_btns = gui.createPlayerButton(this, player1, new Color(0x5A6FDE));
		player2_btns = gui.createPlayerButton(this, player2, new Color(0xE14343));
		JPanel user_info_panel = gui.createUserInfoPanel(player1_btns, player2_btns);
		
		
				
		bottom_panel.add(yut_info_panel);
		bottom_panel.add(user_info_panel);
		
		mainBoard_container.add(title_panel, BorderLayout.NORTH);
		mainBoard_container.add(board, BorderLayout.CENTER);
		mainBoard_container.add(bottom_panel, BorderLayout.SOUTH);
		
		
		setTitle("");
		setSize(500,700);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	
	
	public void selectedPlayer(int num) {
		selected_btn_num = num;
	}
	
	public void yutContainerUpdate(boolean[] yuts, int[] yutState) {
		//미완
	}
	
	public void drawPiece(int cell_num)	{
		//미완
	}
	
	public void onBoardCell(int on_pos, int on_pose_short) {
		//miewan
	}
	
	public static void main(String[] args) {
		new YutBoardFrame();
	}

}
