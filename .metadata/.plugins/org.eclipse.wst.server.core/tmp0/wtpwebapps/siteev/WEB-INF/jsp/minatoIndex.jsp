<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.SiteEV" %>
    <%
    SiteEV siteEV=(SiteEV)application.getAttribute("siteEV");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ミナトくんのページ</title>
</head>
<body>
<h1>ミナトくんのページへようこそ</h1>
<p>
<a href="/siteev/MinatoIndex?action=like">よいね</a>
<%=siteEV.getLike() %>人
<a href="/siteev/MinatoIndex?action=dislike">よくないね</a>
<%=siteEV.getDislike() %>人
</p>
<h2>みなとくんとは</h2>
<p>///</p>
</body>
</html>