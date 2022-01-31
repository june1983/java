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


@WebServlet("/ProductEditOkServlet")
public class ProductEditOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// セッションスコープから編集済み商品在庫データを取得
		HttpSession session = request.getSession();
		SKU SKU = (SKU) session.getAttribute("SKU");

		// SkuDAOインスタンスを生成し、編集済み商品在庫データをDBに反映
		SkuDAO skuDao = new SkuDAO();
		skuDao.update(SKU);

		// セッションスコープからインスタンスを削除する
		session.removeAttribute("SKU");

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WelcomeAdminServlet");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
