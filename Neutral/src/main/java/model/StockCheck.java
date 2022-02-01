package model;

import dao.SkuDAO;

public class StockCheck {
	public boolean execute(String productId, String productSize, int orderNumber) {
		SkuDAO dao = new SkuDAO();
		int sku = dao.checkSku(productId, productSize, orderNumber);
		return sku >= orderNumber ;
	}
}
