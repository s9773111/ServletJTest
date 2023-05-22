<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax Demo Page</title>
</head>
<body>
	<h1>
		This is an ajax demo at
		<!-- 8 -->
		<script type="text/javascript">
			//alert("test");
			document.write(new Date(new Date().getTime()).toLocaleString());
		</script>
	</h1>
	
	<!-- 13 -->
	<div id="showArea">
	
	</div>
	
	<!-- 測試輸入欄位 -->
	<div id="checksno">
		<form action="AjaxServlet2">
			<input type="text" id="name" name="number" value="請輸入帳號" onblur="doCheck()"/>
			<span id="nametip"></span>
		</form>
	</div>
	
	<script type="text/javascript">
		showAreaTag = document.getElementById("showArea");
		
		/*18 此方法會呼叫AjaxServlet 已得到一個字串，並將字顯示在div*/
		
		/* 網頁載入後每隔1秒(1000毫秒)會呼叫此方法，更新區塊<div> */
		function doUpdate(){
			/*19 送出HTTP請求關鍵在於req變數，*/
			var req;
			if(window.XMLHttpRequest){
				req = new XMLHttpRequest();
			}else if(window.ActiveXObject){
				req = new ActiveXObject("Microsoft.XMLHTTP");
			}else{
				alert("AJAX not supported");
			}
			
			/*27 接收AJAX回應的內容 須將變數屬性「onreadystatechange」指向
				 函式表達式，或稱監聽器的方法。一旦取得回應，就會觸發監聽器方法。
			*/
			req.onreadystatechange  = function() {
				/* 已經由網站伺服器取得有效的回應 */
				if(req.readyState == 4 && req.status == 200){
					//alert(req.responseText);
					showAreaTag.innerHTML = req.responseText;
					//alert(showAreaTag.innerHTML);
				}
			}
			
			/* 34 要使用AJAX送出HTTP請求，必須包含下兩步驟 */
			req.open("GET", "<c:url value='/AjaxServlet'/>",true);
			req.send(null);
		}
		
		/* 39 */
		
		/* window.onload = function() {
			timeoutId = setInterval(function() {
				doUpdate();
			}, 1000);
		} */
		
		
		/* 測試使用學生ID是否重複 */
		function doCheck(){
			var req2;
			/* 得到瀏覽器物件 JS送出request */
			if(window.XMLHttpRequest){
				req2 = new XMLHttpRequest();
			}else if(window.ActiveXObject){
				req2 = new ActiveXObject("Microsoft.XMLHTTP");
			}else{
				alert("AJAX not supported");
			}
			
			var name = document.getElementById("name");
			var value = name.value;
			var nametip = document.getElementById("nametip");
			
		
			
			//step1: 打開request物件 默認true異步執行
			//無法傳參數name servlet無反應 ->要使用..路徑要上一層因為jsp在一個資料夾內
			//才抓得到servlet檔案
			req2.open("GET", "../AjaxServlet2?name="+value);
			//這個有反應 但就是抓不到name 
			//req2.open("GET", "<c:url value='/AjaxServlet2'/>",true);
			//step2: 發送
			req2.send(null);
			//step3:檢查request物件狀態
			req2.onreadystatechange = function(){
				//判斷response是否已經接收完成和判斷是否正常回應
				if(req2.readyState==4 && req2.status==200){
					alert("req.responseText:"+req2.responseText)
					nametip.innerText = req2.responseText;
				}
			}
		}
	</script>
</body>
</html>