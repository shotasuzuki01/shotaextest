<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,java.text.*" %>
    <%
    for(int i=1;i<9;i++){
    	for(int j=1;j<9;j++){
    		int calc=i*j;
    	}
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<caption>九九表</caption>
    <% for(int i=1;i<10;i++){%>
    <tr>
    	<% for(int j=1;j<10;j++){%>
    	<td><%=i*j%></td>
    	<%}%>
    	</tr>
   <% }%>

</table>

</body>
</html>