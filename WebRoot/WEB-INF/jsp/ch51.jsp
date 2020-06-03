<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${error }
	<form action="/ydspringmvc/ch51/map1" method="post">
		userName:<input type="text" name="userName" value="${user.userName }"/><br/>
		password:<input type="password" name="password"/><br/>
		address:<input type="text" name="address" value="${user.address }"/><br/>
		tel:<input type="text" name="tel" value="${user.tel }"/><br/>
		<!-- 对于非基本类型的属性，可以用OGNL（对象图导航语言）方式进行命名 -->
		department:<select name="dept.id">
			<option value="1">人事</option>
			<option value="2">销售</option>
		</select>
		<button type="submit">submit</button>
	</form>
</body>
</html>