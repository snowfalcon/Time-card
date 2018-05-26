<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%
Object s = session.getAttribute("s");
Object e = session.getAttribute("e");
%>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修正画面</title>
</head>
<body>
<%=s%>
<%=e%>
</body>
</html:html>