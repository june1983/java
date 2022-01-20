package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {

	//接続用の情報をフィールドに定数として定義
//	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
//	private static String URL = "jdbc:mysql://localhost:3306/neutral?characterEncoding=UTF-8&serverTimezone=JST";
//	private static String EMAIL = "root";
//	private static String PASS = "";

	//データベース接続を行うメソッド
//	public static Connection getConnection(){
//	try{
//		Class.forName(RDB_DRIVE);
//		Connection con = DriverManager.getConnection(URL, EMAIL, PASS);
//		return con;
//	}catch(Exception e){
//		throw new IllegalStateException(e);
//	}
//	}


	public Account findByLogin(Login login) {
		//変数宣言
		Account account = null;
		Connection conn = null;
		PreparedStatement pStmt = null;
		String sql = "SELECT USER_ID, USER_NAME, EMAIL, PASS, ADRESS, TEL, CARD FROM USER WHERE EMAIL = ? AND PASS = ?";

		//データベースへ接続
		try  {
			Class.forName("com.mysql.jdbc.Driver");
		    String dburl = "jdbc:mysql://localhost:3306/neutral?characterEncoding=UTF-8&serverTimezone=JST";
		    conn = DriverManager.getConnection(dburl,"root","root");

			//SELECT文を準備

			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getEmail());
			pStmt.setString(2, login.getPass());

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//一致したユーザーが存在した場合
			//そのユーザーを表すAccountインスタンスを生成
			if (rs.next()) {
				//結果表からデータを取得
				int userId = rs.getInt("USER_ID");
				String userName = rs.getString("USER_NAME");
				String email = rs.getString("EMAIL");
				String pass = rs.getString("PASS");
				String adress = rs.getString("ADRESS");
				String tel = rs.getString("TEL");
				String card = rs.getString("CARD");
				account = new Account(userId, userName, email, pass, adress, tel, card);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		//見つかったユーザーまたはNULLを返す
		return account;
	}


/*	//データベースに同じデータがあるかを確認するメソッド
	public boolean select(Login login) {
		//変数宣言
		Account account = null;
		Connection con = null;
	    String sql = "SELECT USER_NAME, ADDRESS, EMAIL, PASS, TEL, CARD FROM ACCOUNT WHERE EMAIL = ? AND PASS = ?";

		try {
			con = getConnection();
			 //SELECT文を準備
		    PreparedStatement pStmt = con.prepareStatement(sql);
		    pStmt.setString(1, login.getEmail());
		    pStmt.setString(2, login.getPass());

		    //SELECT文を実行し、結果表を取得
		    ResultSet rs = pStmt.executeQuery();

		    //一致したユーザーが存在した場合、そのユーザーを表すAccountインスタンスを生成
		    if(rs.next()) {
		    	//結果表からデータを取得
		    	String userName = rs.getString("USER_NAME");
		    	String address = rs.getString("ADDRESS");
	    		String email = rs.getString("EMAIL");
		    	String pass = rs.getString("PASS");
		    	String tel = rs.getString("TEL");
		    	String card = rs.getString("CARD");
		    	account = new Account(userName, address, email, pass, tel, card);
		    	return false;
		    }
		}catch(Exception e) {
			return false;
		}
			return true;
		}


    //データベースへデータを登録するメソッド
    public boolean insert(Account account){

        //変数宣言
        Connection con = null;
       	Statement  smt = null;

        //return用変数
        int count = 0;

        //SQL文
       String sql = "INSERT INTO account VALUES('"
                    + account.getUserName() + "','"
                    + account.getAdress() + "','"
                    + account.getEmail() + "','"
                    + account.getPass() + "','"
                    + account.getTel() + "','"
                    + account.getCard() + "')";

        try{
            con = getConnection();
            smt = con.createStatement();

            //SQLをDBへ発行
            count = smt.executeUpdate(sql);
	        if(count == 0) {
	        	return false;
	        }else {
	            return true;

	        }

        }catch(Exception e){
        	e.printStackTrace();
        	return false;
        }finally{
            //リソースの開放
            if(smt != null){
                try{smt.close();}catch(SQLException ignore){}
            }
            if(con != null){
                try{con.close();}catch(SQLException ignore){}
            }
        }
    } */
}
