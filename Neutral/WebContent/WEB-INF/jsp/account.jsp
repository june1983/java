<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Account"  %>
<%
// セッションスコープからインスタンスを取得
Account account = (Account) session.getAttribute("Account");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NEUTRAL/会員情報</title>

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
      <div class="shadow p-3 mb-5 bg-body rounded">
      <p strong>会員登録情報</p>
      <form action="  " method="post">
        <table class="table table-bordered border-secondary">
             <tr>
              <th scope="col" style="width: 200px">名前</th>
              <th scope="col" style="width: 300px"><c:out value="${sessionScope.Account.getUserName() }"/></th>
            </tr>
            <tr>
              <th scope="col" style="width: 200px">住所</th>
              <th scope="col" style="width: 300px"><c:out value="${sessionScope.Account.getAdress()}"/></th>
            </tr>
            <tr>
              <th scope="col" style="width: 200px">メール</th>
              <th scope="col" style="width: 300px"><c:out value="${sessionScope.Account.getEmail()}"/></th>
            </tr>
            <tr>
              <th scope="col" style="width: 200px">パスワード</th>
              <th scope="col" style="width: 300px"><c:out value="${sessionScope.Account.getPass()}"/></th>
            </tr>
            <tr>
              <th scope="col" style="width: 200px">TEL</th>
              <th scope="col" style="width: 300px"><c:out value="${sessionScope.Account.getTel()}"/></th>
            </tr>
            <tr>
              <th scope="col" style="width: 200px">CARD</th>
              <th scope="col" style="width: 300px"><c:out value="${sessionScope.Account.getCard()}"/></th>
            </tr>
        </table>
        </form>
<br>
       <a href="/Neutral/CancelServlet"> <button type="button" class="btn btn-outline-dark">退会する</button></a>
        <a href="/Neutral/AccountEditServlet"><button type="button" class="btn btn-dark">編集する</button></a><br>
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