<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
System.out.println("--ch81.jsp--");
 %>
<body>
<form:form commandName="user" method="post">
	<form:checkbox path="grant" label="grant?"/><BR/>
	<form:checkboxes items="${allHobbies}" path="hobbies"/><BR/>
	<form:checkboxes items="${allDepts}" path="deptIds" itemLabel="name" itemValue="id"/><BR/>
	<form:radiobuttons items="${ allHobbies}" path="hobby"/><br/>
	<form:select path="country">
		<form:option value="0">请选择</form:option>
		<form:options items="${allCountry }"/>
	</form:select>
	<form:select path="oneDept.id">
		<form:option value="0">请选择</form:option>
		<form:options items="${allDepts }" itemLabel="name" itemValue="id"/>
	</form:select>
	<form:button type="submit">submit</form:button>
</form:form>
</body>
</html>