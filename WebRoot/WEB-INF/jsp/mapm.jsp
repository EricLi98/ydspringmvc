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
	
	<form action="/ydspringmvc/ch33/mapm" method="post">
		userName:<input type="text" name="userName" /><br/>
		userId:<input type="text" name="u.id" /><br/>
		deptId:<input type="text" name="d.id" /><br/>
		deptName:<input type="text" name="name" /><br/>
		
		<button type="submit">submit</button>
	</form>
</body>
</html>