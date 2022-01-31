<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>
<!-- HEADER -->
<jsp:include page="admin-header.jsp"></jsp:include>

<main>
<div class="container-scr">
  <div class="shadow p-3 mb-5 bg-body rounded" style="width:500px">
    <p strong>本当に削除しますか？</p><br>
    <a href="/Neutral/ProductCancelOkServlet"><button type="button" class="btn btn-outline-danger">はい、削除します</button></a><br>
  </div>
</div>
</main>
</body>
</html>