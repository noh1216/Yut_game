package yutGame;

import java.awt.*;

import javax.swing.*;

import yutGame.Buttons.PlayerButton;
import yutGame.Buttons.YutBoardButton;
import yutGame.Buttons.YutStateButton;
import yutGame.Controllers.Player;
import yutGame.drawTools.LoadingImage;
import yutGame.drawTools.RoundRectDraw;
import yutGame.drawTools.RoundedButton;

public class CreateGUI {
	
	public YutBoardButton[] createYutBoard() {
		YutBoardButton[] yut_board = new YutBoardButton[30];
		yut_board[0] = new YutBoardButton(0, 40, 40, 50);
		yut_board[0].setText("Start");
		for(int i = 1; i< 30; i++) {
			if((i%5 == 0 && i <= 20)|| i == 23) {
				yut_board[i] = new YutBoardButton(i,30,30, 50);			
			}
			else {
				yut_board[i] = new YutBoardButton(i,25,25, 50);				
			}
		}
		return yut_board;
	}
	
	public JPanel createBoard(int width, int height, YutBoardButton[] yut_board) {
		JPanel p = new JPanel();
		p.setLayout(null);
		
		
		int x_space =50, y_space=50;
		int x_pos = width-x_space+20, y_pos = height-y_space, x_weight = (x_pos-x_space)/5, y_weight = (y_pos-y_space)/5;
		// 오른쪽 1~5
		yut_board[0].setBounds(x_pos-5, y_pos-5, yut_board[0].getCellWidth()+5, yut_board[0].getCellHeight()+5);
		p.add(yut_board[0]);
		for(int i = 1; i< 5; i++) {
			int x = x_pos;
			if(yut_board[i].getCellWidth() == 25) {
				x = x_pos + 5;
			}
			yut_board[i].setBounds(x, y_pos-y_weight*i, yut_board[i].getCellWidth()+5, yut_board[i].getCellHeight()+5);
			p.add(yut_board[i]);
		}
		// 위 6~10
		for(int i = 5; i< 10; i++) {
			yut_board[i].setBounds(x_pos-x_weight*(i-5), y_space, yut_board[i].getCellWidth()+5, yut_board[i].getCellHeight()+5);
			p.add(yut_board[i]);
		}
		// 왼쪽 11~15
		for(int i = 10; i< 15; i++) {
			yut_board[i].setBounds(x_space, y_space+y_weight*(i-10), yut_board[i].getCellWidth()+5, yut_board[i].getCellHeight()+5);
			p.add(yut_board[i]);
		}
		// 아래 16~20
		for(int i = 15; i < 20; i++) {
			int y = y_pos;
			if(yut_board[i].getCellHeight() == 25) {
				y = y_pos + 5;
			}
			yut_board[i].setBounds(x_space+x_weight*(i-15),y, yut_board[i].getCellWidth()+5, yut_board[i].getCellHeight()+5);
			p.add(yut_board[i]);
		}
		
		// 대각선 21~23
		for(int i = 20; i <= 25; i++) {
			int x_w = x_weight - yut_board[i].getCellWidth()/2 + yut_board[i].getCellWidth()/4;
			int y_w = y_weight - yut_board[i].getCellHeight()/2 + yut_board[i].getCellHeight()/4;
			if(i == 23) {
				x_w-= 3;
				y_w-= 3;
			}
			yut_board[i].setBounds(x_pos-x_w*(i-20),y_space+y_w*(i-20), yut_board[i].getCellWidth()+5, yut_board[i].getCellHeight()+5);
			p.add(yut_board[i]);
		}
		// 대각선 24~25
		for(int i = 25; i >= 24; i--) {
			int x_w = x_weight - yut_board[i].getCellWidth()/2 + yut_board[i].getCellWidth()/4;
			int y_w = y_weight - yut_board[i].getCellHeight()/2 + yut_board[i].getCellHeight()/4;
			yut_board[i].setBounds(x_space+x_w*(26-i),y_pos-y_w*(26-i), yut_board[i].getCellWidth()+5, yut_board[i].getCellHeight()+5);
			p.add(yut_board[i]);
		}
		
		// 대각선 26~27
		for(int i = 26; i <= 27; i++) {
			int x_w = x_weight - yut_board[i].getCellWidth()/2 + yut_board[i].getCellWidth()/4;
			int y_w = y_weight - yut_board[i].getCellHeight()/2 + yut_board[i].getCellHeight()/4;
			yut_board[i].setBounds(x_space+x_w*(i-25),y_space+y_w*(i-25), yut_board[i].getCellWidth()+5, yut_board[i].getCellHeight()+5);
			p.add(yut_board[i]);
		}
		
		
		// 대각선 28~29
		for(int i = 29; i >= 28; i--) {
			int x_w = x_weight - yut_board[i].getCellWidth()/2 + yut_board[i].getCellWidth()/4;
			int y_w = y_weight - yut_board[i].getCellHeight()/2 + yut_board[i].getCellHeight()/4;
			yut_board[i].setBounds(x_pos-x_w*(30-i),y_pos-y_w*(30-i), yut_board[i].getCellWidth()+5, yut_board[i].getCellHeight()+5);
			p.add(yut_board[i]);
		}
		
		return p;
	}
	
