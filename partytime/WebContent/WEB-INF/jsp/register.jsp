<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<%
//セッションスコープからインスタンスを取得!
User u = (User) session.getAttribute("User");
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
	background-size: 400% 400%;
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

input {
}

.col-6 {
	margin: auto;
}
</style>
</head>
<body>
<main class="container flex-fill py-4 my-4 border shadow p-3 mb-5 bg-white rounded" style="max-width:600px;">
<h1 class="Ribeye">PARTY TIME</h1>
<p>名前を入力してください</p>

<form action="/sample/App" method="post">
	<div class="form-group">
		<%
		int num = u.number;
		for(int i=1; i <= num; i++) {
		%>
		<div class="input-group mb-3 col-6">
		  <input type="text" name="name<%= i %>" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" required>
		</div>
		<% } %>
		<input type="submit" class="btn btn-outline-secondary" value="登録する">
	</div>
</form>
</main>
</body>
</html>