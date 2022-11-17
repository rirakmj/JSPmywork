<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = jstlResult.jsp>
ID: <input type="text" name="id" id="id"><br/>
  <label for="color">Color:</label>  
  <select name="color" id="color">
    <option value="yellow">노랑</option>
    <option value="blue">blue</option>
    <option value="orange">orange</option>
    <option value="pink">pink</option>
    <option value="black">black</option>
    </select>
    <input type="submit" value="보내기">
    </form>
</body>
</html>