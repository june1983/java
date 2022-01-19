<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.ProductDAO,model.Product,java.util.ArrayList"%>
<%
    // リクエストスコープから商品情報を取得
    Product product = (Product) request.getAttribute("product");
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

<p><%=product.getDescription()%></p>

</body>
</html>