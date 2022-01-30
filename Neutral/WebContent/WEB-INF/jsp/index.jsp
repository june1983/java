<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.SkuDAO,model.SKU,java.util.ArrayList"%>
<%
    // リクエストスコープから商品情報を取得
    ArrayList<SKU> skuList = (ArrayList<SKU>)request.getAttribute("skuList");
%>

<!-- HEADER -->
<jsp:include page="admin-header.jsp"></jsp:include>

 <main>
	<div class="container-sl">
		<div class="shadow p-3 mb-5 bg-body rounded" style="width:1550px">
    		<div class="search">
     			<div class="me-2"><a href="/Neutral/RegisterProductServlet">
      				<button type="button" class="btn btn-primary me-2">商品を登録する</button></a>
     			</div>
     			<div class="me-2">
	            	<button class="btn btn-outline-primary dropdown-toggle me-2" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
	              	CATEGORY
	            	</button>
		            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
		              <li><a class="dropdown-item" href="/Neutral/WelcomeAdminServlet?id=Tシャツ・カットソー">TS:Tシャツ・カットソー</a></li>
		              <li><a class="dropdown-item" href="/Neutral/WelcomeAdminServlet?id=スウェット">SW:スウェット</a></li>
		              <li><a class="dropdown-item" href="/Neutral/WelcomeAdminServlet?id=コート">CO:コート</a></li>
		              <li><a class="dropdown-item" href="/Neutral/WelcomeAdminServlet?id=ダウン">DC:ダウン</a></li>
		              <li><a class="dropdown-item" href="/Neutral/WelcomeAdminServlet?id=ニット・セーター">KN:ニット・セーター</a></li>
		              <li><a class="dropdown-item" href="/Neutral/WelcomeAdminServlet?id=ジーンズ・カラージーンズ">JE:ジーンズ・カラージーンズ</a></li>
		              <li><a class="dropdown-item" href="/Neutral/WelcomeAdminServlet?id=ハーフパンツ">HP:ハーフパンツ</a></li>
		              <li><a class="dropdown-item" href="/Neutral/WelcomeAdminServlet?id=帽子・キャップ・ハット">CA:帽子・キャップ・ハット</a></li>
		              <li><a class="dropdown-item" href="/Neutral/WelcomeAdminServlet?id=マスク">MA:マスク</a></li>
		              <li><a class="dropdown-item" href="/Neutral/WelcomeAdminServlet?id=バッグ">BA:バッグ</a></li>
		            </ul>
          		</div>
          		<!-- <div class="example5"><button type="button" class="btn btn-outline-primary">日付</button></div> -->
				<div class="">
					<form class="d-flex" action="/Neutral/WelcomeAdminServlet" method="post">
						<input class="form-control me-2" type="search" name="query" placeholder="Search">
						<button class="btn btn-outline-primary" type="submit">Search</button>
					</form>
				</div>
      		</div>

		    <table id="foo-table" class="table table-bordered">
		    	<thead>
			        <tr>
						<th scope="col" class="example1">在庫ID</th>
						<th scope="col" class="example1">商品ID</th>
						<th scope="col" class="example5">商品名</th>
						<th scope="col" class="example1">カテゴリ</th>
						<th scope="col" class="example1">サイズ</th>
						<th scope="col" class="example4">単価</th>
						<th scope="col" class="example3">商品説明</th>
						<th scope="col" class="example2">商品属性</th>
						<th scope="col" class="example1">在庫数量</th>
						<th scope="col" class="example4"></th>
			        </tr>
		    	</thead>
				<tbody>
					<% for (SKU sku: skuList) { %>
					<tr>
					  <td class="example1"><%=sku.getSkuId()%></td>
					  <td class="example1"><%=sku.getProductId()%></td>
					  <td class="example5"><%=sku.getProductName()%></td>
					  <td class="example1"><%=sku.getCategoryId()%></td>
					  <td class="example1"><%=sku.getSize()%></td>
					  <td class="example4"><%=sku.getPrice()%></td>
					  <td class="example3"><%=sku.getDescription()%></td>
					  <td class="example2"><%=sku.getAttribute()%></td>
					  <td class="example1"><%=sku.getStock()%></td>
					  <td class="hensyubotton"><a href="/Neutral/ProductEditServlet?id=<%=sku.getSkuId()%>"><button type="button" class="btn btn-primary btn-sm">編集する</button></a></td>
					</tr>
					<% } %>
				</tbody>
		    </table>
	    	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	    	<script type="text/javascript" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
	    	<script type="text/javascript">
		      jQuery(function($){
		        // デフォルトの設定を変更
		        $.extend( $.fn.dataTable.defaults, {
		            language: {
		                url: "http://cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Japanese.json"
		            }
		        });
		
		        $("#foo-table").DataTable({
		            // 検索機能 無効
		            searching: false,
		            // 横スクロールバーを有効にする (scrollXはtrueかfalseで有効無効を切り替えます)
		            //scrollX: true,
		            // 縦スクロールバーを有効にする (scrollYは200, "200px"など「最大の高さ」を指定します)
		            //scrollY: 200
		        });
		    });
	    	</script>

		    <div class="col m2">
		        <a href="#"><button type="button" class="btn btn-outline-primary">管理画面TOPへ</button></a><br>
		    </div>
   		</div>
	</div>
</main>
</body>
</html>