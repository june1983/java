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

import dao.CartDAO;
import model.Account;
import model.Cart;


@WebServlet("/CartDeleteServlet")
public class CartDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// URLパラメーターから削除するカートIDを取得
		int cartId = Integer.parseInt(request.getParameter("id"));

		// セッションスコープからアカウントデータを取得
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("Account");
		int userId = account.getUserId();

		// CartDAOインスタンスを生成し、Cartテーブルから
		CartDAO cartDao = new CartDAO();
		cartDao.deleteByCartId(cartId);

		// 特定のユーザーに紐づくカートテーブルのデータを全件取得する命令を呼び出し、戻り値を取得する
		ArrayList<Cart> cartList = cartDao.selectByUserId(userId);

		// カート情報をセッションスコープに格納
		session.setAttribute("cartList", cartList);

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/orderLogin.jsp");
		dispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
