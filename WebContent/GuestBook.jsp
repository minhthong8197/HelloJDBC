<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th> <th>Name</th> <th>Message</th> <th></th>
		</tr>
		<c:forEach items="${newentries}" var="entry">
			<tr>
				<td>${entry.ID}</td>
				<td>${entry.name}</td>
<%-- 				<td><c:out value="${entry.message}" escapeXml="true"></c:out></td> --%>
				<td>${entry.message}</td>
				<td><a href = "#">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<a href = "AddComment.jsp">Add Comment</a>
</body>
</html>