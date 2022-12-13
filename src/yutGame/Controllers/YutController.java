package yutGame.Controllers;

import java.util.*;

public class YutController {
	private boolean[] yuts;
	private int[] yutStates;
	private int yutStateCount;
	
	public YutController() {
		yuts = new boolean[4];
		yutStates = new int[3];
	}
	
	public void rollYuts() {
		Random random = new Random();  //java.util.*;
        for (int i = 0; i < 4; i++) 
            yuts[i] = random.nextBoolean();
	}
	
	public void calYutsState() {
		int t_count=0;
		for(int i=0;i<4;i++) {
			if(yuts[i])
				t_count++;
		}
		// true가 앞
		if(t_count == 0) yutStates[yutStateCount] = 5; // 모 
		else if(t_count == 1) {
			if(yuts[3] != true)
				yutStates[yutStateCount] = 1; //도 
			else
				yutStates[yutStateCount] = -1; //뒷도
		}
		else if(t_count == 2) yutStates[yutStateCount] = 2; // 개 
		else if(t_count == 3) yutStates[yutStateCount] = 3; // 걸
		else if(t_count == 4) yutStates[yutStateCount] = 4; // 윷 
		else;
		
		yutStateCount++;
	}
	
	public int[] getYutStates() {
		for(int i=0;i<yutStateCount;i++) {
			if(yutStates[i] == 0 && i < 2) 
				yutStates[i] = yutStates[i+1];
		}
		
		return yutStates;
	}
	
	public boolean[] getYuts() {
		return yuts;
	}
	
	public int getYutsCount() {
		return yutStateCount;
	}
}
