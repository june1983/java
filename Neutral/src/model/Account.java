package model;

public class Account {
	private int userId;
	private String userName;
	private String adress;
	private String email;
	private String pass;
	private String tel;
	private String card;

	public Account(int userId, String userName, String adress, String email, String pass, String tel, String card) {
		this.userId = userId;
		this.userName = userName;
		this.adress = adress;
		this.email = email;
		this.pass = pass;
		this.tel = tel;
		this.card = card;
	}
	public int getUserId() {return userId;}
	public String getUserName() {return userName;}
	public String getAdress() {return adress;}
	public String getEmail() {return email;}
	public String getPass() {return pass;}
	public String getTel() {return tel;}
	public String getCard() {return card;}
}

