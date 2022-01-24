package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dao.SkuDAO;
import model.Account;
import model.Login;
import model.LoginLogic;
import model.SKU;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションスコープからAccountデータを取得
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("Account");
		
		// Accountデータが空でない場合（ログイン時）
		if(account != null) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
			dispatcher.forward(request,  response);
		// Accountデータが空の場合（非ログイン時）
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/adminLogin.jsp");
			dispatcher.forward(request,  response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		//ログイン処理の実行
		Login login = new Login(email, pass);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);

		//アカウント情報の取得
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByLogin(login);

		//ログイン処理の成否によって処理を分岐
		if(result) {//ログイン成功時
			//セッションスコープにメールアドレスとアカウント情報を保存
			HttpSession session = request.getSession();
			session.setAttribute("Account", account);
			
			// データベースアクセス用オブジェクトの生成
			SkuDAO skuDao = new SkuDAO();

			// 商品データを全件取得する命令を呼び出し、戻り値を取得する
			ArrayList<SKU> skuList = skuDao.selectAll();

			// 商品リストをセッションスコープに格納
			session.setAttribute("skuList", skuList);

			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
			dispatcher.forward(request, response);
			
		} else { //ログイン失敗時
			//フォワード
			request.setAttribute("message", "メールアドレスまたはパスワードが違います");
			request.getRequestDispatcher("/WEB-INF/jsp/adminLogin.jsp").forward(request, response);
			return;
		}
	}

}
