package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.SKU;

public class SkuDAO {
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
	 * 商品情報を持つPRODUCTテーブルと在庫情報を持つSKUテーブルから全商品情報を取得する関数
	 *
	 * @return 全商品情報のリスト
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public ArrayList<SKU> selectAll() {

		try {
			// DB接続
			connect();

			// 商品データを全件取得するSQL文を用意
			String sql = "SELECT * FROM sku LEFT OUTER JOIN product ON sku.PRODUCT_ID = product.PRODUCT_ID LEFT OUTER JOIN category ON product.CATEGORY_ID = category.CATEGORY_ID";

			// SQL文を発行し、結果セットを取得
			ResultSet rs = executeQuery(sql);

			// 商品データ格納用のリストオブジェクトを生成
			ArrayList<SKU> skuList = new ArrayList<SKU>();

			// 結果セットから1行ずつ商品データを取得
			while (rs.next()) {
				SKU sku = new SKU();
				sku.setSkuId(rs.getInt("sku_id"));
				sku.setProductId(rs.getString("product_id"));
				sku.setCategoryId(rs.getString("category_id"));
				sku.setProductName(rs.getString("product_name"));
				sku.setSize(rs.getString("product_size"));
				sku.setStock(rs.getInt("sku_number"));
				sku.setPrice(rs.getInt("price"));
				sku.setDescription(rs.getString("description"));
				sku.setAttribute(rs.getString("attribute"));
				skuList.add(sku);
			}

			// 呼び出し元へ商品データを返す
			return skuList;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}

	}

