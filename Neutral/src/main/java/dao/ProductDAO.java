package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Product;

public class ProductDAO {
	// JDBCドライバ内部のDriverクラスパス
	private static final String RDB_DRIVE = "com.mysql.jdbc.Driver";

	// 接続するMySQLデータベースパス
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/neutral?characterEncoding=UTF-8&serverTimezone=JST";

	// データベースのユーザー名
	private static final String DB_USER = "root";

	// データベースのパスワード
	private static final String DB_PASS = "";

	// DBコネクション保持用
	private Connection con = null;

	// ステートメント保持用
	private Statement smt = null;

	/**
	 * フィールド変数の情報を基に、DB接続をおこなう関数
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	private void connect() {

		try {

			Class.forName(RDB_DRIVE);
			this.con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			this.smt = this.con.createStatement();

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}

	}

	/**
	 * DB接続解除をおこなう関数
	 */
	private void disconnect() {

		if (this.smt != null) {
			try {
				this.smt.close();
			} catch (SQLException ignore) {
			}
		}

		if (this.con != null) {
			try {
				this.con.close();
			} catch (SQLException ignore) {
			}
		}

	}

	/**
	 * クエリ発行をおこなう関数
	 *
	 * @return クエリ結果セット
	 *
	 * @param sql 発行するSQL
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	private ResultSet executeQuery(String sql) {

		try {
			return this.smt.executeQuery(sql);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}

	}

	/**
	 * SQLで更新実行（INSERT、UPDATE、DELETE）をおこなう関数
	 *
	 * @return 更新行数
	 *
	 * @param sql 実行するSQL
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	private int executeUpdate(String sql) {

		try {
			return this.smt.executeUpdate(sql);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}

	}

	/**
	 * 商品情報を格納するproductテーブルから全商品情報を取得する関数
	 *
	 * @return 全商品情報のリスト
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public ArrayList<Product> selectAll() {

		try {
			// DB接続
			connect();

			// 商品データを全件取得するSQL文を用意
			String sql = "SELECT * FROM product";

			// SQL文を発行し、結果セットを取得
			ResultSet rs = executeQuery(sql);

			// 商品データ格納用のリストオブジェクトを生成
			ArrayList<Product> productList = new ArrayList<Product>();

			// 結果セットから1行ずつ商品データを取得
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getString("product_id"));
				product.setCategoryId(rs.getString("category_id"));
				product.setProductName(rs.getString("product_Name"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
				product.setAttribute(rs.getString("attribute"));
				productList.add(product);
			}

			// 呼び出し元へ商品データを返す
			return productList;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}

	}


	/**
	 * 商品情報を格納するproductテーブルから特定のカテゴリーIDに紐づく全商品情報を取得する関数
	 *
	 * @return カテゴリー別の全商品情報リスト
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public ArrayList<Product> selectByCategoryId(String cateoryId) {

		try {
			// DB接続
			connect();

			// 商品データを全件取得するSQL文を用意
			String sql = "SELECT * FROM product WHERE category_id='" + cateoryId + "'";

			// SQL文を発行し、結果セットを取得
			ResultSet rs = executeQuery(sql);

			// 商品データ格納用のリストオブジェクトを生成
			ArrayList<Product> productCategoryList = new ArrayList<Product>();

			// 結果セットから1行ずつ商品データを取得
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getString("product_id"));
				product.setCategoryId(rs.getString("category_id"));
				product.setProductName(rs.getString("product_Name"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
				product.setAttribute(rs.getString("attribute"));
				productCategoryList.add(product);
			}

			// 呼び出し元へ商品データを返す
			return productCategoryList;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}

	}

	/**
	 * 引数の商品IDを基にDBの商品情報を格納するproductテーブルから該当商品データの検索をおこなう関数
	 *
	 * @param isbn 検索対象のISBN
	 *
	 * @return 検索結果の商品情報のProductオブジェクト
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public Product selectByProductId(String productId) {

		try {
			// DB接続
			connect();

			// 指定された商品IDの商品データを取得するSQL文を用意
			String sql = "SELECT * FROM product WHERE product_id='" + productId + "'";

			// SQL文を発行し、結果セットを取得
			ResultSet rs = executeQuery(sql);

			// 商品データ格納用のproductオブジェクトを生成
			Product product = new Product();

			// 結果セットから商品データを取得
			if (rs.next()) {
				product.setProductId(rs.getString("product_id"));
				product.setCategoryId(rs.getString("category_id"));
				product.setProductName(rs.getString("product_Name"));
				product.setPrice(rs.getInt("price"));
				//product.setSize(rs.getString("product_size"));
				//product.setStock(rs.getInt("sku_number"));
				product.setDescription(rs.getString("description"));
				product.setAttribute(rs.getString("attribute"));
			}

			// 呼び出し元へ商品データを返す
			return product;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}

	}


	/**
	 * 引数の検索ワードを基にDBの商品情報を格納するPRODUCTテーブルから該当商品データの絞込み検索処理をおこなう関数
	 *
	 * @param words 検索対象の文言
	 *
	 * @return 該当商品データのリスト
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public ArrayList<Product> search(String words) {

		try {
			// DB接続
			connect();

			// 指定された書籍タイトルに該当する書籍データを取得するSQL文を用意
			String sql = "SELECT * FROM product WHERE ATTRIBUTE LIKE '%" + words + "%' or DESCRIPTION LIKE '%" + words + "%' or PRODUCT_ID LIKE '%" + words + "%' or PRODUCT_NAME LIKE '%" + words + "%'";

			// SQL文を発行し、結果セットを取得
			ResultSet rs = executeQuery(sql);

			// 書籍データ格納用のリストオブジェクトを生成
			ArrayList<Product> searchProductList = new ArrayList<Product>();

			// 結果セットから1行ずつ書籍データを取得
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getString("product_id"));
				product.setCategoryId(rs.getString("category_id"));
				product.setProductName(rs.getString("product_Name"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
				product.setAttribute(rs.getString("attribute"));
				searchProductList.add(product);
			}

			// 呼び出し元へ書籍リストを返す
			return searchProductList;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}

	}
}
