<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.CartDAO,model.Cart,java.util.ArrayList"%>
<%
//リクエストスコープからカート情報を取得
// Cart cart = (Cart) session.getAttribute("cart");
// セッションスコープからカート情報を取得
ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Neutral | カートの確認</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Lobster&family=Nunito:ital,wght@1,200&family=Permanent+Marker&family=Titillium+Web:wght@200&family=Ubuntu:wght@300&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="js/item-image.js"></script>
<link rel="shortcut icon" href="favicon.ico"/>
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

<main>
  <p>ファッションを楽しむすべての人に。</p><br>
  <p>ユニセックスアイテムでもっと自由に。もっと楽しく。</p>

  <div class="container-sc">
    <div class="shadow p-3 mb-5 bg-body rounded">
	    <form action="/orderSubmit" method="post">
		    <table class="table table-bordered border-secondary">
		      <thead>
		        <tr>
		          <th scope="col" style="width: 50px"></th>
		          <th scope="col" style="width: 150px" class="example2">商品ID</th>
		          <th scope="col" style="width: 200px" class="example2">商品名</th>
		          <th scope="col" style="width: 100px" class="example2">サイズ</th>
		          <th scope="col" style="width: 90px" class="example2">個数</th>
		          <th scope="col" style="width: 120px" class="example2">単価</th>
		          <th scope="col" style="width: 120px" class="example2">小計</th>
		          <th scope="col" style="width: 120px"></th>
		        </tr>
		      </thead>
		      <tbody>

			    <% if (cartList != null) { %>
			    	<% int totalPrice = 0; %>
		        	<%  for (Cart cart: cartList) { %>
			        <tr>
			          <th scope="row" style="width: 50px" class="checkbox"><div>
			            <input class="form-check-input" type="checkbox" name="checked<%=cart.getCartId()%>" value="<%=cart.getCartId()%>" aria-label="..." checked>
			          </div></th>
			          <td style="width: 100px"><%=cart.getProductId()%></td>
			          <td style="width: 200px"><%=cart.getOrderProduct()%></td>
			          <td style="width: 100px" class="example2"><%=cart.getOrderSize()%></td>
			          <td style="width: 120px" class="example1"><input class="kosuu" type="number" name="orderNumber<%=cart.getCartId()%>" min="1" value="<%=cart.getOrderNumber()%>">個</td>
			          <td style="width: 120px" class="example1"><%=cart.getOrderPrice()%>円</td>
			          <td style="width: 120px" class="example1"><%=cart.getSubtotal()%>円</td>
			          <td style="width: 120px" class="example2"><a href="/cartDelete?id=<%=cart.getCartId()%>"><button type="button" class="btn btn-outline-danger">削除</button></a></td>
			        </tr>
			        <% totalPrice += cart.getSubtotal(); %>
					<% } %>
			      </tbody>
			      <tfoot>
			        <tr>
			          <th scope="col" style="width: 50px"></th>
			          <th scope="col" style="width: 100px"></th>
			          <th scope="col" style="width: 200px"></th>
			          <th scope="col" style="width: 100px"></th>
			          <th scope="col" style="width: 120px"></th>
			          <th scope="col" style="width: 120px" class="example1">合計金額</th>
			          <th scope="col" style="width: 120px" class="example1"><%= totalPrice %>円</th>
			          <th scope="col" style="width: 120px" class="example2"></th>
			        </tr>
			      </tfoot>
			     	<% } else { %>
			        <tr>
			          <th scope="row" style="width: 50px" class="checkbox"><div>
			            <input class="form-check-input" type="checkbox" id="checkboxNoLabel" value="" aria-label="...">
			          </div></th>
			          <td style="width: 100px"></td>
			          <td style="width: 200px"></td>
			          <td style="width: 100px"></td>
			          <td style="width: 120px" class="example1"><input class="kosuu" value=""> 個</td>
			          <td style="width: 120px" class="example1"> 円</td>
			          <td style="width: 120px" class="example1"> 円</td>
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
			        <% } %>
		    </table>
		    <p><span class="label label-danger">${message}</span></p>

		    <p>ご購入の商品にチェックを入れてください。</p>
		    <p>上記内容でよろしければご注文を確定するボタンをクリックしてください。</p>
		    <div><br>
		    	<a href="/"><button type="button" class="btn btn-outline-dark">買い物を続ける</button></a>
		    	<%// if (cart != null) { %>
		        <button type="submit" class="btn btn-dark <% System.out.println("off");%>">ご注文内容を確定する</button>
		        <%// } %>
		        <br><br>
		    </div>
	    </form>
    </div>
  </div>
</main>
<!-- FOOTER -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>