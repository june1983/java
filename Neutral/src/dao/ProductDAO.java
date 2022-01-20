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
	 * SQL実行をおこなう関数
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
	 * DBの商品情報を格納するproductテーブルから全商品情報を取得する関数
	 *
	 * @return 全商品情報のリスト
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public ArrayList<Product> selectAll() {

		try {
			// DB接続
			connect();

			// 商品データ（在庫＋商品＋カテゴリー）を全件取得するSQL文を用意
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
				//product.setSize(rs.getString("product_size"));
				//product.setStock(rs.getInt("sku_number"));
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
	 * 引数で与えられた商品情報を、書籍データを格納するbookinfoテーブルへ登録する関数
	 *
	 * @param book 登録する書籍情報のBookオブジェクト
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
//	public void insert(Book book) {
//
//		try {
//			// DB接続
//			connect();
//
//			// 書籍データを登録するSQL文を用意
//			String sql = "INSERT INTO bookinfo VALUES("
//					   + "'" + book.getIsbn()  + "',"
//					   + "'" + book.getTitle() + "',"
//					   + 	   book.getPrice() + ")";
//
//			// SQL文を発行
//			executeUpdate(sql);
//
//		} catch (Exception e) {
//			throw new IllegalStateException(e);
//		} finally {
//			// DB接続解除
//			disconnect();
//		}
//
//	}

	/**
	 * 書籍情報を格納するbookinfoテーブルに存在する、引数で与えられたISBNを持つ書籍情報を、 引数で与えられた書籍情報に変更をおこなう関数
	 *
	 * @param book 更新する書籍情報のBookオブジェクト
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
//	public void update(Book book) {
//
//		try {
//			// DB接続
//			connect();
//
//			// 指定されたISBN番号の書籍データを更新するSQL文を用意
//			String sql = "UPDATE bookinfo SET"
//					   + " title = '" + book.getTitle() + "',"
//					   + " price =  " + book.getPrice()
//					   + " WHERE isbn = '" + book.getIsbn() + "'";
//
//			// SQL文を発行
//			executeUpdate(sql);
//
//		} catch (Exception e) {
//			throw new IllegalStateException(e);
//		} finally {
			// DB接続解除
//			disconnect();
//		}
//	}

	/**
	 * 書籍情報を格納するbookinfoテーブルから、引数で与えられたISBNを持つ書籍データの削除をおこなう関数
	 *
	 * @param isbn 削除対象のISBN
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
//	public void delete(String isbn) {
//
//		try {
//			// DB接続
//			connect();
//
//			// 指定されたISBN番号の書籍データを削除するSQL文を用意
//			String sql = "DELETE FROM bookinfo WHERE isbn='" + isbn + "'";
//
//			// SQL文を発行
//			executeUpdate(sql);
//
//		} catch (Exception e) {
//			throw new IllegalStateException(e);
//		} finally {
//			// DB接続解除
//			disconnect();
//		}
//
//	}

	/**
	 * 引数の各データを基にDBの書籍情報を格納するbookinfoテーブルから該当書籍データの絞込み検索処理をおこなう関数
	 *
	 * @param title 検索対象のTITLE
	 *
	 * @return 該当書籍データのリスト
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
//	public ArrayList<Book> search(String title) {
//
//		try {
//			// DB接続
//			connect();
//
//			// 指定された書籍タイトルに該当する書籍データを取得するSQL文を用意
//			String sql = "SELECT * FROM bookinfo WHERE title LIKE '%" + title + "%'";
//
//			// SQL文を発行し、結果セットを取得
//			ResultSet rs = executeQuery(sql);
//
//			// 書籍データ格納用のリストオブジェクトを生成
//			ArrayList<Book> bookList = new ArrayList<Book>();
//
//			// 結果セットから1行ずつ書籍データを取得
//			while (rs.next()) {
//				Book book = new Book();
//				book.setIsbn(rs.getString("isbn"));
//				book.setTitle(rs.getString("title"));
//				book.setPrice(rs.getInt("price"));
//				bookList.add(book);
//			}
//
//			// 呼び出し元へ書籍リストを返す
//			return bookList;
//
//		} catch (Exception e) {
//			throw new IllegalStateException(e);
//		} finally {
//			// DB接続解除
//			disconnect();
//		}
//
//	}
}
