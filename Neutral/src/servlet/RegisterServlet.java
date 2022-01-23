package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		try {
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
			session.setAttribute("account", account);

			//DAOオブジェクト宣言
			AccountDAO ad = new AccountDAO();

			//登録メソッドを呼び出し
			ad.insert(account);

			//登録処理の実行
			Login login = new Login(email, pass);
			RegisterLogic rl = new RegisterLogic();
			boolean judge = rl.execute(login, account);
			
			//登録処理失敗の時にエラーメッセージを表示
			if(judge == false) {
				request.setAttribute("errorMsg", "登録失敗");
			}
			*/
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerOK.jsp");
			dispatcher.forward(request, response);

		}catch (IllegalStateException e) {
			error ="DB接続エラーの為、登録できませんでした。";

		}catch(Exception e){
			error ="予期せぬエラーが発生しました。<br>"+e;

		}finally{
			request.setAttribute("error", error);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
		}
	}
}

