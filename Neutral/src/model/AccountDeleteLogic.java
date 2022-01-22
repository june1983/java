package model;

import dao.AccountDAO;

public class AccountDeleteLogic {
	public boolean execute(Account account) {
		AccountDAO dao = new AccountDAO();
		boolean a = dao.delete(account);
			if(a == true) {
				return true;
			}else {
				return false;
			}
	}
}
