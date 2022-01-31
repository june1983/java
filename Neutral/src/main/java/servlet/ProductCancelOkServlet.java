package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SkuDAO;
import model.SKU;


@WebServlet("/ProductCancelOkServlet")
public class ProductCancelOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションスコープからSKU情報を取得
		HttpSession session = request.getSession();
		SKU sku = (SKU) session.getAttribute("sku");
		// SKU_IDを取得して変数に代入
		int skuId = sku.getSkuId();

		// データベースアクセス用オブジェクトの生成
		SkuDAO skudao = new SkuDAO();

		// 指定したskuIdのデータを削除する命令を呼び出す
		skudao.delete(skuId);
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WelcomeAdminServlet");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
