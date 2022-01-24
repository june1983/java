package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SkuDAO;
import model.SKU;


@WebServlet("/ProductEditServlet")
public class ProductEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		// データベースアクセス用オブジェクトの生成
		SkuDAO skuDao = new SkuDAO();

		// 商品データを全件取得する命令を呼び出し、戻り値を取得する
		SKU sku = skuDao.selectBySkuId(id);

		// 商品リストをリクエストスコープに格納
		request.setAttribute("sku", sku);

		// 商品リストをセッションスコープに格納
//		HttpSession session = request.getSession();
//		session.setAttribute("sku", sku);
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productEdit.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productEditOK.jsp");
		dispatcher.forward(request, response);
	}

}
