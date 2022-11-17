<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action=detail method="get">
  <h2>Details</h2>
 
  <div class="table-responsive">
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>글번호</th>
          <th>작성자(ID)</th>
          <th>이메일</th>
          <th>글제목</th>
          <th>조회수</th>
          <th>작성일</th>      
          <th>글내용</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>"${board.num }"</td>
          <td>"${board.userid }"</td>
          <td>"${board.email }"</td>
          <td>"${board.subject }"</td>
          <td>"${board.readcount }"</td>
          <td>"${board.regdate }"</td>
          <td>"${board.content }"</td>
        </tr>
      </tbody>
    </table>
  </div>
  </form>
</div>
</body>
</html>