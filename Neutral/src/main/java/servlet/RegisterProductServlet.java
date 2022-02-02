package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.SkuDAO;
import model.SKU;


@WebServlet("/RegisterProductServlet")
@MultipartConfig(
//location="/tmp"
//maxFileSize=1000000,
//maxRequestSize=1000000,
//fileSizeThreshold=1000000
)
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

		// SQLエラーの原因になりうるシングルコーテーションを半角スペースに変換
		String pattern = "'" ;
		String ProductId = productId.replaceAll(pattern,"");
		String ProductName = productName.replaceAll(pattern,"");
		String Description = description.replaceAll(pattern,"");
		String Attribute = attribute.replaceAll(pattern,"");


		//name属性がpictのファイルをPartオブジェクトとして取得
		Part part = request.getPart("pict");

		//ファイル名を取得
		String filename = part.getSubmittedFileName();//ie対応が不要な場合
		//String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();

		//アップロードされたファイルの拡張子を取得
		String fe = "";
		int i = filename.lastIndexOf('.');
		if (i > 0) {
		    fe = filename.substring(i+1);
		}
		System.out.println("File extension is : "+fe);
		//ファイル名にプロダクトIDを付与
		String fileName = productId + "." + fe;

		//アップロードするフォルダ
		String path=getServletContext().getRealPath("/img");

		//実際にファイルが保存されるパス確認
		System.out.println(path);

		//書き込み
		part.write(path+File.separator+fileName);

		// 商品在庫データ格納用のSKUオブジェクトを生成
		SKU sku = new SKU();
		sku.setProductId(ProductId);
		sku.setProductName(ProductName);
		sku.setProductImage(fileName);
		sku.setCategoryId(category);
		sku.setSize(size);
		sku.setPrice(price);
		sku.setDescription(Description);
		sku.setAttribute(Attribute);
		sku.setStock(stock);

		// SkuDAOインスタンスを生成し、商品在庫テーブルに情報を追加
		SkuDAO skuDao = new SkuDAO();
		skuDao.insert(sku);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerProductOK.jsp");
		dispatcher.forward(request, response);
	}

}
