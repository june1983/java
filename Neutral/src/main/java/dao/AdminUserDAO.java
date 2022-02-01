package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.AdminUser;
import model.Login;


public class AdminUserDAO {
	//接続用の情報をフィールドに定数として定義
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
	private PreparedStatement pStmt = null;


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
	 * 引数のログイン情報を基にDBのユーザー情報を格納するUSERテーブルから該当ユーザーデータの検索をおこなう関数
	 *
	 * @param login 検索対象のログイン情報
	 *
	 * @return 検索結果のユーザー情報のAccountオブジェクト
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
	public AdminUser findByLogin(Login login) {

		try {
			// DB接続
			connect();

			// 指定されたログイン情報のユーザーデータを取得するSQL文を用意
			String sql = "SELECT ADMIN_ID, ADMIN_EMAIL, ADMIN_PASS from admin WHERE ADMIN_EMAIL = ? AND ADMIN_PASS = ?";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, login.getEmail());
			pStmt.setString(2, login.getPass());

			// SQL文を発行し、結果セットを取得
			ResultSet rs = pStmt.executeQuery();

			// 商品データ格納用のAccountオブジェクトを生成
			AdminUser adminUser = null;

			// 結果セットからユーザーデータを取得
			if (rs.next()) {
				int adminId = rs.getInt("ADMIN_ID");
				String email = rs.getString("ADMIN_EMAIL");
				String pass = rs.getString("ADMIN_PASS");

				adminUser = new AdminUser(adminId, email, pass);
			}

			// 呼び出し元へ商品データを返す
			return adminUser;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}

	}

	/**
	 * 引数のアカウント情報を基にUSERテーブルにユーザー情報を登録する関数
	 *
	 * @param login 検索対象のログイン情報
	 *
	 * @return 検索結果のユーザー情報のAccountオブジェクト
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
//	public boolean insert(AdminUser adminUser){
//
//	    try{
//			// DB接続
//			connect();
//
//	        //return用変数
//	        int count = 0;
//
//	        //SQL文
//	        String sql = "INSERT INTO user VALUES('"
//	        		 	+ account.getUserId() + "','"
//	                    + account.getUserName() + "','"
//	                    + account.getAdress() + "','"
//	                    + account.getEmail() + "','"
//	                    + account.getPass() + "','"
//	                    + account.getTel() + "','"
//	                    + account.getCard() + "')";
//
//	        //SQLをDBへ発行
//	        count = smt.executeUpdate(sql);
//	        if(count == 0) {
//	        	return false;
//	        }else {
//	            return true;
//
//	        }
//
//	    }catch(Exception e){
//	    	e.printStackTrace();
//	    	return false;
//	    }finally{
//	        //リソースの開放
//	        if(smt != null){
//	            try{smt.close();}catch(SQLException ignore){}
//	        }
//	        if(con != null){
//	            try{con.close();}catch(SQLException ignore){}
//	        }
//	    }
//	}
	/**
	 * 顧客情報を格納するUSERテーブルから、引数で与えられたuserIdを持つ顧客データの削除をおこなう関数
	 *
	 * @param userId 削除対象のuserId
	 *
	 * @throws IllegalStateException 関数内部で例外が発生した場合
	 */
//	public void delete(int userId) {
//
//	    try {
//	        // DB接続
//	        connect();
//
//	        // 指定されたuserId番号の顧客データを削除するSQL文を用意
//	        String sql = "DELETE FROM user WHERE user_id ='" + userId + "'";
//
//	        // SQL文を発行
//	        executeUpdate(sql);
//
//	    } catch (Exception e) {
//	        throw new IllegalStateException(e);
//	    } finally {
//	        // DB接続解除
//	        disconnect();
//	    }
//
//	}
//
}
