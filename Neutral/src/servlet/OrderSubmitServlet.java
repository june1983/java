package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import dao.OrderDAO;
import model.Account;
import model.Cart;
import model.Order;


@WebServlet("/OrderSubmitServlet")
public class OrderSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1: カート情報を注文テーブルに移動

			// 1-1: セッションスコープからAccountデータを取得
			HttpSession session = request.getSession();
			Account account = (Account) session.getAttribute("Account");

			// 1-2: AccountデータからUSER_IDを取得し、カートテーブルから全カート情報を取得
			int userId =account.getUserId();
			CartDAO dao = new CartDAO();
			ArrayList<Cart> cartList = dao.selectByUser_Id(userId);

		// 2: 注文データを注文テーブルに反映

			// 2-1: 注文データを格納するエンティティを生成
			Order order = new Order();

			// 2-2: 注文データに登録する現在日時を取得
	        Date date= new Date();
	        long time = date.getTime();
	        Timestamp ts = new Timestamp(time);
	        System.out.println("現在時刻： "+ts);

			// 注文データ格納用のArrayListを生成
			ArrayList<Order> orderList = new ArrayList<Order>();

			// 2-3: 注文データを注文エンティティのArrayListに登録
	        for (Cart cart : cartList) {
	        	//顧客ID
				order.setUserId(cart.getUserId());
				//商品ID
				order.setProductId(cart.getProductId());
				//商品名
				order.setOrderProduct(cart.getOrderProduct());
				//サイズ
				order.setOrderSize(cart.getOrderSize());
				//個数
				order.setOrderNumber(cart.getOrderNumber());
				//単価
				order.setOrderPrice(cart.getOrderPrice());
				//小計
				order.setSubtotal();
				//日付
				order.setOrderDate(ts);

				orderList.add(order);
	        }
	        System.out.println(orderList);

			// OrderDAOインスタンスを生成し、注文テーブルに情報を追加
			OrderDAO orderDao = new OrderDAO();
			orderDao.insert(orderList);


		// 3: 最後にカートテーブルの情報を削除
//			CartDAO cartDao = new CartDAO();
//			cartDao.delete(cartList);




		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/orderOK.jsp");
		dispatcher.forward(request,  response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
