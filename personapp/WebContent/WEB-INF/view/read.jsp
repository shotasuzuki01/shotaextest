<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
    <%
    List<Person>list=(List<Person>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/personapp/Create">新規追加</a>
<% if(list !=null && list.size()>0){%>
<table border="1">
<%for(Person person:list) {%>
<tr>
<td><%=person.getId() %></td>
<td><%=person.getName() %></td>
<td><%=person.getAge() %></td>
<td>
<a href="/personapp/Update?id=<%=person.getId() %>">更新</a>
<a href="/personapp/Delete?id=<%=person.getName() %>"onclick="return confirm('name=<%=person.getName() %>を削除していいですか?');">削除</a>
</td>
</tr>
<%} %>
</table>
<%} %>
</body>
</html>