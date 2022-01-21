<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%@ page import="dao.ProductDAO,model.Product,java.util.ArrayList"%>
<%
    // リクエストスコープから商品情報を取得
    ArrayList<Product> productList = (ArrayList<Product>)request.getAttribute("productList");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NEUTRAL/top</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Lobster&family=Nunito:ital,wght@1,200&family=Permanent+Marker&family=Titillium+Web:wght@200&family=Ubuntu:wght@300&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/headers.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/style.css">

<style>

.photogallery{
    display: flex;
    display: -webkit-flex;
    flex-wrap: wrap;
    -webkit-flex-wrap: wrap;
}
.photo {
    position: relative;
    width: 31%;
    height: auto;
    margin: 1%;
    overflow: hidden;
}

.photo:before {
    content: "";
    display: block;
    padding-top: 100%;
}
.inner {
    position: absolute;
    top: 0; left: 0;
    width: 100%;
    height: 100%;
}
.inner img{
    position: absolute;
    top: 50%;
    left: 50%;
    -webkit-transform: translate(-50%, -50%);
    -ms-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
    width: auto;
    height: 100%;
}

</style>
</head>
<body>
<header class="py-3 mb-4 border-bottom">
  <div class="b-example-divider"></div>
          <nav class="py-2 bg-light border-bottom">
            <div class="container d-flex flex-wrap">
              <ul class="nav me-auto">
                <li class="nav-item"><a href="index.html" class="nav-link link-dark px-2 active" aria-current="page">TOP</a></li>
                <li class="nav-item"><a href="account.html" class="nav-link link-dark px-2">MYPAGE</a></li>
                <li class="nav-item"><a href="#" class="nav-link link-dark px-2">CATEGORY</a></li>
                <li class="content_nav__item js-btn_popup js-content_nav__item" sj-popup>
                  <a ng-non-bindable v-pre>CATEGORY</a>
                  <div class="content_nav_categories js-btn_popup_inner">
                    <ul class="content_nav_categories__inner">
                      <li class="content_nav_categories__item">
                        <a ng-non-bindable v-pre href="/?category_id=593657623210d5654a000535">OUTER/JACKET</a>
                      </li>
                      <li class="content_nav_categories__item">
                        <a ng-non-bindable v-pre href="/?category_id=593652ac428f2d7bb600029d">ONEPIECE</a>
                      </li>
                    </ul>
                  </div>
                </li>

                <li class="nav-item"><a href="/Neutral/CartServlet" class="nav-link link-dark px-2">CART</a></li>
              </ul>
              <ul class="nav">
                <li class="nav-item"><a href="/Neutral/LoginServlet" class="nav-link link-dark px-2">Login</a></li>
                <li class="nav-item"><a href="#" class="nav-link link-dark px-2">Sign up</a></li>
              </ul>
            </div>
          </nav>
	<div class="container d-flex flex-wrap justify-content-center">
        <a href="/" class="d-flex align-items-center mb-3 mb-lg-0 me-lg-auto text-dark text-decoration-none">
          <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
          <span class="fs-4"> <h1 class="logo">Neutral</h1></span>
        </a>
        <form class="col-12 col-lg-auto mb-3 mb-lg-0">
          <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
        </form>
		</div>
</header>
<body>

<main>
<p>ファッションを楽しむすべての人に。</p><br>
<p>ユニセックスアイテムでもっと自由に。もっと楽しく。</p>



<!-- 商品リストから1行ずつデータを取得し表示 -->
<div class="photogallery">
	<% for (Product product: productList) { %>
	<div class="photo">
	    <div class="inner">
	    <a href="/Neutral/OrderServlet?id=<%=product.getProductId()%>">
	    	<img src="img/<%=product.getProductId()%>.jpg" alt="<%=product.getProductName()%>">
	    </a>
	    </div>
	</div>
	<%
	}
	%>
</div>


  <div class="card gedf-card shadow">

  </div>


<!--▼FOTTER-->

<div id="footer">
<ul id="footer-nav">
<li><a href="https://www.official-store.jp/kinggnugoods/user_data/privacy.php">個人情報の取り扱い</a></li>
<li>&nbsp;| <a href="https://www.official-store.jp/kinggnugoods/user_data/kiyaku.php">特定商取引法に基づく表記</a></li>
</ul>

<address>Copyright (c) 2022 lightvan co. ltd. All Rights Reserved. </address>
</div>

<!--▲FOTTER-->
</main>
</body>
</html>