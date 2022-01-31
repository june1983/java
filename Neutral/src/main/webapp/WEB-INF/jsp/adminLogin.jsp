<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- HEADER -->
<jsp:include page="admin-header.jsp"></jsp:include>

<main>
<span class="label label-danger">${message}</span>
<form action="/Neutral/AdminLoginServlet" method="post">
   <div class="container-scr">
       <div class="shadow p-3 mb-5 bg-body rounded" style="width:500px">
           <div class="input-group flex-nowrap">
               <span class="input-group-text bg-primary" id="addon-wrapping">ユーザーID</span>
               <input type="text"  name="email" class="form-control" placeholder="mail address" aria-label="Username" aria-describedby="addon-wrapping">
               </div><br>
             <div class="input-group flex-nowrap">
               <span class="input-group-text bg-primary" id="addon-wrapping">パスワード</span>
               <input type="text"  name="pass" class="form-control" placeholder="password" aria-label="Username" aria-describedby="addon-wrapping">

             </div><br>
         <button type="submit" class="btn btn-outline-primary">ログイン</button><br>
       </div>
     </div>
</form>
</main>
 </body>