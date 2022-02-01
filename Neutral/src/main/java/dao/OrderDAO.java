package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Order;

public class OrderDAO {
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
			System.out.println(sql);
		try {
			return this.smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
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

	/*
	public Product selectByProductId(String productId) {

		try {
			// DB接続
			connect();

			// 指定された商品IDの商品データを取得するSQL文を用意
			String sql = "SELECT * FROM product WHERE productId='" + productId + "'";

			// SQL文を発行し、結果セットを取得
			ResultSet rs = executeQuery(sql);

			// 商品データ格納用のBookオブジェクトを生成
			Product product = new Product();

			// 結果セットから商品データを取得
			if (rs.next()) {
				product.setProductId(rs.getString("productId"));
				product.setCategoryId(rs.getString("categoryId"));
				product.setProductName(rs.getString("productName"));
				product.setPrice(rs.getInt("price"));
				//product.setSize(rs.getString("size"));
				//product.setStock(rs.getInt("stock"));
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

	*/

	/**
	 * 引数で与えられた注文リストの情報を、注文データを格納するOrderテーブルへ登録する関数
	 *
	 * @param orderList 購入する商品情報のOrderオブジェクト
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public void insert(ArrayList<Order> orderList) {

		try {
			// DB接続
			connect();

//			//オーダーのインスタンスを生成
//			Order order = new Order();

			for (Order order: orderList) {
				// 注文データを登録するSQL文を用意
				String sql = "INSERT INTO `order` (PRODUCT_ID, USER_ID, PRODUCT_NAME, ORDER_SIZE, ORDER_NUMBER, PRICE, SUBTOTAL, ORDER_DATE) VALUES("
						   + "'" + order.getProductId() + "',"
						   + "'" + order.getUserId() + "',"
						   + "'" + order.getOrderProduct() + "',"
						   + "'" + order.getOrderSize() + "',"
						   + "'" + order.getOrderNumber() + "',"
						   + "'" + order.getOrderPrice() + "',"
						   + "'" + order.getSubtotal() + "',"
						   + "'" + order.getOrderDate() + "')";
				// SQL文を発行
				System.out.println(sql);
				executeUpdate(sql);

			}


		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}

	}


}
