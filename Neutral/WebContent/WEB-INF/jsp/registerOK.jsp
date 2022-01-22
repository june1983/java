<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Account" %>
<% 
	// セッションスコープからインスタンスを取得
	Account a = (Account) session.getAttribute("registerServlet");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NEUTRAL/会員登録完了</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Lobster&family=Nunito:ital,wght@1,200&family=Permanent+Marker&family=Titillium+Web:wght@200&family=Ubuntu:wght@300&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="js/item-image.js"></script>
<link rel="stylesheet" href="css/headers.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
  <header class="py-3 mb-4 border-bottom">  
            <nav class="py-2 bg-white border-bottom">
              <div class="container d-flex flex-wrap">
                <ul class="nav me-auto">
                  <li class="nav-item"><a href="index.html" class="nav-link link-dark px-2 active" aria-current="page">TOP</a></li>
                  <li class="nav-item"><a href="account.html" class="nav-link link-dark px-2">MYPAGE</a></li>
                  <li class="dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      CATEGORY
                    </a>
                    <ul class="dropdown-menu dropdown-menu-light" aria-labelledby="navbarDarkDropdownMenuLink">
                      <li><a class="dropdown-item" href="#">TS:Tシャツ・カットソー</a></li>
                      <li><a class="dropdown-item" href="#">SW:スウェット</a></li>
                      <li><a class="dropdown-item" href="#">CO:コート</a></li>
                      <li><a class="dropdown-item" href="#">DC:ダウン</a></li>
                      <li><a class="dropdown-item" href="#">KN:ニット・セーター</a></li>
                      <li><a class="dropdown-item" href="#">JE:ジーンズ・カラージーンズ</a></li>
                      <li><a class="dropdown-item" href="#">HP:ハーフパンツ</a></li>
                      <li><a class="dropdown-item" href="#">CA:帽子・キャップ・ハット</a></li>
                      <li><a class="dropdown-item" href="#">MA:マスク</a></li>
                      <li><a class="dropdown-item" href="#">BA:バッグ</a></li>
                    </ul>
                  </li>
                  <li class="nav-item"><a href="cart.html" class="nav-link link-dark px-2">CART</a></li>
                </ul>
                <ul class="nav">
                  <li class="nav-item"><a href="login.html" class="nav-link link-dark px-2">Login</a></li>
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
                  <div class="search_box">
                    <input type="text" placeholder="search...">
                  </div>
                </form>
     </div>
  </header>
   
<main>
    <p>ファッションを楽しむすべての人に。</p><br>
    <p>ユニセックスアイテムでもっと自由に。もっと楽しく。</p>

    <div class="container-scr">
      <div class="shadow p-3 mb-5 bg-body rounded">
      <p strong>会員登録が完了しました！</p><br>
       <a href="/Neutral/WelcomeServlet"><button type="button" class="btn btn-outline-dark">買い物を続ける</button></a><br>         
      </div>  
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