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
import dao.SkuDAO;
import model.Account;
import model.Cart;
import model.Order;
import model.SKU;


@WebServlet("/OrderSubmitServlet")
public class OrderSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
		dispatcher.forward(request,  response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションスコープからカート情報を取得
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");       
	
		// もし、チェックボックスで取得したカートIDとカートリストのカートIDが等しいならば
		// カート情報を注文テーブルに移動し、同時に在庫テーブルの情報を更新
		
		// 注文データ格納用のArrayListを生成
		ArrayList<Order> orderList = new ArrayList<Order>();
		
        for (Cart cart : cartList) {
        	// カートIDを文字列に変換
        	String cartId = String.valueOf(cart.getCartId());
        	
			// リクエストパラメーターを取得
        	//確定した注文個数を取得
			request.setCharacterEncoding("UTF-8");
			int orderNumber = Integer.parseInt(request.getParameter("orderNumber"+ cartId));
			
			// 確定した注文個数を再度設定
			cart.setOrderNumber(orderNumber);
			System.out.println(cart.getProductId() + "の注文個数は" + orderNumber + "個です");
        
			// チェックが入っている商品のカートIDを取得
        	String check = request.getParameter("checked" + cartId);
        	System.out.println("あなたが選択した商品はカートID：" + check);
			
	        	if(cartId.equals(check) ) {
	    			// 注文データに登録する現在日時を取得
	    	        Date date= new Date();
	    	        long time = date.getTime();
	    	        Timestamp ts = new Timestamp(time);
	    	        System.out.println("現在時刻： "+ts);
	    	        
	    			// カート情報を注文エンティティのArrayListに登録
	    			Order order = new Order();
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
	    }	
        
		        // 在庫テーブルから注文数を減少させるために、注文する商品ID・サイズ・注文数量をまとめて格納するリストを作成
		        ArrayList<SKU> skuList = new ArrayList<SKU>();
		        for(Order order:orderList) {
		        	SKU sku = new SKU();
		        	sku.setProductId(order.getProductId());
		        	sku.setSize(order.getOrderSize());
		        	sku.setStock(order.getOrderNumber());
		
		        	skuList.add(sku);
		        }
		        System.out.println(skuList);
		        
		        // 各商品の在庫があるかを確認して、在庫がある場合は注文数量分の在庫を減少させる
		        SkuDAO skuDao = new SkuDAO();
//		        skuDao.checkSku(skuList);
		        skuDao.changeSku(skuList);
		
				// OrderDAOインスタンスを生成し、注文テーブルに情報を追加
				OrderDAO orderDao = new OrderDAO();
				orderDao.insert(orderList);
				
				// オーダー情報をリクエストスコープに格納
				request.setAttribute("orderList", orderList);
				
			       	     
		// AccountデータからUSER_IDを取得し、カートテーブル（DB）の情報を削除
			Account account = (Account) session.getAttribute("Account");
			int userId =account.getUserId();
			CartDAO cartDao = new CartDAO();
			cartDao.deleteByUserId(userId);
		
		// セッションスコープからカートテーブルの情報を削除
		session.removeAttribute("cartList");

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/orderOK.jsp");
		dispatcher.forward(request,  response);
	}

}
