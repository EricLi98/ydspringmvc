<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
${error }
<form action="" method="post">
	userName:<input name="userName"/><br/>
	password:<input name="password"/><br/>
	address:<input name="address"/><br/>
	<button type="submit">submit</button>
</form>
 -->
 ${error }
 <form:form commandName="user" method="post"><!-- 使用form标签时，必须有一个命令对象与此表单对应 ，方便进行数据的回显-->
 	userName:<form:input path="userName"/><form:errors path="userName"></form:errors><br/><!-- 使用表单元素的标签时， 一般使用path指定命令对象的属性-->
 	password:<form:input path="password"/><form:errors path="password"></form:errors><br/>
 	address:<form:input path="address"/><form:errors path="address"></form:errors><br/>
 	<form:button type="submit">submit</form:button>
 </form:form>
</body>
</html>