package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Cart;

public class CartDAO {
	// JDBCドライバ内部のDriverクラスパス
	private static final String RDB_DRIVE = "com.mysql.jdbc.Driver";

	// 接続するMySQLデータベースパス
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/neutral?characterEncoding=UTF-8&serverTimezone=JST";

	// データベースのユーザー名
	private static final String DB_USER = "root";

	// データベースのパスワード
	private static final String DB_PASS = "root";

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
	 * 引数で与えられたオーダー商品情報を、カートデータを格納するcartテーブルへ登録する関数
	 *
	 * @param cart 購入する商品情報のCartオブジェクト
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public void insert(Cart cart) {

		try {
			// DB接続
			connect();

			// 書籍データを登録するSQL文を用意
			String sql = "INSERT INTO cart(PRODUCT_ID, USER_ID, PRODUCT_NAME, ORDER_SIZE, ORDER_NUMBER, PRICE, SUBTOTAL) VALUES("
					   + "'" + cart.getProductId()  + "',"
					   + cart.getUserId() + ","
					   + "'" + cart.getOrderProduct() + "',"
					   + "'" + cart.getOrderSize() + "',"
					   + cart.getOrderNumber() + ","
					   + cart.getOrderPrice() + ","
					   + cart.getSubtotal() + ")";
//			 SQL文を発行
			System.out.println(sql);
			executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}

	}

	/**
	 * 引数の顧客IDを基に、Cartテーブルから該当顧客のカートに入っている商品の検索をおこなう関数
	 *
	 * @param userId 検索対象のuserId
	 *
	 * @return 検索結果のカート情報のArrayList<Cart>オブジェクト
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public ArrayList<Cart> selectByUserId(int userId) {

		try {
			// DB接続
			connect();

			// 指定された商品IDの商品データを取得するSQL文を用意
			String sql = "SELECT * FROM cart WHERE USER_ID ='" + userId + "'";

			// SQL文を発行し、結果セットを取得
			ResultSet rs = executeQuery(sql);

			// カートに入っている商品一覧データ格納用のCartリストを生成
			ArrayList<Cart> cartList = new ArrayList<Cart>();


			// 結果セットから1行ずつカートに入っている商品データを取得
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setCartId(rs.getInt("CART_ID"));
				cart.setUserId(rs.getInt("USER_ID"));
				cart.setProductId(rs.getString("PRODUCT_ID"));
				cart.setOrderProduct(rs.getString("PRODUCT_NAME"));
				cart.setOrderPrice(rs.getInt("PRICE"));
				cart.setOrderSize(rs.getString("ORDER_SIZE"));
				cart.setOrderNumber(rs.getInt("ORDER_NUMBER"));
				cart.setSubtotal();
				cartList.add(cart);
			}

			// 呼び出し元へ商品データを返す
			System.out.println(cartList);
			return cartList;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}

	}
	
	/**
	 * 引数で与えられた顧客ID情報に紐づくカートデータをカートテーブルから全て削除する関数
	 *
	 * @param userId 検索対象のuserId
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public void deleteByUserId(int userId) {

		try {
			// DB接続
			connect();

			// カート情報を削除するSQL文を用意
			String sql = "DELETE FROM `cart` WHERE USER_ID = " + userId;
			// SQL文を発行
			System.out.println(sql);
			executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}

	}
	
	/**
	 * 引数で与えられたカートID情報に紐づくカート情報をカートテーブルから削除する関数
	 *
	 * @param cartId 削除するカートのcartId
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public void deleteByCartId(int cartId) {

		try {
			// DB接続
			connect();

			// カート情報を削除するSQL文を用意
			String sql = "DELETE FROM `cart` WHERE CART_ID = " + cartId;
			// SQL文を発行
			System.out.println(sql);
			executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}

	}
}
