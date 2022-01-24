<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.SkuDAO,model.SKU"%>
<%
    // リクエストスコープから商品情報を取得
    SKU sku = (SKU)request.getAttribute("sku");
%>

<!-- HEADER -->
<jsp:include page="admin-header.jsp"></jsp:include>

<main>
<div class="container-scr">
	<form action="/Neutral/ProductEditServlet" method="post">
		<div class="shadow p-3 mb-5 bg-body rounded" style="width:500px">
		<div class="input-group flex-nowrap">
		  <span class="input-group-text bg-info" id="addon-wrapping">商品ID</span>
		  <input type="text" class="form-control" value="<%=sku.getProductId()%>" aria-label="Username" aria-describedby="addon-wrapping">
		</div><br>
		<div class="input-group flex-nowrap">
		  <span class="input-group-text bg-info" id="addon-wrapping">商品名</span>
		  <input type="text" class="form-control" value="<%=sku.getProductName()%>" aria-label="Username" aria-describedby="addon-wrapping">
		</div><br>
		
<!-- 	<div class="input-group flex-nowrap">
		  <span class="input-group-text bg-info" id="addon-wrapping">写真</span>
		  <input type="file" class="form-control" placeholder="img" aria-label="Username" aria-describedby="addon-wrapping"name="example" accept="image/jpeg, image/png">
		</div><br> -->
		
		<div class="input-group mb-3">
		  <label class="input-group-text bg-info" for="inputGroupSelect01">カテゴリ</label>
		  <select class="form-select" id="inputGroupSelect01">

		    <option selected><%=sku.getCategoryId()%></option>
		    <option value="1">ＴＳ:　Tシャツ・カットソー</option>
		    <option value="2">ＳＷ:　スウェット</option>
		    <option value="3">ＣＯ:　コート</option>
		    <option value="3">ＤＣ:　ダウン</option>
		    <option value="3">ＫＮ:　ニット・セーター</option>
		    <option value="3">ＪＥ:　ジーンズ・カラージーンズ</option>
		    <option value="3">ＨＰ:　ハーフパンツ</option>
		    <option value="3">ＣＡ:　帽子・キャップ・ハット</option>
		    <option value="3">ＭＡ:　マスク</option>
		    <option value="3">ＢＡ:　バッグ</option>
		  </select>
		</div>
		<div class="input-group flex-nowrap">
		  <span class="input-group-text bg-info" id="addon-wrapping">サイズ</span>
		  <input type="text" class="form-control" value="<%=sku.getSize()%>" aria-label="Username" aria-describedby="addon-wrapping">
		</div><br>
		<div class="input-group flex-nowrap">
		  <span class="input-group-text bg-info" id="addon-wrapping">単価</span>
		  <input type="text" class="form-control" value="<%=sku.getPrice()%>" aria-label="Username" aria-describedby="addon-wrapping">
		</div><br>
		<div class="input-group flex-nowrap">
		  <span class="input-group-text bg-info" id="addon-wrapping">商品説明</span>
		  <input type="text" class="form-control" value="<%=sku.getDescription()%>" aria-label="Username" aria-describedby="addon-wrapping">
		</div><br>
		<div class="input-group flex-nowrap">
		  <span class="input-group-text bg-info" id="addon-wrapping">商品属性</span>
		  <input type="text" class="form-control" value="<%=sku.getAttribute()%>" aria-label="Username" aria-describedby="addon-wrapping">
		</div><br>
		<div class="input-group flex-nowrap">
		  <span class="input-group-text bg-info" id="addon-wrapping">在庫数量</span>
		  <input type="text" class="form-control" value="<%=sku.getStock()%>" aria-label="Username" aria-describedby="addon-wrapping">
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