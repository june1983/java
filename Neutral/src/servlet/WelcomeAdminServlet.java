package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SkuDAO;
import model.SKU;


@WebServlet("/WelcomeAdminServlet")
public class WelcomeAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//URLパラメーターを取得
		String id = request.getParameter("id");

//		// セッションスコープからAccountデータを取得
//		HttpSession session = request.getSession();

		// SKUテーブルにアクセスするためのオブジェクトを生成
		SkuDAO skuDao = new SkuDAO();

		if (id != null) {

			// 商品データを全件取得する命令を呼び出し、戻り値を取得する
			ArrayList<SKU> skuList = skuDao.selectByCategoryId(id);

			// 商品リストをセッションスコープに格納
			request.setAttribute("skuList", skuList);

		} else {


			// 商品データを全件取得する命令を呼び出し、戻り値を取得する
			ArrayList<SKU> skuList = skuDao.selectAll();

			// 商品リストをセッションスコープに格納
			request.setAttribute("skuList", skuList);
		}


		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		dispatcher.forward(request,  response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String search = request.getParameter("query");

		// SKUテーブルにアクセスするためのオブジェクトを生成
		SkuDAO skuDao = new SkuDAO();

		if (search != null) {

			// 商品データを全件取得する命令を呼び出し、戻り値を取得する
			ArrayList<SKU> skuList = skuDao.search(search);

			// 商品リストをセッションスコープに格納
			request.setAttribute("skuList", skuList);

		} else {


			// 商品データを全件取得する命令を呼び出し、戻り値を取得する
			ArrayList<SKU> skuList = skuDao.selectAll();

			// 商品リストをセッションスコープに格納
			request.setAttribute("skuList", skuList);
		}


		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		dispatcher.forward(request,  response);
	}

}
