package model;

public class Account {
	private int userId;
	private String userName;
	private String adress;
	private String email;
	private String pass;
	private String tel;
	private String card;
	
	// 初期設定（コンストラクタ）
	public Account() {
		this.userId = 0;
		this.userName = null;
		this.adress = null;
		this.email = null;
		this.pass = null;
		this.tel = null;
		this.card = null;
	}

	public Account(int userId, String userName, String adress, String email, String pass, String tel, String card) {
		this.userId = userId;
		this.userName = userName;
		this.adress = adress;
		this.email = email;
		this.pass = pass;
		this.tel = tel;
		this.card = card;
	}

	//ユーザーIDを取得する
	public int getUserId(){
		return userId;
	}
	//ユーザーIDを設定する
	public void setUserId(int userId) {
		this.userId = userId;
	}
	//ユーザーの名前を取得する
	public String getUserName() {
		return userName;
	}
	//ユーザーの名前を設定する
	public void setUserName(String userName) {
		this.userName = userName;
	}
	//ユーザーの住所を取得する
	public String getAdress() {
		return adress;
	}
	//ユーザーの住所を設定する
	public void setAdress(String adress) {
		this.adress = adress;
	}
	//ユーザーのメールアドレスを取得する
	public String getEmail() {
		return email;
	}
	//ユーザーのメールアドレスを設定する
	public void setEmail(String email) {
		this.email = email;
	}
	//ユーザーのパスワードを取得する
	public String getPass() {
		return pass;
	}
	//ユーザーのパスワードを設定する
	public void setPass(String pass) {
		this.pass = pass;
	}
	//ユーザーの電話番号を取得する
	public String getTel() {
		return tel;
	}
	//ユーザーの電話番号を設定する
	public void setTel(String tel) {
		this.tel = tel;
	}
	//ユーザーのカード番号を取得する
	public String getCard() {
		return card;
	}
	//ユーザーのカード番号を設定する
	public void setCard(String card) {
		this.card = card;
	}
}