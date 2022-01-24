package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SkuDAO;
import model.SKU;


@WebServlet("/RegisterProductOkServlet")
public class RegisterProductOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// データベースアクセス用オブジェクトの生成
		SkuDAO skuDao = new SkuDAO();

		// 商品データを全件取得する命令を呼び出し、戻り値を取得する
		ArrayList<SKU> skuList = skuDao.selectAll();

		// 商品リストをセッションスコープに格納
		HttpSession session = request.getSession();
		session.setAttribute("skuList", skuList);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
