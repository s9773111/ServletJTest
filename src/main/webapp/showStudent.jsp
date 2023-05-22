<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顯示學生資料</title>
</head>
<body>
	學生資料：
	<br/>
	<%-- <c:forEach items="${requestScope.list}" var="c">
		學生：${c.getSno()} ${c.getSid()}<br/>
	</c:forEach> --%>
	
	<table align="center" width="450" border="1">
		<tr>
			<td align="center" colspan="5">
				<h2>所有學生資訊</h2>
			</td>
		</tr>
		<tr align="center">
			<td><b>學號</b></td>
			<td><b>姓名</b></td>
			<td><b>年齡</b></td>
			<td><b>性別</b></td>
			<td><b>身分證</b></td>
		</tr>
		<c:forEach items="${requestScope.list}" var="c">
		<jsp:useBean id="now" class="java.util.Date" scope="page"/>
		
		
		<tr>
			<td>${c.getSno()}</td>
			<td>${c.getSname()}</td>
			<td>${c.getAge()}</td>
			<%-- <td><fmt:formatNumber value="${now.year - c.getSbday()}"/></td> --%>
			<td>${c.getSsex()}</td>
			<td>${c.getSid()}</td>
		</tr>
		</c:forEach>
	</table>
	
	<%-- <c:out value="${student}" defalut="no values"></c:out> --%>

</body>
</html>