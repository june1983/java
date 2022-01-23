<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.ProductDAO,model.Product,java.util.ArrayList"%>
<%
//セッションスコープから商品情報を取得
Product product = (Product) session.getAttribute("Product");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NEUTRAL/order</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Lobster&family=Nunito:ital,wght@1,200&family=Permanent+Marker&family=Titillium+Web:wght@200&family=Ubuntu:wght@300&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="js/item-image.js"></script>
<link rel="stylesheet" href="css/headers.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/item-image.scss">
</head>
<body>
<header class="py-3 mb-4 border-bottom">  
	<nav class="py-2 bg-white border-bottom">
		<div class="container d-flex flex-wrap">
			<ul class="nav me-auto">
				<li class="nav-item"><a href="/Neutral/WelcomeServlet" class="nav-link link-dark px-2 active" aria-current="page">TOP</a></li>
				<li class="nav-item"><a href="/Neutral/AccountServlet" class="nav-link link-dark px-2">MYPAGE</a></li>
				<li class="dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
				  CATEGORY
				</a>
					<ul class="dropdown-menu dropdown-menu-secondary" aria-labelledby="navbarDarkDropdownMenuLink">
						<li><a class="dropdown-item" href="#">ＴＳ:　Tシャツ・カットソー</a></li>
						<li><a class="dropdown-item" href="#">ＳＷ:　スウェット</a></li>
						<li><a class="dropdown-item" href="#">ＣＯ:　コート</a></li>
						<li><a class="dropdown-item" href="#">ＤＣ:　ダウン</a></li>
						<li><a class="dropdown-item" href="#">ＫＮ:　ニット・セーター</a></li>
						<li><a class="dropdown-item" href="#">ＪＥ:　ジーンズ・カラージーンズ</a></li>
						<li><a class="dropdown-item" href="#">ＨＰ:　ハーフパンツ</a></li>
						<li><a class="dropdown-item" href="#">ＣＡ:　帽子・キャップ・ハット</a></li>
						<li><a class="dropdown-item" href="#">ＭＡ:　マスク</a></li>
						<li><a class="dropdown-item" href="#">ＢＡ:　バッグ</a></li>
					</ul>
				</li>
				<li class="nav-item"><a href="/Neutral/CartServlet" class="nav-link link-dark px-2">CART</a></li>
			 </ul>
			<ul class="nav">
				<li class="nav-item"><a href="/Neutral/LoginServlet" class="nav-link link-dark px-2">ログイン</a></li>
			    <li class="nav-item"><a href="/Neutral/AdminLoginServlet" class="nav-link link-dark px-2">お店を管理する</a></li>
			</ul>
		</div>
	</nav>  
	<div class="container d-flex flex-wrap justify-content-center">
		<a href="/Neutral/WelcomeServlet" class="d-flex align-items-center mb-3 mb-lg-0 me-lg-auto text-dark text-decoration-none">
			<svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
			<span class="fs-4"> <h1 class="logo">Neutral</h1></span>
		</a>
		<form class="col-12 col-lg-auto mb-3 mb-lg-0">
			<div class="search_box">
				<input type="text" placeholder="search...">
			</div>
		</form>
	</div>
</header>
<body>
  
<main>
  <p>ファッションを楽しむすべての人に。</p><br>
  <p>ユニセックスアイテムでもっと自由に。もっと楽しく。</p>

  <div class="container-s">
    <div class="row g-2">
      <div class="col-6">
        <div class="shadow p-3 mb-5 bg-body rounded">item-image
          <div id="content">
            <div id="featured_img">
            <img id="img" src="img/<%=product.getProductId()%>.jpg"alt="<%=product.getProductName()%>">
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

      <div class="col-6">
        <div class="shadow p-3 mb-5 bg-body rounded">
          <p strong>商品ID：<%=product.getProductId()%></p>
          <p strong>商品名：<%=product.getProductName()%></p>
          <p strong>価格：<%=product.getPrice()%></p>

        ＜商品説明＞<br><%=product.getDescription()%><br>

        <form action="/Neutral/CartServlet" method="post">
          サイズ：
          <select class="form-select-s" aria-label="Default select example">            
            <option selected>サイズを選択してください</option>
            <option value="XS">XS</option>
            <option value="S">S</option>
            <option value="M">M</option>
            <option value="L">L</option>
            <option value="XL">XL</option>
            <option value="FREE">FREE</option>
          </select><br><br>            
          個数：
          <input type="number" name="orderNumber" value="1">
          <!--
          <select class="form-select-s" aria-label="Default select example">
            <option selected>個数を選択してください</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
          </select><br><br><br>
		  -->
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