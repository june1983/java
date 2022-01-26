package model;
import java.util.ArrayList;

public class User {
	public int number;
	public ArrayList<String> user = new ArrayList<String>();

	public User(){
	}

	public void setUser(String name) {
		this.user.add(name);
		
	}

}
