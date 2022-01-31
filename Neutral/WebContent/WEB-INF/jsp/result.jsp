<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name=(String)request.getAttribute("name");
	String word=(String)request.getAttribute("word");
	String filename=(String)request.getAttribute("filename");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileupload</title>
</head>
<body>
<p>名前:<%=name %></p>
<p>好きな言葉:<%=word %></p>
<p>好きな写真:<br><img src="img/<%=filename %>"></p>
</body>
</html>