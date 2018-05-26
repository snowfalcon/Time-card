<%@ page contentType="text/html;charset=Shift_JIS"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<link rel="stylesheet"
	href="http://localhost:8080/Time-card/css/login.css" type="text/css">
<html:html>
<head>
<title>ログイン画面</title>
</head>
<body>
		<h1>ログイン画面</h1>
		<hr size="2" width="100%">
	<Div Align="center">
		<html:errors />
		<html:form action="/LoginAction">
			<p class="login">
			<table>
				<tr>
					<td>社員番号</td>
					<td><html:text property="inputId" size="20" maxlength="5" /></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><html:password property="inputPass" size="20"
							maxlength="12" /></td>
				</tr>
			</table>
			<!--  警告消し-->
			<p class="">
				<!-- -->
			</p>
			<br>
			<html:submit property="submit" value="ログイン" style="WIDTH: 173px" />
		</html:form>
	</Div>
</body>
</html:html>