	/**
	 * 商品在庫情報を格納するPRODUCTテーブルとSKUテーブルから特定のカテゴリー名に紐づく全商品情報を取得する関数
	 *
	 * @return カテゴリー別の全商品情報リスト
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public ArrayList<SKU> selectByCategoryId(String cateoryName) {

		try {
			// DB接続
			connect();

			// 商品データを全件取得するSQL文を用意
			String sql = "SELECT * FROM sku LEFT OUTER JOIN product ON sku.PRODUCT_ID = product.PRODUCT_ID LEFT OUTER JOIN category ON product.CATEGORY_ID = category.CATEGORY_ID WHERE category_name = '" + cateoryName + "'";

			// SQL文を発行し、結果セットを取得
			ResultSet rs = executeQuery(sql);

			// 商品データ格納用のリストオブジェクトを生成
			ArrayList<SKU> SkuCategoryList = new ArrayList<SKU>();


			// 結果セットから1行ずつ商品データを取得
			while (rs.next()) {
				SKU sku = new SKU();
				sku.setSkuId(rs.getInt("sku_id"));
				sku.setProductId(rs.getString("product_id"));
				sku.setCategoryId(rs.getString("category_id"));
				sku.setProductName(rs.getString("product_name"));
				sku.setSize(rs.getString("product_size"));
				sku.setStock(rs.getInt("sku_number"));
				sku.setPrice(rs.getInt("price"));
				sku.setDescription(rs.getString("description"));
				sku.setAttribute(rs.getString("attribute"));
				SkuCategoryList.add(sku);
			}

			// 呼び出し元へ商品データを返す
			return SkuCategoryList;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}

	}


	/**
	 * 引数の在庫IDを基にDBの商品情報を格納するPRODUCTテーブルとSKUテーブルから該当商品在庫データの検索をおこなう関数
	 *
	 * @param skuId 検索対象の在庫ID
	 *
	 * @return 検索結果の商品情報のSKUオブジェクト
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public SKU selectBySkuId(int skuId) {

		try {
			// DB接続
			connect();

			// 指定された商品IDの商品データを取得するSQL文を用意
			String sql = "SELECT * FROM sku LEFT OUTER JOIN product ON sku.PRODUCT_ID = product.PRODUCT_ID LEFT OUTER JOIN category ON product.CATEGORY_ID = category.CATEGORY_ID WHERE sku_id='" + skuId + "'";

			// SQL文を発行し、結果セットを取得
			ResultSet rs = executeQuery(sql);

			// 商品データ格納用のproductオブジェクトを生成
			SKU sku = new SKU();

			// 結果セットから商品データを取得
			if (rs.next()) {
				sku.setSkuId(rs.getInt("sku_id"));
				sku.setProductId(rs.getString("product_id"));
				sku.setCategoryId(rs.getString("category_id"));
				sku.setProductName(rs.getString("product_name"));
				sku.setSize(rs.getString("product_size"));
				sku.setStock(rs.getInt("sku_number"));
				sku.setPrice(rs.getInt("price"));
				sku.setDescription(rs.getString("description"));
				sku.setAttribute(rs.getString("attribute"));
			}

			// 呼び出し元へ商品データを返す
			return sku;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}

	}



	/**
	 * 引数で与えられた商品在庫情報を、それぞれのデータを格納するPRODUCTテーブルとSKUテーブルに登録する関数
	 *
	 * @param sku 登録する書籍情報のSKUオブジェクト
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public void insert(SKU sku) {

		try {
			// DB接続
			connect();

			// 商品データを登録するSQL文を用意
			String productSql = "INSERT INTO product (PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, PRICE, DESCRIPTION, ATTRIBUTE) VALUES("
					   + "'" + sku.getProductId()  + "',"
					   + "'" + sku.getCategoryId() + "',"
					   + "'" + sku.getProductName() + "',"
					   + "'" + sku.getPrice() + "',"
					   + "'" + sku.getDescription() + "',"
					   + "'" + sku.getAttribute() + "')";


			// 在庫データを登録するSQL文を用意
			String skuSql = "INSERT INTO sku (PRODUCT_ID, PRODUCT_SIZE, SKU_NUMBER) VALUES("
//					   + "'" + "" + "',"
					   + "'" + sku.getProductId() + "',"
					   + "'" + sku.getSize() + "',"
					   + "'" + sku.getStock() + "')";

			// SQL文を発行
			executeUpdate(productSql);
			executeUpdate(skuSql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}

	}

	/**
	 * 引数で与えられた在庫IDを持つ商品+在庫データを、 引数で与えられた商品+在庫データに変更をおこなう関数
	 *
	 * @param skuUd 更新する商品在庫情報のSKUオブジェクト
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public void update(SKU skuUd) {

		try {
			// DB接続
			connect();

			// 編集を行う商品の商品テーブルを更新するSQL文を用意
			String productSQL = "UPDATE product SET"
					   + " PRODUCT_ID = '" + skuUd.getProductId() + "',"
					   + " CATEGORY_ID = '" + skuUd.getCategoryId() + "',"
					   + " PRODUCT_NAME = '" + skuUd.getProductName() + "',"
					   + " PRICE = '" + skuUd.getPrice() + "',"
					   + " DESCRIPTION = '" + skuUd.getDescription() + "',"
					   + " ATTRIBUTE = '" + skuUd.getAttribute() + "'"
					   + " WHERE PRODUCT_ID = '" + skuUd.getProductId() + "'";

			// 編集を行う商品の在庫テーブルを更新するSQL文を用意
			String skuSQL = "UPDATE sku SET"
					   + " PRODUCT_ID = '" + skuUd.getProductId() + "',"
				       + " PRODUCT_SIZE = '" + skuUd.getSize() + "',"
					   + " SKU_NUMBER = '" + skuUd.getStock() + "'"
					   + " WHERE SKU_ID = '" + skuUd.getSkuId() + "'";

			// SQL文を発行
			executeUpdate(productSQL);
			executeUpdate(skuSQL);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}
	}

	/**
	 * 引数の検索ワードを基にDBの商品在庫情報を格納するPRODUCTテーブルから該当商品データの絞込み検索処理をおこなう関数
	 *
	 * @param words 検索対象の文言
	 *
	 * @return 該当商品データのリスト
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public ArrayList<SKU> search(String words) {

		try {
			// DB接続
			connect();

			// 指定された書籍タイトルに該当する書籍データを取得するSQL文を用意
			String sql = "SELECT * FROM sku LEFT OUTER JOIN product "
					+ "ON sku.PRODUCT_ID = product.PRODUCT_ID "
					+ "LEFT OUTER JOIN category "
					+ "ON product.CATEGORY_ID = category.CATEGORY_ID "
					+ "WHERE ATTRIBUTE LIKE '%" + words + "%' "
							+ "or DESCRIPTION LIKE '%" + words + "%' "
							+ "or PRODUCT_NAME LIKE '%" + words + "%'";

			// SQL文を発行し、結果セットを取得
			ResultSet rs = executeQuery(sql);

			// 商品データ格納用のリストオブジェクトを生成
			ArrayList<SKU> SkuSearchList = new ArrayList<SKU>();


			// 結果セットから1行ずつ商品データを取得
			while (rs.next()) {
				SKU sku = new SKU();
				sku.setSkuId(rs.getInt("sku_id"));
				sku.setProductId(rs.getString("product_id"));
				sku.setCategoryId(rs.getString("category_id"));
				sku.setProductName(rs.getString("product_name"));
				sku.setSize(rs.getString("product_size"));
				sku.setStock(rs.getInt("sku_number"));
				sku.setPrice(rs.getInt("price"));
				sku.setDescription(rs.getString("description"));
				sku.setAttribute(rs.getString("attribute"));
				SkuSearchList.add(sku);
			}

			// 呼び出し元へ書籍リストを返す
			return SkuSearchList;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}

	}

	/**
	 * 在庫情報を格納するProductテーブルとSKUテーブルから、引数で与えられたskuIdを持つ在庫データの削除をおこなう関数
	 *
	 * @param skuId 削除対象のSKU_ID
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public void delete(int skuId) {

		try {
			// DB接続
			connect();

			// 指定されたISBN番号の書籍データを削除するSQL文を用意
			String sql = "DELETE sku,product FROM sku LEFT OUTER JOIN product ON sku.PRODUCT_ID = product.PRODUCT_ID LEFT OUTER JOIN category ON product.CATEGORY_ID = category.CATEGORY_ID WHERE sku_id='" + skuId + "'";

			// SQL文を発行
			executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}

	}
	
	//商品の在庫があるかを確認するメソッド
	public void checkSku(ArrayList<SKU> skuList) {

		try {
			// DB接続
			connect();

			for(SKU sku:skuList) {

			// 指定された商品ID・サイズの在庫数データを取得するSQL文を用意
			String sql = "SELECT SKU_NUMBER FROM `sku`"
			+ " WHERE PRODUCT_ID = '" + sku.getProductId() + "' AND PRODUCT_SIZE = '" + sku.getSize() + "'";
			// SQL文を発行
			System.out.println(sql);
			smt.execute(sql);
			//SQLの実行結果を変数stockにセット
			ResultSet rs = smt.getResultSet();
			rs.next();
			int stock = rs.getInt("SKU_NUMBER");
			//在庫数量が注文数量より多いかを確認
			if(stock - sku.getStock() < 0) {
				System.out.println("在庫なし");
			}
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}

	}

	//商品購入時に在庫の数量を減らすメソッド
	public void changeSku(ArrayList<SKU> skuList) {

		try {
			// DB接続
			connect();

			for(SKU sku:skuList) {

			// 指定された商品ID・サイズの在庫数データを取得するSQL文を用意
			String sql = "UPDATE `sku` SET SKU_NUMBER = SKU_NUMBER - " + sku.getStock()
			+ " WHERE PRODUCT_ID = '" + sku.getProductId() + "' AND PRODUCT_SIZE = '" + sku.getSize() + "'";
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
