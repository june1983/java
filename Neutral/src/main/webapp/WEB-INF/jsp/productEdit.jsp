<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.SkuDAO,model.SKU"%>
<%
	// セッションスコープから商品情報を取得
	SKU sku = (SKU)session.getAttribute("sku");
%>

<!-- HEADER -->
<jsp:include page="admin-header.jsp"></jsp:include>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<main>
<div class="container-scr">
	<form action="/Neutral/ProductEditServlet" method="post" enctype="multipart/form-data">
		<div class="shadow p-3 mb-5 bg-body rounded" style="width:500px">

		<div class="input-group flex-nowrap">
		  <span class="input-group-text btn-primary" id="addon-wrapping">在庫ID</span>
		  <input type="text" name="skuId" class="form-control" value="<%=sku.getSkuId()%>" readonly="readonly" aria-label="Username" aria-describedby="addon-wrapping">
		</div><br>
		<div class="input-group flex-nowrap">
		  <span class="input-group-text btn-primary" id="addon-wrapping">商品ID</span>
		  <input type="text" name="productId" class="form-control" value="<%=sku.getProductId()%>"  readonly="readonly" aria-label="Username" aria-describedby="addon-wrapping">
		</div><br>
		<div class="input-group flex-nowrap">
		  <span class="input-group-text btn-primary" id="addon-wrapping">商品名</span>
		  <input type="text" name="productName" class="form-control" value="<%=sku.getProductName()%>" aria-label="Username" aria-describedby="addon-wrapping">
		</div><br>
		<div class="input-group flex-nowrap">
			<span class="input-group-text btn-primary" id="addon-wrapping">写真</span>
			<!-- 選択した画像を出力 -->
			<img width="80%" id="preview" src="img/<%=sku.getProductImage()%>" alt="<%=sku.getProductName()%>">
		</div><br>
		<div class="input-group flex-nowrap">
			<input type="file" name="pict" class="form-control"  id="myImage" accept="image/*" placeholder="img" accept="image/jpeg, image/png">
		</div><br>
		<p><script>$('#myImage').on('change', function (e) {var reader = new FileReader();reader.onload = function (e) {$("#preview").attr('src', e.target.result);}; reader.readAsDataURL(e.target.files[0]);});</script></p>

		<div class="input-group mb-3">
		  <label class="input-group-text btn-primary" for="inputGroupSelect01">カテゴリ</label>
		  <select  name="category" class="form-select" id="inputGroupSelect01">
		    <option selected><%=sku.getCategoryId()%></option>
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
		  <label class="input-group-text btn-primary" for="inputGroupSelect01">サイズ</label>
          <select   name="size" class="form-select" name="orderSize" aria-label="Default select example">
            <option selected><%=sku.getSize()%></option>
            <option value="XS">XS</option>
            <option value="S">S</option>
            <option value="M">M</option>
            <option value="L">L</option>
            <option value="XL">XL</option>
            <option value="FREE">FREE</option>
          </select>
		</div>
		<div class="input-group flex-nowrap">
		  <span class="input-group-text btn-primary" id="addon-wrapping">単価</span>
		  <input type="text" name="price" class="form-control" value="<%=sku.getPrice()%>" oninput="value = value.replace(/[^0-9]+/i,'');" placeholder="半角数字のみ入力可" aria-label="Username" aria-describedby="addon-wrapping">
		</div><br>
		<div class="input-group flex-nowrap">
			<span class="input-group-text btn-primary" id="addon-wrapping">商品説明</span>
			<textarea class="form-control"  name="description" id="exampleFormControlTextarea1" rows="10"><%=sku.getDescription()%></textarea>
		</div><br>
		<div class="input-group flex-nowrap">
			<span class="input-group-text btn-primary" id="addon-wrapping">商品属性</span>
			<textarea class="form-control" name="attribute" id="exampleFormControlTextarea1" rows="3"><%=sku.getAttribute()%></textarea>
		</div><br>
		<div class="input-group flex-nowrap">
		  <span class="input-group-text btn-primary" id="addon-wrapping">在庫数量</span>
		  <input type="text" name="stock" class="form-control" value="<%=sku.getStock()%>" oninput="value = value.replace(/[^0-9]+/i,'');"  placeholder="半角数字のみ入力可" aria-label="Username" aria-describedby="addon-wrapping">
		</div><br>
		  <button type="submit" class="btn btn-primary">変更する</button>
		  <a href="/Neutral/ProductCancelServlet"><button type="button" class="btn btn-outline-danger">商品情報を削除する</button><br><br>
		  <a href="/Neutral/AdminLoginServlet"><button type="button" class="btn btn-outline-primary">戻る</button></a>
		</div>
	</form>
</div>

</main>
</body>
</html>