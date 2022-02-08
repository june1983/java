package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import model.Account;


@WebServlet("/cancelOk")
public class cancelOk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションスコープからアカウント情報を取得
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("Account");

		// USER_IDを取得して変数に代入
		int userId = account.getUserId();

		// データベースアクセス用オブジェクトの生成
		AccountDAO accountDao = new AccountDAO();

		// 指定したuserIdの顧客データを削除する命令を呼び出す
		accountDao.delete(userId);
		
		// セッションスコープからアカウント情報を削除
		session.removeAttribute("Account");

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