	public JPanel[] createYuts() {
		JPanel yut[] = new JPanel[4];
		for(int i = 0; i < 4; i++) {
			yut[i] = new LoadingImage("src/yut_images/yut_face.png").loaded_img;
		}
		return yut;
	}
	public YutStateButton[] createYutStateButton(YutBoardFrame f) {
		YutStateButton[] state = new YutStateButton[3];
		
		for(int i = 2; i >= 1; i--) {
			state[i] = new YutStateButton(f, "",40, 40, 50, new Color(0xBEB66D));
		}
		state[0] = new YutStateButton(f,"",60, 60, 60, new Color(0xBEB66D));
		return state;
	}
	
	public JPanel createYutPanel(JPanel[] yut, YutStateButton[] state) {
		JPanel yut_info_panel = new JPanel(new BorderLayout());
		yut_info_panel.setPreferredSize(new Dimension(440, 100));
		yut_info_panel.setBackground(Color.WHITE);
		
		// 윷 들
		JPanel yuts = new JPanel(new FlowLayout(FlowLayout.LEFT));
		yuts.setBackground(Color.WHITE);
		for(int i = 0; i < 4; i++) {
			yuts.add(yut[i]);
		}
		yuts.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 0));
		
		// 나온 윷의 상태 
		JPanel yut_states = new JPanel(new FlowLayout());
		yut_states.setBackground(Color.white);
		for(int i = 2; i >= 1; i--) {
			state[i].setPreferredSize(new Dimension(40, 40));
			yut_states.add(state[i]);
		}
		state[0].setPreferredSize(new Dimension(60, 60));
		yut_states.add(state[0]);
		yut_states.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 0));
//		state[0].setText("개");
//		state[0].setFont(new Font("고딕",Font.BOLD, 26));
		
		JPanel shut_yut_panel = new JPanel(new FlowLayout());
		RoundedButton shut_yut = new RoundedButton(100, 50, 20, Color.LIGHT_GRAY);
		shut_yut.setPreferredSize(new Dimension(100, 50));
		shut_yut.setText("윷 던지기");
		shut_yut_panel.setBorder(BorderFactory.createEmptyBorder(20,10,5,10));
		shut_yut_panel.setBackground(Color.white);
		
		shut_yut_panel.add(shut_yut);
		
		yut_info_panel.add(yuts, BorderLayout.WEST);
		yut_info_panel.add(yut_states, BorderLayout.CENTER);
		yut_info_panel.add(shut_yut_panel, BorderLayout.EAST);
		return yut_info_panel;
	}
	
	public PlayerButton[] createPlayerButton(YutBoardFrame f, Player p, Color c) {
		PlayerButton[] ps = new PlayerButton[4];
		for(int i =0;i  < 4; i++) {
			ps[i] = new PlayerButton(f, p, i+1, 15, 30,15, c);
		}
		return ps;
	}
	
	public JPanel createUserInfoPanel(PlayerButton[] pieces1, PlayerButton[] pieces2) {
		JPanel user_info_panel = new JPanel(new GridLayout(1,2));
		
		// 각 유저별 패널 
		JPanel user1_panel = new JPanel(new FlowLayout());
		JPanel user2_panel = new JPanel(new FlowLayout());
		
		user1_panel.setBackground(new Color(0xCADFFF));
		user2_panel.setBackground(new Color(0xFF8A8A));
		user1_panel.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
		user2_panel.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
		
		Color bg_c = new Color(0x494949);
		RoundRectDraw user1_nametag = new RoundRectDraw(70, 40, 15, bg_c, new GridLayout(1,1));
		RoundRectDraw user2_nametag = new RoundRectDraw(70, 40, 15, bg_c, new GridLayout(1,1));
		
		JLabel u1 = new JLabel("User1");
		u1.setHorizontalAlignment(JLabel.CENTER);
		u1.setForeground(Color.white);
		user1_nametag.add(u1);
		user1_nametag.setBackground(new Color(0xCADFFF));
		JLabel u2 = new JLabel("User2");
		u2.setHorizontalAlignment(JLabel.CENTER);
		u2.setForeground(Color.white);
		user2_nametag.add(u2);
		user2_nametag.setBackground(new Color(0xFF8A8A));
		
		
		JPanel pieces1_panel = new JPanel(new FlowLayout());
		JPanel pieces2_panel = new JPanel(new FlowLayout());
		pieces1_panel.setBackground(new Color(0xCADFFF));
		pieces2_panel.setBackground(new Color(0xFF8A8A));
		pieces1_panel.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
		pieces2_panel.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
		
		int piece_w = 15, piece_h = 30;
		for(int i =0;i  < 4; i++) {
			
			pieces1[i].setPreferredSize(new Dimension(piece_w, piece_h));
			pieces2[i].setPreferredSize(new Dimension(piece_w, piece_h));
			
			pieces1[i].setText(Integer.toString(i+1));
			pieces1[i].setForeground(Color.black);
			pieces2[i].setText(Integer.toString(i+1));
			pieces2[i].setForeground(Color.black);
			
			pieces1_panel.add(pieces1[i]);
			pieces2_panel.add(pieces2[i]);
		}
		
		user1_panel.add(pieces1_panel);
		user1_panel.add(user1_nametag);
		
		user2_panel.add(pieces2_panel);
		user2_panel.add(user2_nametag);
		
		user_info_panel.add(user1_panel);
		user_info_panel.add(user2_panel);
		return user_info_panel;
	}
	
}
