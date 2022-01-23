<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NEUTRAL管理画面/商品情報編集ページ</title>
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
<div class="container-scr">
	<form action="/Neutral/ProductEditServlet" method="post">
		<div class="shadow p-3 mb-5 bg-body rounded" style="width:500px">
		<p strong>商品ID：</p><br>
		<div class="input-group flex-nowrap">
		  <span class="input-group-text bg-info" id="addon-wrapping">商品名</span>
		  <input type="text" class="form-control" placeholder="item-Name" aria-label="Username" aria-describedby="addon-wrapping">
		</div><br>
		<div class="input-group flex-nowrap">
		  <span class="input-group-text bg-info" id="addon-wrapping">写真</span>
		  <input type="file" class="form-control" placeholder="img" aria-label="Username" aria-describedby="addon-wrapping"name="example" accept="image/jpeg, image/png">
		</div><br>
		<div class="input-group mb-3">
		  <label class="input-group-text bg-info" for="inputGroupSelect01">カテゴリ</label>
		  <select class="form-select" id="inputGroupSelect01">
		    <option selected>選択してください</option>
		    <option selected>選択してください</option>
		    <option value="1">ＴＳ:　Tシャツ・カットソー</option>
		    <option value="2">ＳＷ:　スウェット</option>
		    <option value="3">ＣＯ:　コート</option>
		    <option value="3">ＤＣ:　ダウン</option>
		    <option value="3">ＫＮ:　ニット・セーター</option>
		    <option value="3">ＪＥ:　ジーンズ・カラージーンズ</option>
		    <option value="3">ＨＰ:　ハーフパンツ</option>
		    <option value="3">ＣＡ:　帽子・キャップ・ハット</option>
		    <option value="3">ＭＡ:　マスク</option>
		    <option value="3">ＢＡ:　バッグ</option>
		  </select>
		</div>
		<div class="input-group flex-nowrap">
		  <span class="input-group-text bg-info" id="addon-wrapping">サイズ</span>
		  <input type="text" class="form-control" placeholder="Size" aria-label="Username" aria-describedby="addon-wrapping">
		</div><br>
		<div class="input-group flex-nowrap">
		  <span class="input-group-text bg-info" id="addon-wrapping">単価</span>
		  <input type="text" class="form-control" placeholder="Price" aria-label="Username" aria-describedby="addon-wrapping">
		</div><br>      
		<div class="input-group flex-nowrap">
		  <span class="input-group-text bg-info" id="addon-wrapping">商品説明</span>
		  <input type="text" class="form-control" placeholder="  " aria-label="Username" aria-describedby="addon-wrapping">
		</div><br>      
		<div class="input-group flex-nowrap">
		  <span class="input-group-text bg-info" id="addon-wrapping">在庫数量</span>
		  <input type="text" class="form-control" placeholder="  " aria-label="Username" aria-describedby="addon-wrapping">
		</div><br>      
		  <button type="submit" class="btn btn-primary">変更する</button>
		  <a href="/Neutral/ProductCancelServlet"><button type="button" class="btn btn-outline-danger">商品情報を削除する</button><br>       
		</div>  
	</form>
</div>

</main> 
</body>
</html>