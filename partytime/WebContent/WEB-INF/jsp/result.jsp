<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="model.*"%>
<%
shuffledUser su = (shuffledUser) session.getAttribute("shuffledUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Ribeye&display=swap" rel="stylesheet">
<title>PARTY TIME</title>
<style>
body {
	text-align: center;
	background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
	background-size: 500% 500%;
	animation: gradient 15s ease infinite;
	height: 100vh;
}

@keyframes gradient {
	0% {
		background-position: 0% 50%;
	}
	50% {
		background-position: 100% 50%;
	}
	100% {
		background-position: 0% 50%;
	}
}

.Ribeye {
	font-family: 'Ribeye', cursive;
	margin-bottom: 20px;
}

.col {
	padding: 0;
}

span {
	font-size: 30px;
}

.fade1{
    animation: fadeIn 5s 1 normal;
}
@keyframes fadeIn { /*animation-nameで設定した値を書く*/
    0% {opacity: 0} /*アニメーション開始時は不透明度0%*/
    100% {opacity: 1} /*アニメーション終了時は不透明度100%*/
}

</style>
</head>
<body>
<main class="container flex-fill py-4 my-4 border shadow p-3 mb-5 bg-white rounded fade1" style="max-width:600px;">
<h1 class="Ribeye">PARTY TIME</h1>
<%
int num = su.giverFix.size();
for(int i=0; i < num; i++) { %>
<p style="font: bold"><%= i+1 %>組目</p>
<div class="row">
<p class="col"><span><%= su.giverFix.get(i) %></span> さんが、<span><%= su.takerFix.get(i) %></span> さんに渡します</p>
</div>
<br>
<% } %>
<%
   //セッションスコープからインスタンスを削除
   session.removeAttribute("shuffledUser");
%>
<p><a href="/sample/App" class="btn btn-outline-secondary">TOPへ戻る</a></p>
</main>
</body>
</html>