package yutGame.Controllers;

import yutGame.Buttons.PlayerButton;
import yutGame.drawTools.RoundRectDraw;

public class PlayerController {
	
	private static boolean player1_turn = false; // 플레이어 턴 확인 
	private PlayerButton[] player_btn1, player_btn2; // 플레이어의 말 버튼 
	private GameData game_data; // 게임 데이터 
	private int remaining_turns; // 플레이어 한 명의 남은 턴 (기본 1)
	
	public PlayerController(PlayerButton[] pb1, PlayerButton[] pb2, GameData g) {
		player_btn1 = pb1;
		player_btn2 = pb2;
		game_data = g;
		player1_turn = true;
		updatePlayerTurn();
	}
	
	// 플레이어 턴 리턴 
	public boolean player1_turn() {
		return player1_turn;
	}
	
	// 현재 턴 인 플레이어의 말을 리턴해준다 
	public PlayerButton[] getPieces() {
		if(player1_turn) {
			return player_btn1;
		}
		else {
			return player_btn2;
		}
	}
	
	// 플레이어의 턴을 끝내고 상대방에게 턴을 넘긴다.
	public void updatePlayerTurn() {
		if(player1_turn) {
			game_data.nametag1.setText("> User1");
			game_data.nametag2.setText("User2");
			for(int i = 0; i < 4; i++) {
				player_btn1[i].setEnabled(true);
				player_btn2[i].setEnabled(false);
			}
		}
		else{
			game_data.nametag2.setText("> User2");
			game_data.nametag1.setText("User1");
			for(int i = 0; i < 4; i++) {
				player_btn1[i].setEnabled(false);
				player_btn2[i].setEnabled(true);
			}
		}
		player1_turn = !player1_turn;
		remaining_turns = 1;
	}
	
	// 남은 턴을 보여준다.
	public int getRemainingTurns() {
		return remaining_turns;
	}
	// 남은 턴을 수정한다. 
	public void setRemainingTurns(int n) {
		remaining_turns+=n;
	}
			
			
}
