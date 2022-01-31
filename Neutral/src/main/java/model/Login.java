package model;

public class Login {
	private String email;
	private String pass;
	public Login(String email, String pass) {
		this.email = email;
		this.pass = pass;
	}
	public String getEmail() { return email; }
	public String getPass() { return pass; }
}
