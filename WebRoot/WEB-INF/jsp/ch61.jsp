<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
totalCount:${user.fm.totalCount}<br>
totalCount:<spring:bind path="user.fm.totalCount">${status.value}</spring:bind><br>
orderDate:<spring:bind path="user.fm.orderDate">${status.value}</spring:bind>
</body>
</html>