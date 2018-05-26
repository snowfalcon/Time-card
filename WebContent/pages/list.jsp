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
<title>一覧画面</title>
</head>
<body onLoad="select();param();name('<%=Name%>');csv()">
	<!-- 上部 -->
	<!-- 月別送信ボックス -->
	<form method=post class="nav__item">
		<select onChange="navi(this)" id="select"></select>
	</form>
	<!-- 上位権限者 -->
	<logic:equal name="loginForm" property="inputAuth" value="2">
		<form action="listutil" method=post class="nav__item">
			<select name=namae id="shain">
				<logic:iterate id="hoge2" name="listForm" property="userObj"
					scope="request">
					<option value=<bean:write name="hoge2" property="user" />>
						<bean:write name="hoge2" property="user" />
				</logic:iterate>
			</select> <input type="submit" value="変更">
		</form>
	</logic:equal>
	<!-- 下位権限者 -->
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
	<!-- csv出力 -->
	<form class="nav__item">
		<input type="button" id="csv" value="CSV出力">
	</form>
	<!-- 上部終わり -->
	<!-- テーブル -->
	<Div Align="center">
		<table border="1" id="tbl">
			<tr>
				<td class="invis" colspan="6" Align="center"><%=Year%>年<%=Month%>月</td>
			</tr>
			<tr>
				<td class="invis" colspan="6" Align="center"><%=Name%></td>
			</tr>
			<tr>
				<th>日付</th>
				<th>曜日</th>
				<th>開始時間</th>
				<th>終了時間</th>
				<th>休憩時間</th>
				<th>作業時間</th>
			</tr>
			<!-- logic:iterateでtimeObj[arry]の値分の繰り返し -->
			<logic:iterate id="hoge1" name="listForm" property="timeObj"
				scope="request" length="${Last}">
				<logic:notEqual name="hoge1" property="week" value="土">
					<logic:notEqual name="hoge1" property="week" value="日">
						<tr Align="center">
					</logic:notEqual>
				</logic:notEqual>
				<logic:equal name="hoge1" property="week" value="土">
					<!-- 土曜 -->
					<tr Align="center" class="saturday">
				</logic:equal>
				<logic:equal name="hoge1" property="week" value="日">
					<!-- 日曜 -->
					<tr Align="center" class="sunday">
				</logic:equal>
				<td><bean:write name="hoge1" property="day" /></td>
				<td><bean:write name="hoge1" property="week" /></td>
				<td><bean:write name="hoge1" property="start" /></td>
				<td><bean:write name="hoge1" property="end" /></td>
				<td><bean:write name="hoge1" property="rest" /></td>
				<td><bean:write name="hoge1" property="work" /></td>
				<!-- <td>
					<!-- ポップアップ
					<input type="button" value="修正1"
					onClick="popup(<%=Year%>,<%=Month%>,<bean:write name="hoge1" property="day" />)">
					<!-- 標準
					<form style="margin: 0px;" method="GET"
						action="/Time-card/RevisionAction.do">
						<input type="hidden" name="YEAR" value="<%=Year%>"> <input
							type="hidden" name="MONTH" value="<%=Month%>"><input
							type="hidden" name="DAY"
							value="<bean:write name="hoge1" property="day" />"> <input
							type="submit" value="修正2">
					</form>
					<form style="margin: 0px;" method="GET"
						action="/Time-card/RevisionAction.do">
						<input type="hidden" name="S"
							value="<bean:write name="hoge1" property="start" />"> <input
							type="hidden" name="E"
							value="<bean:write name="hoge1" property="end" />">
						<input type="submit" value="修正3">
					</form>
				</td>
				-->
			</logic:iterate>
		</table>
	</Div>
	<!-- 戻る -->
	<!-- 上位権限者 -->
	<logic:equal name="loginForm" property="inputAuth" value="2">
		<input type="button" value="戻る" onclick="returnmsg()">
	</logic:equal>
	<!-- 下位権限者 -->
	<logic:equal name="loginForm" property="inputAuth" value="1">
		<input type="button" value="戻る" onclick="backmsg()">
	</logic:equal>
	<!-- ログアウト -->
	<input type="button" value="終了" onclick="logoutmsg()">
</body>
</html:html>