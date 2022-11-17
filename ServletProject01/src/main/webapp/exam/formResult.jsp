<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름: ${person.name } / <c:out value="${person.name }" /><br/>
나이: ${person.age }<br/>
성별: ${person.gender }<br/>
관심분야: ${person.hobby }<br/>
<c:forEach items="${person.hobby }" var="h">
${h }
</c:forEach><br/>
직업: ${person.job }<br/>
</body>
</html>