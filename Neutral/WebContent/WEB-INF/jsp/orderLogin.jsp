<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.CartDAO,model.Cart,java.util.ArrayList"%>
<%
// リクエストスコープから書籍リストを取得
ArrayList<Cart> cartList = (ArrayList<Cart>)request.getAttribute("cartList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
注文画面<br>

<% for (Cart cart: cartList) { %>
商品ID：<%=cart.getProductId()%>
商品名：<%=cart.getOrderProduct()%>
価格：<%=cart.getOrderPrice()%>
個数：<%=cart.getOrderNumber()%>
小計：<%=cart.getSubtotal()%>
<br>

<%
}
%>
</body>
</html>