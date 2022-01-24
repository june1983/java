<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- HEADER -->
<jsp:include page="admin-header.jsp"></jsp:include>

<main>
<div class="container-scr">
	<form action="/Neutral/RegisterProductServlet" method="post">
		<div class="shadow p-3 mb-5 bg-body rounded" style="width:500px">
		  <p strong>商品登録</p>
		  <div class="input-group flex-nowrap">
		    <span class="input-group-text bg-info" id="addon-wrapping">商品ID</span>
		    <input type="text" name="productId" class="form-control" required placeholder="英数字4桁　※カテゴリーID+商品コード（整数2桁）" aria-label="Username" aria-describedby="addon-wrapping">
		  </div><br>
		  <div class="input-group flex-nowrap">
		    <span class="input-group-text bg-info" id="addon-wrapping">商品名</span>
		    <input type="text" name="productName" class="form-control" required aria-label="Username" aria-describedby="addon-wrapping">
		  </div><br>

		  <div class="input-group mb-3">
		    <label class="input-group-text bg-info" for="inputGroupSelect01">カテゴリ</label>
		    <select class="form-select" name="category" required id="inputGroupSelect01">
		      <option selected>選択してください</option>
		      <option value="TS">ＴＳ: Tシャツ・カットソー</option>
		      <option value="SW">ＳＷ: スウェット</option>
		      <option value="CO">ＣＯ: コート</option>
		      <option value="DC">ＤＣ: ダウン</option>
		      <option value="KN">ＫＮ: ニット・セーター</option>
		      <option value="JE">ＪＥ: ジーンズ・カラージーンズ</option>
		      <option value="HP">ＨＰ: ハーフパンツ</option>
		      <option value="CA">ＣＡ: 帽子・キャップ・ハット</option>
		      <option value="MA">ＭＡ: マスク</option>
		      <option value="BA">ＢＡ: バッグ</option>
		    </select>
		  </div>
			<div class="input-group mb-3">
			  <label class="input-group-text bg-info" for="inputGroupSelect01">サイズ</label>
			       <select class="form-select" name="size" required aria-label="Default select example">
			         <option selected>サイズを選択してください</option>
			         <option value="XS">XS</option>
			         <option value="S">S</option>
			         <option value="M">M</option>
			         <option value="L">L</option>
			         <option value="XL">XL</option>
			         <option value="FREE">FREE</option>
			       </select>
			</div>
			<div class="input-group flex-nowrap">
			  <span class="input-group-text bg-info" id="addon-wrapping">単価</span>
			  <input type="number" class="form-control" name="price" required aria-label="Username" aria-describedby="addon-wrapping">
			</div><br>
			<div class="input-group flex-nowrap">
			  <span class="input-group-text bg-info" id="addon-wrapping">商品説明</span>
			  <input type="text" class="form-control" name="description" required placeholder="" aria-label="Username" aria-describedby="addon-wrapping">
			</div><br>
			<div class="input-group flex-nowrap">
			  <span class="input-group-text bg-info" id="addon-wrapping">商品属性</span>
			  <input type="text" class="form-control" name="attribute" required placeholder="例）コート,冬,coat,winter　※半角カンマで区切る" aria-label="Username" aria-describedby="addon-wrapping">
			</div><br>
			<div class="input-group flex-nowrap">
			  <span class="input-group-text bg-info" id="addon-wrapping">在庫数量</span>
			  <input type="number" class="form-control" name="stock" required placeholder="  " aria-label="Username" aria-describedby="addon-wrapping">
			</div><br>
			<button type="submit" class="btn btn-primary">登録する</button><br><br>
			<a href="/Neutral/AdminLoginServlet"><button type="button" class="btn btn-outline-primary">戻る</button></a>
		</div>
	 </form>
</div>

</main>
</body>
</html>