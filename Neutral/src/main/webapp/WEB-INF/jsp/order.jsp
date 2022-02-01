<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.ProductDAO,model.Product,model.SizeSku,java.util.ArrayList"%>
<%
//セッションスコープから商品情報を取得
Product product = (Product) session.getAttribute("Product");
//アプリケーションスコープからサイズごとの在庫情報を取得
SizeSku sizeSku = (SizeSku) session.getAttribute("SizeSku");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Neutral | 商品詳細</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Lobster&family=Nunito:ital,wght@1,200&family=Permanent+Marker&family=Titillium+Web:wght@200&family=Ubuntu:wght@300&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="js/item-image.js"></script>
<link rel="shortcut icon" href="favicon.ico"/>
<link rel="stylesheet" href="css/headers.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/item-image.scss">
<style>
.label-danger {
color:red;
}
</style>
</head>
<body>
<!-- HEADER -->
<jsp:include page="header.jsp"></jsp:include>

<main>
  <p>ファッションを楽しむすべての人に。</p><br>
  <p>ユニセックスアイテムでもっと自由に。もっと楽しく。</p>

  <div class="container-s">
    <div class="row g-2">
      <div class="col-7">
        <div class="shadow p-3 mb-5 bg-body rounded">
          <div id="content">
            <div id="featured_img">
            <img id="img" src="img/<%=product.getProductImage()%>"alt="<%=product.getProductName()%>">
            </div>
            <!--
            <div id="thumb_img" class="cf">
            <img class="active" src="#" onclick="changeimg('#',this);">
            <img src="#" onclick="changeimg('#',this);">
            <img src="#" onclick="changeimg('#',this);">
            </div>
            -->
            </div>
        </div>
      </div>

      <div class="col-5">
        <div class="shadow p-3 mb-5 bg-body rounded">
          <p strong>商品ID：<%=product.getProductId()%></p>
          <p strong>商品名：<%=product.getProductName()%></p>
          <p strong>価格：<%=product.getPrice()%>円</p>

        ＜商品説明＞<br><%=product.getDescription()%><br><br>

        <form action="/Neutral/CartServlet" method="post">
          サイズ：
          <select class="form-select-s" name="orderSize" required>
            <option value="">サイズを選択してください</option>
            <option value="XS" <% if(sizeSku.getXS() < 1) { out.println("disabled"); }; %>>
            	XS<% if(sizeSku.getXS() < 1 ) { out.println("　　※在庫なし"); }; %>
            </option>
	        <option value="S" <% if(sizeSku.getS() < 1) { out.println("disabled"); }; %>>
	        	 S<% if(sizeSku.getS() < 1 ) { out.println("　　※在庫なし"); }; %>
	        </option>
            <option value="M" <% if(sizeSku.getM() < 1) { out.println("disabled"); }; %>>
            	 M<% if(sizeSku.getM() < 1 ) { out.println("　　※在庫なし"); }; %>
            </option>
            <option value="L" <% if(sizeSku.getL() < 1) { out.println("disabled"); }; %>>
            	 L<% if(sizeSku.getL() < 1 ) { out.println("　　※在庫なし"); }; %>
            </option>
            <option value="XL" <% if(sizeSku.getXL() < 1) { out.println("disabled"); }; %>>
            	XL<% if(sizeSku.getXL() < 1 ) { out.println("　　※在庫なし"); }; %>
            </option>
            <option value="FREE" <% if(sizeSku.getFREE() < 1) { out.println("disabled"); }; %>>
            	FREE<% if(sizeSku.getFREE() < 1 ) { out.println("　※在庫なし"); }; %>
            </option>
          </select><br><br>
          個数：
          <input type="number" name="orderNumber" min="1" value="1"><br><br>
          <!--
          <select class="form-select-s" aria-label="Default select example">
            <option selected>個数を選択してください</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
          </select><br><br><br>
		  -->
		  <p><span class="label label-danger">${message}</span></p>
          <button type="submit" class="btn btn-dark">カートに追加</button>
        </form>
      </div>

    </div>
  </div>
</main>
<!-- FOOTER -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>