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
import model.Cart;
import model.Product;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// セッションスコープからAccountデータを取得
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("Account");
		
		//　Accountデータが空でない場合（ログイン時）
		if(account != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/orderLogin.jsp");
			dispatcher.forward(request,  response);
		//　Accountデータが空の場合（非ログイン時）	
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/orderLogout.jsp");
			dispatcher.forward(request,  response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメーターを取得（注文個数）
		request.setCharacterEncoding("UTF-8");
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
		
		// セッションスコープからAccountデータを取得
		Account account = (Account) session.getAttribute("Account");
		
		//　Accountデータが空でない場合（ログイン時）
		if(account != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/orderLogin.jsp");
			dispatcher.forward(request,  response);
		
		//　Accountデータが空の場合（非ログイン時）	
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/orderLogout.jsp");
			dispatcher.forward(request,  response);
		}

	}

}
