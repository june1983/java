package model;

public class SKU {
	//在庫ID
	private int skuId;
	//商品ID
	private String productId;
	//商品のカテゴリーID
	private String categoryId;
	//商品名
	private String productName;
	//単価
	private int price;
	//サイズ
	private String size;
	//在庫個数
	private int stock;
	//商品説明
	private String description;
	//商品属性
	private String attribute;

	//（商品ID・カテゴリーID・価格）の初期設定をおこなう（コンストラクタ）
	public SKU() {
		this.skuId = 0;
		this.productId = null;
		this.categoryId = null;
		this.productName = null;
		this.price = 0;
		this.size = null;
		this.stock = 0;
		this.description = null;
		this.attribute = null;
	}
	
	//在庫IDを取得する
	public int getSkuId() {
		return skuId;
	}
	//在庫IDを設定する
	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}
	
	//商品のIDを取得する
	public String getProductId() {
		return productId;
	}
	//商品のIDを設定する
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	//商品のカテゴリーIDを取得する
	public String getCategoryId() {
		return categoryId;
	}
	//商品のカテゴリーIDを設定する
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	//商品名を取得する
	public String getProductName() {
		return productName;
	}
	//商品名を設定する
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	//商品単価を取得する
	public int getPrice() {
		return price;
	}
	//商品単価を設定する
	public void setPrice(int price) {
		this.price = price;
	}

	//商品サイズを取得する
	public String getSize() {
		return size;
	}
	//商品サイズを設定する
	public void setSize(String size) {
		this.size = size;
	}
	
	//商品の在庫個数を取得する
	public int getStock() {
		return stock;
	}
	//商品の在庫個数を設定する
	public void setStock(int stock) {
		this.stock = stock;
	}

	//商品説明を取得する
	public String getDescription() {
		return description;
	}
	//商品説明を設定する
	public void setDescription(String description) {
		this.description = description;
	}
	
	//商品属性を取得する
	public String getAttribute() {
		return attribute;
	}
	//商品属性を設定する
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
}
