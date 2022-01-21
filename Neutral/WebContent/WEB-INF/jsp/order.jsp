<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.ProductDAO,model.Product,java.util.ArrayList"%>
<%
    //セッションスコープから商品情報を取得
    Product product = (Product) session.getAttribute("Product");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

商品ID：<%=product.getProductId()%>
商品名：<%=product.getProductName()%>
価格：<%=product.getPrice()%>
<img src="img/<%=product.getProductId()%>.jpg" alt="<%=product.getProductName()%>">

<form action="/Neutral/CartServlet" method="post">

<input type="number" name="orderNumber" value="1">

	<select name="orderSize" size="1">
		<option value="XS">XS</option>
		<option value="S">S</option>
		<option value="M">M</option>
		<option value="L">L</option>
		<option value="XL">XL</option>
		<option value="FREE">FREE</option>
	</select>
	
<input type="submit" value="カートに入れる">

</form>
<p><%=product.getDescription()%></p>

</body>
</html>