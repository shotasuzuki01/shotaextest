<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<form action="/sessionex2/RegisterUser" method="post">
<table>
<caption>お問い合わせフォーム</caption>
<tr>
<td>お名前</td>
<td><input type="text" name="name"><br>
</tr>
<tr>
<td>メールアドレス</td>
<td><input type="text" name="text"><br>
<tr>
</tr>
<tr>
<td>お問い合わせ</td>
<td><textarea name="otoiawase"rows="4"cols="40"></textarea><br>
</tr>
</table>
<input type="submit" value="確認"><br>

</body>
</html>