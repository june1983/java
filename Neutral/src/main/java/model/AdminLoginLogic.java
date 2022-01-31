package model;

import dao.AdminUserDAO;

public class AdminLoginLogic {
	public boolean execute(Login login) {
		AdminUserDAO dao = new AdminUserDAO();
		AdminUser account = dao.findByLogin(login);
		return account != null;
	}
}
