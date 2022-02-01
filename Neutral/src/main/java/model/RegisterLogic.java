package model;

import dao.AccountDAO;

public class RegisterLogic {
	public boolean execute(Account account) {
		AccountDAO ad = new AccountDAO();
		boolean a = ad.select(account);
		if(a == true) {
			ad.insert(account);
			return true;
		}else {
			return false;
		}
	}
}
