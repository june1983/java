<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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