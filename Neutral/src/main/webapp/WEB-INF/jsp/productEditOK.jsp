<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.SkuDAO,model.SKU"%>
<%
    // セッションスコープから商品情報を取得
    SKU sku = (SKU)session.getAttribute("SKU");
%>

<!-- HEADER -->
<jsp:include page="admin-header.jsp"></jsp:include>

<main>
<div class="container-sl">
	<div class="shadow p-3 mb-5 bg-body rounded" style="width:1250px">
		<div>
			<p strong>以下の内容で登録情報を変更します。よろしいですか？</p>
		</div>
		<table class="table table-bordered">
		  <thead>
		    <tr>
		      <th scope="col" class="example4">在庫ID</th>
		      <th scope="col" class="example4">商品ID</th>
		      <th scope="col" class="example2">商品名</th>
		      <th scope="col" class="example4">カテゴリ</th>
		      <th scope="col" class="example4">サイズ</th>
		      <th scope="col" class="example4">単価</th>
		      <th scope="col" class="example2">商品説明</th>
		      <th scope="col" class="example2">商品属性</th>
		      <th scope="col" class="example1">在庫数量</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <td class="example4"><%=sku.getSkuId()%></td>
		      <td class="example4"><%=sku.getProductId()%></td>
		      <td class="example2"><%=sku.getProductName()%></td>
		      <td class="example4"><%=sku.getCategoryId()%></td>
		      <td class="example4"><%=sku.getSize()%></td>
		      <td class="example4"><%=sku.getPrice()%></td>
		      <td class="example2"><%=sku.getDescription()%></td>
		      <td class="example2"><%=sku.getAttribute()%></td>
		      <td class="example1"><%=sku.getStock()%></td>
		    </tr>
		  </tbody>
		</table>
		<div>
		 <a href="/Neutral/ProductEditOkServlet"><button type="button" class="btn btn-primary">はい、変更します</button></a>
		 <a href="/Neutral/ProductEditServlet?id=<%=sku.getSkuId()%>"><button type="button" class="btn btn-outline-primary">戻る</button></a>
		</div>
	</div>
</div>

</main>
</body>
</html>