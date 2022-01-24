<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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