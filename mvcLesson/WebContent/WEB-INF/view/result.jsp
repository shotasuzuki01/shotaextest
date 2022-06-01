<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
    <%
    List<Slime> list=(List<Slime>)request.getAttribute("skey");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%for(Slime slime:list){%>
<p><%=slime.getName()%>が現れた!(<%=slime.getHp()%>)</p>
<%}%>

</body>
</html>