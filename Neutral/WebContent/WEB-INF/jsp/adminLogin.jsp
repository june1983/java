<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
 <html>
 <head>
 <meta charset="UTF-8">
 <title>NEUTRAL/adminLogin</title>
 <link rel="preconnect" href="https://fonts.googleapis.com">
 <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
 <link href="https://fonts.googleapis.com/css2?family=Lobster&family=Nunito:ital,wght@1,200&family=Permanent+Marker&family=Titillium+Web:wght@200&family=Ubuntu:wght@300&display=swap" rel="stylesheet">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
 <link rel="stylesheet" href="css/headers.css">
 <link rel="stylesheet" href="css/common.css">
 <link rel="stylesheet" href="css/style-ad.css">
 </head>
 <body>
  <header class="py-3 mb-4 border-bottom">  
   <div class="b-example-divider bg-info">
     <div class="row align-items-center">
       <div class="col">
         <p class="logo2">Neutral</p>
       </div>
       <div class="col">
         <p class="title2">管理画面／ログインページ</p>
       </div>
       <div class="col">
         
       </div>
     </div>      
   </div>
  </header>

   <div class="container-scr">
       <div class="shadow p-3 mb-5 bg-body rounded" style="width:500px">
           <div class="input-group flex-nowrap">
               <span class="input-group-text bg-primary" id="addon-wrapping">ユーザーID</span>
               <input type="text" class="form-control" placeholder="mail address" aria-label="Username" aria-describedby="addon-wrapping">
               </div><br>
             <div class="input-group flex-nowrap">
               <span class="input-group-text bg-primary" id="addon-wrapping">パスワード</span>
               <input type="text" class="form-control" placeholder="password" aria-label="Username" aria-describedby="addon-wrapping">
               
             </div><br>
         <button type="button" class="btn btn-outline-primary">ログイン</button><br>         
       </div>  
     </div>

 </body>