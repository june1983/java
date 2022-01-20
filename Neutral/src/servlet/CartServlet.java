package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Login;
import model.Product;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Login login = (Login) session.getAttribute("loginUser");
		if(login != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/orderLogin.jsp");
			dispatcher.forward(request,  response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/orderLogout.jsp");
			dispatcher.forward(request,  response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメーターを取得（注文個数）
		int orderNumber = Integer.parseInt(request.getParameter("orderNumber"));

		//セッションスコープから商品データを取得
		HttpSession session = request.getSession();
		Product product = (Product) session.getAttribute("Product");

		String productId = product.getProductId();
		String productName = product.getProductName();
		int orderPrice = product.getPrice();

		// 商品データ格納用のCartオブジェクトを生成
		Cart cart = new Cart();

		cart.setUserId(0);
		cart.setProductId(productId);
		cart.setOrderProduct(productName);
		cart.setOrderPrice(orderPrice);
		cart.setOrderSize("");
		cart.setOrderNumber(orderNumber);
		cart.setSubtotal();

		//セッションスコープにCartインスタンスを保存
		session.setAttribute("cart", cart);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/orderLogout.jsp");
		dispatcher.forward(request,  response);


		/*
		HttpSession session = request.getSession();
		Login login = (Login) session.getAttribute("loginUser");

		if(login != null) {
			int userId = login.getUserId();
			String productId = request.getParameter("productId");
			String orderProduct = request.getParameter("orderProduct");
			int orderPrice = Integer.parseInt(request.getParameter("orderPrice"));
			String orderSize = request.getParameter("orderSize");
			int orderNumber = Integer.parseInt(request.getParameter("orderNumber"));

			//カートインスタンスを生成し、フィールドを入力
			Cart cart = new Cart();
			cart.setUserId(userId);
			cart.setProductId(productId);
			cart.setOrderProduct(orderProduct);
			cart.setOrderPrice(orderPrice);
			cart.setOrderSize(orderSize);
			cart.setOrderNumber(orderNumber);
			cart.setSubtotal();


			//CartDAOインスタンスを生成し、Cartテーブルに情報を追加
			CartDAO dao = new CartDAO();
			dao.insert(cart);

			//セッションスコープなどに保存する？


			//ログイン時のカート確認画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/OrderLogin.jsp");
			dispatcher.forward(request,  response);


		//ログインしていない場合の処理内容を記載
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/OrderLogout.jsp");
			dispatcher.forward(request,  response);
		}
	*/
	}

}
