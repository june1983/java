package model;

public class Account {
	private int userId;
	private String userName;
	private String email;
	private String pass;
	private String adress;
	private String tel;
	private String card;

	public Account(int userId, String userName, String email, String pass, String adress, String tel, String card) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.pass = pass;
		this.adress = adress;
		this.tel = tel;
		this.card = card;
	}
/*	public Account(String userName, String email, String pass, String adress, String tel, String card) {
		this.userName = userName;
		this.email = email;
		this.pass = pass;
		this.adress = adress;
		this.tel = tel;
		this.card = card;
	}*/
	public int getUserId() { return userId; }
	public String getUserName() { return userName; }
	public String getEmail() { return email; }
	public String getPass() { return pass; }
	public String getAdress() { return adress; }
	public String getTel() { return tel; }
	public String getCard() { return card; }
}
