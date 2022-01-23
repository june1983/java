<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NEUTRAL/login</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Lobster&family=Nunito:ital,wght@1,200&family=Permanent+Marker&family=Titillium+Web:wght@200&family=Ubuntu:wght@300&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/headers.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/style.css">
<style>
.label-danger {
color:red;
}
</style>
</head>
<body>
<!-- HEADER -->
<jsp:include page="header.jsp"></jsp:include>

<span class="label label-danger">${message}</span>
<form action="/Neutral/LoginServlet" method="post">
	<div class="container-scr">
	  <div class="p-3 border bg-light">
	
	  <div class="input-group flex-nowrap">
	    <span class="input-group-text bg-dark" id="addon-wrapping">メールアドレス</span>
	    <input type="text" class="form-control" placeholder="mail address" aria-label="Username" aria-describedby="addon-wrapping" name="email">
	    </div><br>
	  <div class="input-group flex-nowrap">
	    <span class="input-group-text bg-dark" id="addon-wrapping">パスワード</span>
	    <input type="password" class="form-control" placeholder="password" aria-label="Username" aria-describedby="addon-wrapping" name="pass">
	  </div><br>
	  <button type="submit" class="btn btn-dark">ログイン</button><br>
	  </div>
	</div>
</form>

<!-- FOOTER -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>