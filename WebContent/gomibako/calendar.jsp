<%@page contentType="text/html; charset=SHIFT_JIS" %>
<%@page import="java.util.*, java.io.*" %>
<html>
<head></head>
<body>

<select>
<%
Calendar c = Calendar.getInstance();
for( int i=0; i<=4; i++ ){
String s = String.format( "%tY/%tm", c, c );
c.add( Calendar.MONTH , -1 );
%>
<option value="<%= s %>"><%= s %></option>
<% } %>
</select>

</body>
</html>