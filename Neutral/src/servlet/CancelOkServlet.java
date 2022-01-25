package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;


@WebServlet("/CancelOkServlet")
public class CancelOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		try {
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
			session.setAttribute("registerServlet", account);
			
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
			dispatcher.forward(request, response);

		}catch (IllegalStateException e) {
			error ="DB接続エラーの為、削除できませんでした。";

		}catch(Exception e){
			error ="予期せぬエラーが発生しました。<br>"+e;

		}finally{
			request.setAttribute("error", error);
			request.getRequestDispatcher("/WEB-INF/jsp/accountEdit.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
