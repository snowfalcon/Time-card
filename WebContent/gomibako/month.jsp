<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%
	Calendar calendar = Calendar.getInstance();
	int YEAR = calendar.get(Calendar.YEAR);
	int MONTH = calendar.get(Calendar.MONTH) + 1;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--月別プルダウン
	<form method=post class="nav__item">
		<select onChange="navi(this)">
			<option value="">表示月の変更
			<option
				value="http://localhost:8080/Time-card/ListAction.do?YEAR=<%=YEAR%>&MONTH=<%=MONTH%>"><%=YEAR%>年<%=MONTH%>月
			<option
				value="http://localhost:8080/Time-card/ListAction.do?YEAR=<%=YEAR%>&MONTH=<%=MONTH - 1%>"><%=YEAR%>年<%=MONTH - 1%>月
			<option
				value="http://localhost:8080/Time-card/ListAction.do?YEAR=<%=YEAR%>&MONTH=<%=MONTH - 2%>"><%=YEAR%>年<%=MONTH - 2%>月
		</select>
	</form>
	月別入力ボックス
	<form action="/Time-card/TimecardAction.do" class="nav__item">
		西暦で年、月を入力してください<br> <input type="text" name="YEAR"
			style="width: 40px" maxlength="4">年 <input type="text"
			name="MONTH" style="width: 20px" maxlength="1">月 <input
			type="submit" value="移動">
	</form>
	-->
</body>
</html>