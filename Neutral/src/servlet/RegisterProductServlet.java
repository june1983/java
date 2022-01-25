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


@WebServlet("/RegisterProductServlet")
public class RegisterProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerProduct.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメーターを取得（注文個数）
		request.setCharacterEncoding("UTF-8");
		String productId = request.getParameter("productId");
		String productName = request.getParameter("productName");
		String category = request.getParameter("category");
		String size = request.getParameter("size");
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		String attribute = request.getParameter("attribute");
		int stock = Integer.parseInt(request.getParameter("stock"));

		// 商品在庫データ格納用のSKUオブジェクトを生成
		SKU sku = new SKU();
		sku.setProductId(productId);
		sku.setProductName(productName);
		sku.setCategoryId(category);
		sku.setSize(size);
		sku.setPrice(price);
		sku.setDescription(description);
		sku.setAttribute(attribute);
		sku.setStock(price);

		// SkuDAOインスタンスを生成し、商品在庫テーブルに情報を追加
		SkuDAO skuDao = new SkuDAO();
		skuDao.insert(sku);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerProductOK.jsp");
		dispatcher.forward(request, response);
	}

}
