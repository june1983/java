package model;

import java.sql.Timestamp;

public class Order {
	//ユーザーID
	private int userId;
	//商品のID
	private String productId;
	//商品名
	private String orderProduct;
	//単価
	private int orderPrice;
	//サイズ
	private String orderSize;
	//数量
	private int orderNumber;
	//小計
	private int subtotal;
	//日時
	private Timestamp orderDate;

	//ユーザーIDを取得する
	public int getUserId(){
		return userId;
	}
	//ユーザーIDを設定する
	public void setUserId(int userId) {
		this.userId = userId;
	}
	//商品のIDを取得する
	public String getProductId() {
		return productId;
	}
	//商品のIDを設定する
	public void setProductId(String productId) {
		this.productId = productId;
	}
	//商品名を取得する
	public String getOrderProduct() {
		return orderProduct;
	}
	//商品名を設定する
	public void setOrderProduct(String orderProduct) {
		this.orderProduct = orderProduct;
	}
	//商品単価を取得する
	public int getOrderPrice() {
		return orderPrice;
	}
	//商品単価を設定する
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	//商品サイズを取得する
	public String getOrderSize() {
		return orderSize;
	}
	//商品サイズを設定する
	public void setOrderSize(String orderSize) {
		this.orderSize = orderSize;
	}
	//数量を取得する
	public int getOrderNumber() {
		return orderNumber;
	}
	//数量を設定する
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	//小計を取得する
	public int getSubtotal() {
		return subtotal;
	}
	//小計を設定する
	public void setSubtotal() {
		int subtotal = orderPrice * orderNumber;
		this.subtotal = subtotal;
	}
	//注文日時を取得する
	public Timestamp getOrderDate() {
		return orderDate;
	}
	//注文日時を設定する
	public void setOrderDate(Timestamp ts) {
		this.orderDate = ts;
	}
}
