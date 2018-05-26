<%@ page language="java" contentType="text/html; charset=windows-31j"
	pageEncoding="windows-31j"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
request.setCharacterEncoding("windows-31j");
String msg = "IDとパスワードを入力してください。";
if (session.getAttribute("login") != null &&
    !session.getAttribute("login").equals("true"))
    msg = "※ログインに失敗しました。";
Cookie[] cookies = request.getCookies();
String pre_id = "";
for(Cookie cookie:cookies)
    pre_id = cookie.getName().equals("id") ? cookie.getValue():pre_id;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
<title>JSP SAMPLE</title>
</head>
<body>
	<%=msg %><br>
	<form method="post" action="./index_action.jsp">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="id" value="<%=pre_id %>"></td>
			</tr>
			<tr>
				<td>PASS:</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>