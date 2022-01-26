package model;

import java.util.ArrayList;
import java.util.Collections;

public class shuffledUser {
	public ArrayList<String> giverFix = new ArrayList<String>();
	public ArrayList<String> takerFix = new ArrayList<String>();
	
	public shuffledUser(User u) {
//		//各配列の要素数の範囲内で乱数を生成
//		int r1 = new java.util.Random().nextInt(g.giver.size());
//		int r2 = new java.util.Random().nextInt(t.taker.size());
        // Shuffle the list
        Collections.shuffle(u.user);
    	
		int num = u.user.size();
		for (int i=0; i+1< num; i++) {
				this.giverFix.add(u.user.get(i));
				this.takerFix.add(u.user.get(i+1));
			}
			this.giverFix.add(u.user.get(num-1));
			this.takerFix.add(u.user.get(0));
		
	}
	

}
