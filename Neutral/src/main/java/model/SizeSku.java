package model;

public class SizeSku {
	//サイズごとの在庫を持つフィールド
	private int XS;
	private int S;
	private int M;
	private int L;
	private int XL;
	private int FREE;

	//各サイズの在庫数の初期設定をおこなう（コンストラクタ）
	public SizeSku() {
		this.XS = 0;
		this.S = 0;
		this.M = 0;
		this.L = 0;
		this.XL = 0;
		this.FREE = 0;
	}

	//各サイズの在庫数を取得する
	public int getXS() {
		return XS;
	}
	public int getS() {
		return S;
	}
	public int getM() {
		return M;
	}
	public int getL() {
		return L;
	}
	public int getXL() {
		return XL;
	}
	public int getFREE() {
		return FREE;
	}

	//各サイズの在庫数を設定する
	public void setXS(int XS) {
		this.XS = XS;
	}
	public void setS(int S) {
		this.S = S;
	}
	public void setM(int M) {
		this.M = M;
	}
	public void setL(int L) {
		this.L = L;
	}
	public void setXL(int XL) {
		this.XL = XL;
	}
	public void setFREE(int FREE) {
		this.FREE = FREE;
	}
}
