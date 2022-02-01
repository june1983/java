<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%@ page import="dao.ProductDAO,model.Product,java.util.ArrayList"%>
<%
    // リクエストスコープから商品情報を取得
    ArrayList<Product> productList = (ArrayList<Product>)request.getAttribute("productList");
	//リクエストスコープから検索ワードを取得
	String search = (String)request.getAttribute("search");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Neutral | TOPページ</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Lobster&family=Nunito:ital,wght@1,200&family=Permanent+Marker&family=Titillium+Web:wght@200&family=Ubuntu:wght@300&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="shortcut icon" href="favicon.ico"/>
<link rel="stylesheet" href="css/headers.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/style.css">
<style>
.searchWord {
	font-weight: bold;
	font-size: 16px;
}
</style>
</head>
<body>
<!-- HEADER -->
<jsp:include page="header.jsp"></jsp:include>

<main>
<%if(search == null) { %>
    <p>ファッションを楽しむすべての人に。</p><br>
    <p>ユニセックスアイテムでもっと自由に。もっと楽しく。</p><br>
<% } %>
<% if(search != null) {%>
	<p class="searchWord">"<%=search %>" の検索結果</p>
<% } %>

	<!-- 商品リストから1行ずつデータを取得し表示 -->
	<div class="photogallery">
		<% for (Product product: productList) { %>
		<div class="photo shadow fade1">
		    <div class="inner">
			    <a href="/Neutral/OrderServlet?id=<%=product.getProductId()%>">
			    <img src="img/<%=product.getProductImage()%>" alt="<%=product.getProductName()%>">
			    </a>
		    </div>
		    <div class="inner-text">
				<p><%=product.getProductName()%></p>
			    <p><%=product.getPrice()%>円</p>
		    </div>
		</div>
		<% } %>
	</div>
</main>
<!-- FOOTER -->
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>






