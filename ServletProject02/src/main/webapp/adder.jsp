<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addResult.do"> <!-- Java에 보내는 것, 임의의 확장자명 가능 -->
첫번째 수: <input type="text" name="num1" /><br />
두번째 수: <input type="text" name="num2"/><br />
<input type="submit" value="더하기" />
</form>
</body>
</html>