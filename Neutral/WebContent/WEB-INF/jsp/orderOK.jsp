<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Cart,java.util.ArrayList"%>
<%
// セッションスコープからカート情報を取得
Cart cart = (Cart) session.getAttribute("cart");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NEUTRAL/ご注文完了</title>
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

    <div class="container-sc">
      <div class="shadow p-3 mb-5 bg-body rounded">
      <form action="  " method="post">
      <table class="table table-bordered border-secondary">
        <thead>
          <tr>
            <th scope="col" style="width: 50px"></th>
            <th scope="col" style="width: 150px">商品ID</th>
            <th scope="col" style="width: 200px">商品名</th>
            <th scope="col" style="width: 100px">サイズ</th>
            <th scope="col" style="width: 90px">個数</th>
            <th scope="col" style="width: 120px">単価</th>
            <th scope="col" style="width: 120px">小計</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row" style="width: 50px"class="checkbox">
              <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle-fill" viewBox="0 0 16 16">
                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
              </svg></th>
              <td style="width: 100px"><%=cart.getProductId()%></td>
              <td style="width: 200px"><%=cart.getOrderProduct()%></td>
              <td style="width: 100px"><%=cart.getOrderSize()%></td>
              <td style="width: 120px"><input class="kosuu" value="<%=cart.getOrderNumber()%>">個</td>
              <td style="width: 120px" class="example1"><%=cart.getOrderPrice()%>円</td>
              <td style="width: 120px" class="example1"><%=cart.getSubtotal()%>円</td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <th scope="col" style="width: 50px"></th>
            <th scope="col" style="width: 100px"></th>
            <th scope="col" style="width: 200px"></th>
            <th scope="col" style="width: 100px"></th>
            <th scope="col" style="width: 120px"></th>
            <th scope="col" style="width: 120px" class="example1">合計金額</th>
            <th scope="col" style="width: 120px" class="example1">円</th>
          </tr>
        </tfoot>
      </table>
      </form>

      <p strong>ご注文ありがとうございました！</p>
      <p>上記内容でご注文が確定しました。</p>
      <div><br>
      <a href="/Neutral/WelcomeServlet"><button type="button" class="btn btn-outline-dark">TOPへ戻る</button></a>
      </div>
      </div>
    </div>

</main>
<!-- FOOTER -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>