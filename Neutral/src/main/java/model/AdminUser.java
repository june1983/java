package model;

public class AdminUser {
	private int adminId;
	private String Email;
	private String Pass;


	public AdminUser(int adminId, String Email, String Pass) {
		this.adminId = adminId;
		this.Email = Email;
		this.Pass = Pass;
	}
	public int getAdminId() {return adminId;}
	public String getEmail() {return Email;}
	public String getPass() {return Pass;}

}

