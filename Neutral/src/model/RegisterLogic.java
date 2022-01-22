package model;

import dao.AccountDAO;

public class RegisterLogic {
	public boolean execute(Login login,Account account) {
		AccountDAO dao = new AccountDAO();
		boolean a = dao.findByLogin(login);
		if(a == true) {
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