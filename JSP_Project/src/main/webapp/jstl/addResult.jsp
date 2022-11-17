<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
request.setCharacterEncoding("utf-8"); // 인코딩하고 객체를 넣는다
// 더해야 하니까 int로 바꿔야
int num1 = Integer.parseInt(request.getParameter("num1"));
int num2 = Integer.parseInt(request.getParameter("num2"));
int sum = num1 + num2;
%>
</head>
<body>
덧샘 결과: <%=num1+num2 %><br/>
덧셈: <%=sum %>
<%
if(sum%2 == 0) {
%>
	짝수
<%
} else {
 %>
 	홀수
<%
}
%>
</body>
</html>