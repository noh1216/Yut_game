package yutGame.Controllers;

public class Player {
	
	private static boolean player1_turn = false;
	
	public Player() {
		player1_turn = true;
	}
	
	public void changeTurn() {
		if(player1_turn) player1_turn = false;
		else player1_turn = true;
	}
	
	public boolean player1Turn() {
		return player1_turn;
	}
	
}
