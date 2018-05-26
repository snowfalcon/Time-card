<%@ page contentType="text/html;charset=Shift_JIS"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@page import="java.util.Calendar"%>
<%
	Calendar calendar = Calendar.getInstance();
	int Year = calendar.get(Calendar.YEAR);
	int Month = calendar.get(Calendar.MONTH) + 1;
	Object Start = session.getAttribute("Start");
	Object End = session.getAttribute("End");
	Object Hello = session.getAttribute("Hello");
%>
<link rel="stylesheet" href="../Time-card/css/timecard.css"
	type="text/css">
<script type="text/javascript" src="../Time-card/js/timecard.js"
	charset="UTF-8"></script>
<html:html>
<head>
<title>�ō����</title>
</head>
<body>
	<!-- ���t�擾�A�����X�V -->
	<p class="date" id="RealtimeClockArea1">0000�N00��00�� �j��</p>
	<p class="time" id="RealtimeClockArea2">00:00:00</p>
	<!-- ���A -->
	<p class="hello"><%=Hello%></p>
	<!-- �{�^�� -->
	<Div Align="center">
		<form name="MyForm" action="timecardutil" method="post">
			<!-- �o�� -->
			<input type="button" value="�o��" name="MyClick"
				style="background-color: #FF6347; font-size: 50; WIDTH: 200px; HEIGHT: 100px"
				onclick="func('Start');" <%=Start%>>
			<!-- �ގ� -->
			<input type="button" value="�ގ�" name="MyClick"
				style="background-color: #7FFFD4; font-size: 50; WIDTH: 200px; HEIGHT: 100px"
				onclick="func('End');" <%=End%>><input type="hidden"
				name="MySubmit">
		</form>
		<!-- �ꗗ -->
		<form method="GET" action="/Time-card/ListAction.do">
			<input type="hidden" name="YEAR" value="<%=Year%>"> <input
				type="hidden" name="MONTH" value="<%=Month%>"> <input
				type="submit" value="�ꗗ"
				style="background-color: #00DD00; font-size: 30; WIDTH: 200px; HEIGHT: 50px">
			<!-- ���O�A�E�g -->
			<input type="button" value="���O�A�E�g"
				style="background-color: #00DD00; font-size: 30; WIDTH: 200px; HEIGHT: 50px"
				onclick="logout()">
		</form>
	</Div>
</body>
</html:html>