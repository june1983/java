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
import model.AccountEditLogic;
import model.Login;


/**
 * Servlet implementation class AccountEditServlet
 */
@WebServlet("/AccountEditServlet")
public class AccountEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountEdit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";

		try {

			//リクエストパラメータの取得
			request.setCharacterEncoding("UTF-8");
			int user_Id = Integer.parseInt(request.getParameter("user_Id"));
			String user_Name = request.getParameter("user_Name");
			String adress = request.getParameter("adress");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String tel = request.getParameter("tel");
			String card = request.getParameter("card");

			//古いアカウント情報をセッションスコープから取得
			HttpSession session = request.getSession();
			Account past_user_data = (Account) session.getAttribute("Account");

			//もしパラメータがnullだったら
			if(user_Name.contentEquals("")) {
				user_Name = past_user_data.getUserName();
			}
			if(adress.contentEquals("")) {
				adress = past_user_data.getAdress();
			}
			if(email.contentEquals("")) {
				email = past_user_data.getEmail();
			}
			if(pass.contentEquals("")) {
				pass = past_user_data.getPass();
			}
			if(tel.contentEquals("")) {
				tel = past_user_data.getTel();
			}
			if(card.contentEquals("")) {
				card = past_user_data.getCard();
			}

			//新しいアカウントに登録するユーザーの情報を設定
			Account account= new Account(user_Id, user_Name, adress, email, pass, tel, card);

			//セッションスコープに登録ユーザーを保存
			session.setAttribute("Account", account);

			//更新処理の実行
			Login login = new Login(email, pass);
			AccountEditLogic ael = new AccountEditLogic();
			boolean judge = ael.execute(login);

			//更新処理失敗の時にエラーメッセージを表示
			if(judge == false) {
				request.setAttribute("errorMsg", "更新失敗");
			}

			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/account.jsp");
			dispatcher.forward(request, response);

		}catch (IllegalStateException e) {
			error ="DB接続エラーの為、更新できませんでした。";

		}catch(Exception e){
			error ="予期せぬエラーが発生しました。<br>"+e;

		}finally{
			request.setAttribute("error", error);
			request.getRequestDispatcher("/WEB-INF/jsp/accountEdit.jsp").forward(request, response);
		}

	}
}
