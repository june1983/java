<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NEUTRAL管理画面/トップページ</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Lobster&family=Nunito:ital,wght@1,200&family=Permanent+Marker&family=Titillium+Web:wght@200&family=Ubuntu:wght@300&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="js/item-image.js"></script>
<link rel="stylesheet" href="css/headers.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/style-ad.css">
<link rel="stylesheet" href="css/style-ad2.css">
</head>
<body>
<!-- HEADER -->
<jsp:include page="admin-header.jsp"></jsp:include>

<main>
<div class="container-sl">
	<div class="shadow p-3 mb-5 bg-body rounded" style="width:950px">
		<div>
			<p strong>以下の内容で登録情報を変更します。よろしいですか？</p>
		</div>
		<table class="table table-bordered">
		  <thead>
		    <tr>
		      <th scope="col" class="example2">商品ID</th>
		      <th scope="col" class="example2">商品名</th>
		      <th scope="col" class="fileulimg">写真</th>
		      <th scope="col" class="example2">カテゴリ</th>
		      <th scope="col" class="example2">サイズ</th>
		      <th scope="col" class="example2">単価</th>
		      <th scope="col" class="example2">商品説明</th>
		      <th scope="col" class="example2">在庫数量</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <th scope="row"></th>
		      <td class="example2"></td>
		      <td class="fileulimg"></td>
		      <td class="example2"></td>
		      <td class="example2"></td>
		      <td class="example2"></td>
		      <td class="example2"></td>
		      <td class="example2"></td>
		    </tr>
		  </tbody>
		</table>
		<div>
		 <a href="/Neutral/ProductEditOkServlet"><button type="button" class="btn btn-primary">はい、変更します</button></a>
		 <a href="/Neutral/ProductEditServlet"><button type="button" class="btn btn-outline-primary">戻る</button></a>
		</div> 
	</div>  
</div>

</main> 
</body>
</html>