<%@ page contentType="text/html;charset=Shift_JIS"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@page import="java.sql.*,java.util.*,java.io.*"%>
<%
	Object Last = session.getAttribute("Last");
	Object Name = session.getAttribute("Name");
	String Year = request.getParameter("YEAR");
	String Month = request.getParameter("MONTH");
%>
<script type="text/javascript" src="../Time-card/js/list.js"
	charset="UTF-8"></script>
<link rel="stylesheet" href="../Time-card/css/list.css" type="text/css">
<html:html>
<head>
<title>�ꗗ���</title>
</head>
<body onLoad="select();param();name('<%=Name%>');csv()">
	<!-- �㕔 -->
	<!-- ���ʑ��M�{�b�N�X -->
	<form method=post class="nav__item">
		<select onChange="navi(this)" id="select"></select>
	</form>
	<!-- ��ʌ����� -->
	<logic:equal name="loginForm" property="inputAuth" value="2">
		<form action="listutil" method=post class="nav__item">
			<select name=namae id="shain">
				<logic:iterate id="hoge2" name="listForm" property="userObj"
					scope="request">
					<option value=<bean:write name="hoge2" property="user" />>
						<bean:write name="hoge2" property="user" />
				</logic:iterate>
			</select> <input type="submit" value="�ύX">
		</form>
	</logic:equal>
	<!-- ���ʌ����� -->
	<logic:equal name="loginForm" property="inputAuth" value="1">
		<form action="listutil" method=post class="nav__item">
			<select name=namae id="shain" disabled>
				<logic:iterate id="hoge2" name="listForm" property="userObj"
					scope="request">
					<option value=<bean:write name="hoge2" property="user" />>
						<bean:write name="hoge2" property="user" />
				</logic:iterate>
			</select>
		</form>
	</logic:equal>
	<!-- csv�o�� -->
	<form class="nav__item">
		<input type="button" id="csv" value="CSV�o��">
	</form>
	<!-- �㕔�I��� -->
	<!-- �e�[�u�� -->
	<Div Align="center">
		<table border="1" id="tbl">
			<tr>
				<td class="invis" colspan="6" Align="center"><%=Year%>�N<%=Month%>��</td>
			</tr>
			<tr>
				<td class="invis" colspan="6" Align="center"><%=Name%></td>
			</tr>
			<tr>
				<th>���t</th>
				<th>�j��</th>
				<th>�J�n����</th>
				<th>�I������</th>
				<th>�x�e����</th>
				<th>��Ǝ���</th>
			</tr>
			<!-- logic:iterate��timeObj[arry]�̒l���̌J��Ԃ� -->
			<logic:iterate id="hoge1" name="listForm" property="timeObj"
				scope="request" length="${Last}">
				<logic:notEqual name="hoge1" property="week" value="�y">
					<logic:notEqual name="hoge1" property="week" value="��">
						<tr Align="center">
					</logic:notEqual>
				</logic:notEqual>
				<logic:equal name="hoge1" property="week" value="�y">
					<!-- �y�j -->
					<tr Align="center" class="saturday">
				</logic:equal>
				<logic:equal name="hoge1" property="week" value="��">
					<!-- ���j -->
					<tr Align="center" class="sunday">
				</logic:equal>
				<td><bean:write name="hoge1" property="day" /></td>
				<td><bean:write name="hoge1" property="week" /></td>
				<td><bean:write name="hoge1" property="start" /></td>
				<td><bean:write name="hoge1" property="end" /></td>
				<td><bean:write name="hoge1" property="rest" /></td>
				<td><bean:write name="hoge1" property="work" /></td>
				<!-- <td>
					<!-- �|�b�v�A�b�v
					<input type="button" value="�C��1"
					onClick="popup(<%=Year%>,<%=Month%>,<bean:write name="hoge1" property="day" />)">
					<!-- �W��
					<form style="margin: 0px;" method="GET"
						action="/Time-card/RevisionAction.do">
						<input type="hidden" name="YEAR" value="<%=Year%>"> <input
							type="hidden" name="MONTH" value="<%=Month%>"><input
							type="hidden" name="DAY"
							value="<bean:write name="hoge1" property="day" />"> <input
							type="submit" value="�C��2">
					</form>
					<form style="margin: 0px;" method="GET"
						action="/Time-card/RevisionAction.do">
						<input type="hidden" name="S"
							value="<bean:write name="hoge1" property="start" />"> <input
							type="hidden" name="E"
							value="<bean:write name="hoge1" property="end" />">
						<input type="submit" value="�C��3">
					</form>
				</td>
				-->
			</logic:iterate>
		</table>
	</Div>
	<!-- �߂� -->
	<!-- ��ʌ����� -->
	<logic:equal name="loginForm" property="inputAuth" value="2">
		<input type="button" value="�߂�" onclick="returnmsg()">
	</logic:equal>
	<!-- ���ʌ����� -->
	<logic:equal name="loginForm" property="inputAuth" value="1">
		<input type="button" value="�߂�" onclick="backmsg()">
	</logic:equal>
	<!-- ���O�A�E�g -->
	<input type="button" value="�I��" onclick="logoutmsg()">
</body>
</html:html>