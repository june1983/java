package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import dao.SkuDAO;
import model.Product;
import model.SizeSku;


@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		// データベースアクセス用オブジェクトの生成
		ProductDAO productDao = new ProductDAO();

		// 商品データを全件取得する命令を呼び出し、戻り値を取得する
		Product product = productDao.selectByProductId(id);

		// 商品リストをリクエストスコープに格納
		//request.setAttribute("product", product);

		// 商品リストをセッションスコープに格納
		HttpSession session = request.getSession();
		session.setAttribute("Product", product);

		//各サイズごとの在庫情報を取得
		SizeSku sizeSku = new SizeSku();
		SkuDAO skuDao = new SkuDAO();
		sizeSku.setXS(skuDao.checkSizeSku(id, "XS"));
		sizeSku.setS(skuDao.checkSizeSku(id, "S"));
		sizeSku.setM(skuDao.checkSizeSku(id, "M"));
		sizeSku.setL(skuDao.checkSizeSku(id, "L"));
		sizeSku.setXL(skuDao.checkSizeSku(id, "XL"));
		sizeSku.setFREE(skuDao.checkSizeSku(id, "FREE"));

		//サイズ別の在庫情報をリクエストスコープに格納
		session.setAttribute("SizeSku", sizeSku);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/order.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
