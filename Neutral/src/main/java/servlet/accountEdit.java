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


@WebServlet("/accountEdit")
public class accountEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountEdit.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			//リクエストパラメータの取得
			request.setCharacterEncoding("UTF-8");
			String user_Name = request.getParameter("user_Name");
			String adress = request.getParameter("adress");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String tel = request.getParameter("tel");
			String card = request.getParameter("card");

			//古いアカウント情報をセッションスコープから取得
			HttpSession session = request.getSession();
			Account past_user_data = (Account) session.getAttribute("Account");
			int user_Id = past_user_data.getUserId();

			//もしパラメータがnullだったら
			if(user_Name == null) {
				user_Name = past_user_data.getUserName();
			}
			if(adress == null) {
				adress = past_user_data.getAdress();
			}
			if(email == null) {
				email = past_user_data.getEmail();
			}
			if(pass == null) {
				pass = past_user_data.getPass();
			}
			if(tel == null) {
				tel = past_user_data.getTel();
			}
			if(card == null) {
				card = past_user_data.getCard();
			}

			//新しいアカウントに登録するユーザーの情報を設定
			Account account= new Account(user_Id, user_Name, adress, email, pass, tel, card);
			
			// SkuDAOインスタンスを生成し、編集済みのアカウント情報をDBに反映
			AccountDAO dao = new AccountDAO();
			
			dao.update(account);

			//セッションスコープに登録ユーザーを保存
			session.setAttribute("Account", account);

			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/account.jsp");
			dispatcher.forward(request, response);

	}
}
