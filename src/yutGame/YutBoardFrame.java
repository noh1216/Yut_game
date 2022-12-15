package yutGame;

import java.awt.*;

import javax.swing.*;

import yutGame.Buttons.PlayerButton;
import yutGame.Controllers.GameData;
import yutGame.Controllers.PlayerController;


public class YutBoardFrame extends JFrame{
	
	private int selected_piece,on_position, moving; // 현재 선택된 플레이어의 피스 
	private GameData game_data; // 게임 정보가 저장되어 있는 객체 
	
	public YutBoardFrame() {
		game_data = new GameData();
		moving =1;
		
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
		CreateGUI gui = new CreateGUI(this);
		game_data.yut_board = gui.createYutBoard();
		game_data.player1_piece_board = gui.player1PieceBoard();
		game_data.player2_piece_board = gui.player2PieceBoard();
		JPanel board = gui.createBoard(440, 400,game_data.yut_board, game_data.player1_piece_board, game_data.player2_piece_board);
        
		// 하단 구성(윷놀이 판, 유저 정보)
		JPanel bottom_panel = new JPanel(new GridLayout(2,1));
		
		// 윷정보 패널 구성
		game_data.yuts = gui.createYuts();
		game_data.yut_states = gui.createYutStateButton(this);
		JPanel yut_info_panel =  gui.createYutPanel(game_data.yuts, game_data.yut_states);
		
		// 유저정보 패널 구성
		// - 이름 태그 받아오기
		game_data.nametag1 = gui.nametag("User1");
		game_data.nametag2 = gui.nametag("User2");
		game_data.player1_nametag = gui.drawNameTag(game_data.nametag1, new Color(0xCADFFF));
		game_data.player2_nametag = gui.drawNameTag(game_data.nametag2, new Color(0xFF8A8A));
		
		// - 플레이어의 말(Piece) 버튼 불러오기 
		PlayerButton[] player_btn1= gui.createPlayerButton(this, game_data.player, new Color(0x5A6FDE));
		PlayerButton[] player_btn2 = gui.createPlayerButton(this, game_data.player, new Color(0xE14343));
		JPanel user_info_panel = gui.createUserInfoPanel(player_btn1, player_btn2, game_data.player1_nametag,game_data.player2_nametag);
		
		game_data.player = new PlayerController(player_btn1, player_btn2, game_data);
		
				
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
	
	// 윷을 굴리는 버튼이 눌렸을 때 
	public void rolledYut(boolean[] yuts, String state) {
		if(game_data.yut_state_cnt <=2 && game_data.player.getRemainingTurns() > 0) {	
			// 윷 프레임 업데이트 
			for(int i =0; i < yuts.length; i++) {	
				if(yuts[i] == true) {
					game_data.yuts[i*2].setVisible(true);
					game_data.yuts[i*2+1].setVisible(false);
				}
				else {
					game_data.yuts[i*2].setVisible(false);
					game_data.yuts[i*2+1].setVisible(true);
				}
			}
			
			// 윷 상태 버튼 업데이트 
			int n = game_data.yut_state_cnt;
			while(n >0) {
				game_data.yut_states[n].setText(game_data.yut_states[n-1].getText());
				n-=1;
			}
			game_data.yut_states[0].setText(state);
			game_data.yut_state_cnt++;
			if(!(state.equals("모") || state.equals("윷")))
				game_data.player.setRemainingTurns(-1);
		}
			
	}
	
	/**
	 * 플레이어의 말(picec)가 선택되었을 때 yut_state 의 상태 정보를 활성화 
	 * 선택된 플레이어 말의 번호를 마킹  
	 * @param num
	 */
	public void selectedPlayer(int num) {
		game_data.yut_board[moving].setText("");
		selected_piece = num;
		for(int i = 0; i < game_data.yut_state_cnt; i++) {
			game_data.yut_states[i].setEnabled(true);
		}
	}
	
	public void drawPiece(int cell_num)	{
		PlayerButton[] pieces = game_data.player.getPieces();
		game_data.yut_board[pieces[selected_piece].getPosition()].setText("");
		pieces[selected_piece].setEnabled(false);
		if(!game_data.player.player1_turn()) {
			game_data.player1_piece_board[pieces[selected_piece].getPosition()].setVisible(false);
			pieces[selected_piece].setPosition(cell_num);
			game_data.player1_piece_board[pieces[selected_piece].getPosition()].setVisible(true);
			
		}
		else {
			game_data.player2_piece_board[pieces[selected_piece].getPosition()].setVisible(false);
			pieces[selected_piece].setPosition(cell_num);
			game_data.player2_piece_board[pieces[selected_piece].getPosition()].setVisible(true);
		}
		
		// 윷, 보드버튼 초기화 부분
		game_data.yut_states[on_position-1].setText("");
		game_data.yut_states[on_position-1].setEnabled(false);
		for(int i = game_data.yut_state_cnt; i> on_position; i--) {
			game_data.yut_states[i-1] = game_data.yut_states[i];
			game_data.yut_states[i].setText("");
			game_data.yut_states[i].setEnabled(false);
		}
		game_data.yut_state_cnt--;
		if(game_data.yut_state_cnt <= 0) {
			game_data.player.updatePlayerTurn();
		}
		
	}
	
	public void onBoardCell(int on_pos, int yut_pos) {
		PlayerButton[] pieces = game_data.player.getPieces();
		on_position = yut_pos;
		
		int now_pos = pieces[selected_piece].getPosition();
		int move = pieces[selected_piece].getPosition() + on_pos;
		moving = move;
		if((now_pos>= 16 && now_pos <= 19 && move > 20) || move > 29) { // 게임 종료 조건
			game_data.yut_board[0].setEnabled(true);
			game_data.yut_board[0].setText("Goal");
		}
		else {
			if(now_pos==5) {
				game_data.yut_board[move].setEnabled(true);
				game_data.yut_board[move].setText("O");
			}
			else {				
				game_data.yut_board[move].setEnabled(true);
				game_data.yut_board[move].setText("O");
			}
		}
		
	}
	
	public static void main(String[] args) {
		new YutBoardFrame();
	}

}
