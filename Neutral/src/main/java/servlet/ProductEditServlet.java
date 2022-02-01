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


@WebServlet("/ProductEditServlet")
public class ProductEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//URLからパラメーターを取得
		int id = Integer.parseInt(request.getParameter("id"));

		// データベースアクセス用オブジェクトの生成
		SkuDAO skuDao = new SkuDAO();

		// 商品データを全件取得する命令を呼び出し、戻り値を取得する
		SKU sku = skuDao.selectBySkuId(id);

		// 商品リストをセッションスコープに格納
		HttpSession session = request.getSession();
		session.setAttribute("sku", sku);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productEdit.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメーターを取得（注文個数）
		request.setCharacterEncoding("UTF-8");
		int skuId = Integer.parseInt(request.getParameter("skuId"));
		String productId = request.getParameter("productId");
		String productName = request.getParameter("productName");
		String category = request.getParameter("category");
		String size = request.getParameter("size");
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		String attribute = request.getParameter("attribute");
		int stock = Integer.parseInt(request.getParameter("stock"));

		// SQLエラーの原因になりうるシングルコーテーションを半角スペースに変換
		String pattern = "'" ;
		String ProductId = productId.replaceAll(pattern,"");
		String ProductName = productName.replaceAll(pattern,"");
		String Description = description.replaceAll(pattern,"");
		String Attribute = attribute.replaceAll(pattern,"");

		// 編集した商品在庫データ格納用のSKUオブジェクトを生成
		SKU skuUd = new SKU();
		skuUd.setSkuId(skuId);
		skuUd.setProductId(ProductId);
		skuUd.setProductName(ProductName);
		skuUd.setCategoryId(category);
		skuUd.setSize(size);
		skuUd.setPrice(price);
		skuUd.setDescription(Description);
		skuUd.setAttribute(Attribute);
		skuUd.setStock(stock);

		// 商品リストをセッションスコープに格納
		HttpSession session = request.getSession();
		session.setAttribute("SKU", skuUd);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productEditOK.jsp");
		dispatcher.forward(request, response);
	}

}
