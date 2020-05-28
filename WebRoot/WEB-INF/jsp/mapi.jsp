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
	${error }
	<form action="/ydspringmvc/ch33/mapi" method="post">
		userName:<input type="text" name="userName" value="${user.userName }"/><br/>
		password:<input type="password" name="password"/><br/>
		address:<input type="text" name="address" value="${user.address }"/><br/>
		<!-- 对于非基本类型的属性，可以用OGNL（对象图导航语言）方式进行命名 -->
		department:<select name="dept.id">
			<option value="1">人事</option>
			<option value="2">销售</option>
		</select>
		province:<select name="province">
			<c:forEach items="${province}" var="s">
				<option><c:out value="${s}"></c:out> </option>
			</c:forEach>
		</select>
		<button type="submit">submit</button>
	</form>
</body>
</html>