<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <h2>Board List</h2>            
  <table class="table table-striped">
    <thead>
      <tr>
        <th>UserID</th>
        <th>Subject</th>
        <th>Email</th>
        <th>Content</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${arr }" var="list">
      <tr>
        <td>${list.userid }</td>
        <td><a href="detail?num=${board.num }">${list.subject }</a></td>
        <td>${list.email }</td>
        <td>${list.content }</td>
      </tr>
 	</c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>