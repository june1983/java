<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="model.*" %>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="filename" content="">
<title>test</title>


<style>
body {
	text-align: center;
	background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
	background-size: 400% 400%;
	animation: gradient 15s ease infinite;
	height: 100vh;
}

@keyframes gradient {
	0% {
		background-position: 0% 50%;
	}
	50% {
		background-position: 100% 50%;
	}
	100% {
		background-position: 0% 50%;
	}
}

.Ribeye {
	font-family: 'Ribeye', cursive;
	margin-bottom: 20px;
}

#box {
	/*
	margin: 0 auto;
	width : 300px;
	height: 300px;
	line-height: 300px;
	text-align : center;
	border: none;
	border-radius: 50%;
	*/
}

.css1{
	font-size: 100px;
	color: white;
}
</style>

<script>
onload = function(){

	//変数
	var max = 0;
	var count = 5;

	//要素
	var box = document.getElementById("box");
	var msg = document.getElementById("msg");

	msg.innerHTML = "<p>ARE YOU READY?</p>";

	var timerID = setInterval( function(){

	if (count == max) {
		clearInterval(timerID);
		window.location.href = '/sample/App?action=done'; // 通常の遷移
		//box.classList.remove("css1");
		//box.classList.add("css2");
	} else {
		msg.innerHTML = "<p>" + count + "</p>";
		count--;
	}

	}, 1000);

}
</script>
</head>
<body>
<div id="box" class="css1">
<div id="msg" class="Ribeye"></div>
</div>
</body>
</html>