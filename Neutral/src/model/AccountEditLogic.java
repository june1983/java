package model;

import dao.AccountDAO;

public class AccountEditLogic {
	public boolean execute(Login login) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByLogin(login);
		
		if(account != null) {
			boolean b = dao.insert(account);
			if(b == true) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}
