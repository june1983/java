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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
//		int userId = Integer.parseInt(request.getParameter("userId"));
		String userName = request.getParameter("userName");
		String adress = request.getParameter("adress");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String tel = request.getParameter("tel");
		String card = request.getParameter("card");

		//アカウントデータ格納用のAccountオブジェクトを生成
		Account account = new Account();
//		account.setUserId(userId);
		account.setUserName(userName);
		account.setAdress(adress);
		account.setEmail(email);
		account.setPass(pass);
		account.setTel(tel);
		account.setCard(card);

		//セッションスコープにAccountオブジェクトを保存
		HttpSession session = request.getSession();
		session.setAttribute("Account", account);

//		//セッションスコープからAccountオブジェクトを取得
//		Account a = (Account) session.getAttribute("Account");

		//DAOオブジェクト宣言
		AccountDAO ad = new AccountDAO();

		//登録メソッドを呼び出し
		ad.insert(account);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerOK.jsp");
		dispatcher.forward(request, response);
	}
}

