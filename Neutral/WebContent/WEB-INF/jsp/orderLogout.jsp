<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Cart,java.util.ArrayList"%>
<%
    // セッションスコープからカート情報を取得
    Cart c = (Cart) session.getAttribute("cart");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
商品ID：<%=c.getProductId()%>
商品名：<%=c.getOrderProduct()%>
価格：<%=c.getOrderPrice()%>
個数：<%=c.getOrderNumber()%>
サイズ：<%=c.getOrderSize()%>
小計：<%=c.getSubtotal()%>

<a href="/Neutral/WelcomeServlet">TOPに戻る</a>
<a href="/Neutral/RegisterServlet">新規会員登録</a>
</body>
</html>