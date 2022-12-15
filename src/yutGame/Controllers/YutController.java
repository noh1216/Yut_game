package yutGame.Controllers;

import java.util.*;

public class YutController {
	private boolean[] yuts;
	
	
	public YutController() {
		yuts = new boolean[4];
	}
	
	public void rollYuts() {
		Random random = new Random();  //java.util.*;
        for (int i = 0; i < 4; i++) 
            yuts[i] = random.nextBoolean();
	}
	
	// 나온 윷의 상태 계산 
	public int calYutsState() {
		int t_count=4;
		for(int i=0;i<4;i++) {
			if(yuts[i])
				t_count--;
		}
		// true가 앞
		if(t_count == 0) return 5; // 모 
		else if(t_count == 1) {
			if(yuts[3])
				return 1; //도 
			else
				return -1; //뒷도
		}
		else if(t_count == 2) return 2; // 개 
		else if(t_count == 3) return 3; // 걸
		else if(t_count == 4) return 4; // 윷 
		else return -2;
	}
	
	public String getStrState() {
		int cal = calYutsState();
		if (cal == 1) return "도";
		else if(cal == 2) return "개";
		else if(cal == 3) return "걸";
		else if(cal == 4) return "윷";
		else if(cal == 5) return "모";
		else if(cal == -1) return "빽도";
		return "";
	}
	
	public boolean[] getYuts() {
		return yuts;
	}
}
