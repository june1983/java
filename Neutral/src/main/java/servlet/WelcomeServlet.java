package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		// PRODUCTテーブルにアクセスするオブジェクトの生成
		ProductDAO productDao = new ProductDAO();

		if (id != null) {

			// 商品データを全件取得する命令を呼び出し、戻り値を取得する
			ArrayList<Product> productList = productDao.selectByCategoryId(id);

			// 商品リストをリクエストスコープに格納
			request.setAttribute("productList", productList);

		} else {


			// 商品データを全件取得する命令を呼び出し、戻り値を取得する
			ArrayList<Product> productList = productDao.selectAll();

			// 商品リストをリクエストスコープに格納
			request.setAttribute("productList", productList);
		}

			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
			dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String search = request.getParameter("query");

		// PRODUCTテーブルにアクセスするオブジェクトの生成
		ProductDAO productDao = new ProductDAO();

		if (search != null) {

			// 商品データを全件取得する命令を呼び出し、戻り値を取得する
			ArrayList<Product> productList = productDao.search(search);

			//searchをリクエストスコープに格納
			request.setAttribute("search", search);

			// 商品リストをリクエストスコープに格納
			request.setAttribute("productList", productList);

		} else {


			// 商品データを全件取得する命令を呼び出し、戻り値を取得する
			ArrayList<Product> productList = productDao.selectAll();

			// 商品リストをリクエストスコープに格納
			request.setAttribute("productList", productList);
		}


		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
		dispatcher.forward(request, response);

	}
}
