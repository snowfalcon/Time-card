<%@ page contentType="text/html;charset=Shift_JIS"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<link rel="stylesheet"
	href="http://localhost:8080/Time-card/css/login.css" type="text/css">
<html:html>
<head>
<title>���O�C�����</title>
</head>
<body>
		<h1>���O�C�����</h1>
		<hr size="2" width="100%">
	<Div Align="center">
		<html:errors />
		<html:form action="/LoginAction">
			<p class="login">
			<table>
				<tr>
					<td>�Ј��ԍ�</td>
					<td><html:text property="inputId" size="20" maxlength="5" /></td>
				</tr>
				<tr>
					<td>�p�X���[�h</td>
					<td><html:password property="inputPass" size="20"
							maxlength="12" /></td>
				</tr>
			</table>
			<!--  �x������-->
			<p class="">
				<!-- -->
			</p>
			<br>
			<html:submit property="submit" value="���O�C��" style="WIDTH: 173px" />
		</html:form>
	</Div>
</body>
</html:html>