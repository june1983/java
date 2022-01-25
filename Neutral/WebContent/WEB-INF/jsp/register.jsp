<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	//セッションスコープからインスタンスを取得
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NEUTRAL/会員登録</title>
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
<!-- HEADER -->
<jsp:include page="header.jsp"></jsp:include>

<main>
    <p>ファッションを楽しむすべての人に。</p><br>
    <p>ユニセックスアイテムでもっと自由に。もっと楽しく。</p>

    <div class="container-scr">
      <form class="shadow p-3 mb-5 bg-body rounded" action="/Neutral/RegisterServlet" method="post">
      <p strong>会員登録</p>
      <div class="input-group flex-nowrap">
        <span class="input-group-text bg-dark" id="addon-wrapping">名 前</span>
        <input type="text" class="form-control"  name="userName"  placeholder="Username" required>
      </div><br>
      <div class="input-group flex-nowrap">
        <span class="input-group-text bg-dark" id="addon-wrapping">住 所</span>
        <input type="text" class="form-control"  name="adress"  placeholder="Address"  required>
      </div><br>
      <div class="input-group flex-nowrap">
        <span class="input-group-text bg-dark" id="addon-wrapping">メール</span>
        <input type="text" class="form-control"  name="email"  placeholder="E-mail"  required>
      </div><br>
      <div class="input-group flex-nowrap">
        <span class="input-group-text bg-dark" id="addon-wrapping">TEL</span>
        <input type="text" class="form-control"  name="tel"  placeholder="Tel"  required>
      </div><br>            
      <div class="input-group flex-nowrap">
        <span class="input-group-text bg-dark" id="addon-wrapping">パスワード</span>
        <input type="text" class="form-control"  name="pass"  placeholder="Password"  required>
      </div><br>            
      <div class="input-group flex-nowrap">
        <span class="input-group-text bg-dark" id="addon-wrapping">CARD</span>
        <input type="text" class="form-control"  name="card"  placeholder="CARD"  required>
      </div><br>

        <button type="submit" class="btn btn-dark">登録する</button><br>
      </form>
    </div>

</main>
<!-- FOOTER -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>