<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.SkuDAO,model.SKU,java.util.ArrayList"%>
<%
    // リクエストスコープから商品情報を取得
    ArrayList<SKU> skuList = (ArrayList<SKU>)session.getAttribute("skuList");
%>

<!-- HEADER -->
<jsp:include page="admin-header.jsp"></jsp:include>

 <main>
  <div class="container-sl">
  <div class="shadow p-3 mb-5 bg-body rounded" style="width:1100px">
    <nav class="navbar navbar-white">
      <div class="container-fluid">
        <form class="d-flex">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-primary" type="submit">Search</button>
        </form>
      </div>
    </nav>
    <nav class="navbar navbar-white">
      <div class="container-fluid">
        <form class="d-flex">
          <div class="dropdown">
            <button class="btn btn-outline-primary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
              CATEGORY
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
              <li><a class="dropdown-item" href="#">TS:Tシャツ・カットソー</a></li>
              <li><a class="dropdown-item" href="#">SW:スウェット</a></li>
              <li><a class="dropdown-item" href="#">CO:コート</a></li>
              <li><a class="dropdown-item" href="#">DC:ダウン</a></li>
              <li><a class="dropdown-item" href="#">KN:ニット・セーター</a></li>
              <li><a class="dropdown-item" href="#">JE:ジーンズ・カラージーンズ</a></li>
              <li><a class="dropdown-item" href="#">HP:ハーフパンツ</a></li>
              <li><a class="dropdown-item" href="#">CA:帽子・キャップ・ハット</a></li>
              <li><a class="dropdown-item" href="#">MA:マスク</a></li>
              <li><a class="dropdown-item" href="#">BA:バッグ</a></li>
            </ul>
          </div>
          <!-- <div class="example5"><button type="button" class="btn btn-outline-primary">日付</button></div> -->
          <a href="/Neutral/RegisterProductServlet"><div class="example5"><button type="button" class="btn btn-primary">商品を登録する</button></a></div>
        </form>
      </div>
    </nav>

    <table class="table table-bordered">
      <thead>
        <tr>
          <th scope="col" class="example2">在庫ID</th>
          <th scope="col" class="example2">商品ID</th>
          <th scope="col" class="example2">商品名</th>
          <th scope="col" class="example2">カテゴリ</th>
          <th scope="col" class="example2">サイズ</th>
          <th scope="col" class="example2">単価</th>
          <th scope="col" class="example2">商品説明</th>
          <th scope="col" class="example2">商品属性</th>
          <th scope="col" class="example2">在庫数量</th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody>
      	<% for (SKU sku: skuList) { %>
        <tr>
          <td class="example2"><%=sku.getSkuId()%></td>
          <td class="example2"><%=sku.getProductId()%></td>
          <td class="example2"><%=sku.getProductName()%></td>
          <td class="example2"><%=sku.getCategoryId()%></td>
          <td class="example2"><%=sku.getSize()%></td>
          <td class="example2"><%=sku.getPrice()%></td>
          <td class="example2"><%=sku.getDescription()%></td>
          <td class="example2"><%=sku.getAttribute()%></td>
          <td class="example2"><%=sku.getStock()%></td>
          <td class="hensyubotton"><a href="/Neutral/ProductEditServlet?id=<%=sku.getSkuId()%>"><button type="button" class="btn btn-primary btn-sm">編集する</button></a></td>
        </tr>
        <% } %>

      </tbody>
    </table>

      <!-- ページング用div -->
      <div></div>


        <a href="#"><button type="button" class="btn btn-outline-primary">管理画面TOPへ</button></a><br>
      </div>
    </div>

<!--file up ボツスクリプト
<script>
$('input').on('change', function () {
    var file = $(this).prop('files')[0];
    $('#fileup').text(file.name);
});
</script>
-->

</main>
</body>
</html>