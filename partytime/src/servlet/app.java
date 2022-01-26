package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.shuffledUser;

@WebServlet("/App")
public class app extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// セッションスコープに保存された登録ユーザ
	HttpSession session = request.getSession();
	User u = (User) session.getAttribute("User");

    // フォワード先
    String forwardPath = null;

    // サーブレットクラスの動作を決定する「action」の値を
    // リクエストパラメータから取得
    String action = request.getParameter("action");

    // 「登録の開始」をリクエストされたときの処理
    if (action == null && u == null) {
    	// フォワード先を設定
    	forwardPath = "/WEB-INF/jsp/index.jsp";
    }

    //セッションスコープに値が入ったママの状態でトップ画面に遷移してしまった場合
    else if (action == null && u != null) {
  	  	// セッションスコープをリセット
  	  	session.removeAttribute("User");

  	  	// 登録後のフォワード先を設定
  	  	forwardPath = "/WEB-INF/jsp/index.jsp";

    }


    // 登録確認画面から「組み合わせを見る」をリクエストされたときの処理
    else if (action.equals("done")) {
      // セッションスコープに保存された登録ユーザ
    	HttpSession session1 = request.getSession();
    	User user = (User) session1.getAttribute("User");

    	//ランダムに生成されたペアリストのインスタンスを生成
    	shuffledUser su = new shuffledUser(user);

    	//ペアリストのインスタンスをセッションスコープに保存
  	  	HttpSession session2 = request.getSession();
  	  	session2.setAttribute("shuffledUser", su);


  	  	// 不要となったセッションスコープ内のインスタンスを削除
  	  	session.removeAttribute("User");

  	  	// 登録後のフォワード先を設定
  	  	forwardPath = "/WEB-INF/jsp/result.jsp";
    }

    // 登録確認画面から「入力をやり直す」をリクエストされたときの処理
    else if (action.equals("reDo")) {
        // セッションスコープに保存された登録ユーザ
    	HttpSession session1 = request.getSession();

  	  	// セッションスコープ内のインスタンスをリセット・
  	  	session1.removeAttribute("User");

  	  	// 登録後のフォワード先を設定
  	  	forwardPath = "/WEB-INF/jsp/register.jsp";
    }

    // 発表前のイベント処理
    else if (action.equals("count")) {


  	  	// フォワード先を設定
  	  	forwardPath = "/WEB-INF/jsp/count.jsp";
    }

	    // 設定されたフォワード先にフォワード
	    RequestDispatcher dispatcher =
	        request.getRequestDispatcher(forwardPath);
	    dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// セッションスコープからユーザーインスタンスを取得
		HttpSession session = request.getSession();
	    User u = (User) session.getAttribute("User");

		if (u == null) {
			//リクエストパラメーターを取得
			request.setCharacterEncoding("UTF-8");
			String number = request.getParameter("number");

			//人数を文字列から数値に変換して、ユーザーインスタンスに渡す
			int num = Integer.parseInt(number);
			User user = new User();
			user.number = num;

			//セッションスコープにユーザーの人数を保存
			HttpSession session1 = request.getSession();
			session1.setAttribute("User",user);

	        //フォワード
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
	    	dispatcher.forward(request, response);
		}

		if (u != null) {
			//リクエストパラメーターを取得
			request.setCharacterEncoding("UTF-8");

			//ユーザー名を格納する配列を用意
			User user = new User();

			//人数分のパラメーターから値を取得し、ユーザーインスタンスに保存
			int num = u.number;
			for(int i=1; i <= num; i++) {
				String si = Integer.valueOf(i).toString();
				user.setUser(request.getParameter("name" + si));
			}

	        //ユーザー情報のインスタンスをアプリケーションスコープに保存
			HttpSession session2 = request.getSession();
			session2.setAttribute("User",user);

	        //フォワード
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/confirm.jsp");
	    	dispatcher.forward(request, response);

		}
	}
}