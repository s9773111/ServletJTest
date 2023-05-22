<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新建學生</title>
</head>
<body>
	請輸入要產生學生資料的筆數
	<!--action="${pageContext.request.contextPath}/InsertStuController"  -->
	
	<form action="/JDBCServletIsaac/InsertStuController"  method="GET">
		<input type="text" name="number" value="hello">
		<br/>
		<input type="submit" value="one">
	</form>
	
	<!-- <a href="/JDBCServletIsaac/InsertStuController?">
		<input type="text" name="number" value="1">
		<br/>
		<input type="button" value="one">
	</a> -->
	
	<a style="text-decoration: none" href="/JDBCServletIsaac/JdbcDemoController">
		<input type="button" value="allStudent">
	</a>
	
	<!--準備插入資料-->
	<br/>
	<c:choose>
		<c:when test="${not empty insertnum}">
			成功插入學生資料：${insertnum}  筆數。
		</c:when>
		<c:otherwise>
			尚未插入學生資料。
		</c:otherwise>
	</c:choose>
	
</body>
</html>