package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/AccountEditServlet")
public class AccountEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountEdit.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		/*
		try {
		*/
		
		/*
			//リクエストパラメータの取得
			request.setCharacterEncoding("UTF-8");
			int userId = Integer.parseInt(request.getParameter("userId"));
			String userName = request.getParameter("userName");
			String adress = request.getParameter("adress");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String tel = request.getParameter("tel");
			String card = request.getParameter("card");

			//登録するユーザーの情報を設定
			Account account = new Account(userId, userName, adress, email, pass, tel, card);

			//セッションスコープに登録ユーザーを保存
			HttpSession session = request.getSession();
			session.setAttribute("Account", account);

			//DAOオブジェクト宣言
			AccountDAO ad = new AccountDAO();

			//更新メソッドを呼び出し
			ad.insert(account);

			//更新処理の実行
			Login login = new Login(email, pass);
			AccountEditLogic ael = new AccountEditLogic();
			boolean judge = ael.execute(login);

			//更新処理失敗の時にエラーメッセージを表示
			if(judge == false) {
				request.setAttribute("errorMsg", "更新失敗");
			}
		*/
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/account.jsp");
			dispatcher.forward(request, response);
		/*
		}catch (IllegalStateException e) {
			error ="DB接続エラーの為、更新できませんでした。";

		}catch(Exception e){
			error ="予期せぬエラーが発生しました。<br>"+e;

		}finally{
			request.setAttribute("error", error);
			request.getRequestDispatcher("/WEB-INF/jsp/accountEdit.jsp").forward(request, response);
		}
		*/
	}
}
